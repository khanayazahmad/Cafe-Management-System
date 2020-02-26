package com.cmpe202.starbucks.service;

import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.beans.BeanUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cmpe202.starbucks.dto.MenuDto;
import com.cmpe202.starbucks.model.Menu;
import com.cmpe202.starbucks.repository.IMenuRepository;

@Service
public class MenuService {
	private final IMenuRepository menuRep ;
    private final ModelMapper modelMapper;
    
    @Autowired
    public MenuService(IMenuRepository menuRep){
        this.menuRep = menuRep;
        this.modelMapper = new ModelMapper();
    }
    
    public MenuDto addMenuItem(MenuDto menuDto){
    	Menu returnedItem = new Menu(); 
    	MenuDto dtoToReturn = new MenuDto();
    	
        Menu newMenuItem = modelMapper.map(menuDto, Menu.class);
        returnedItem = menuRep.save(newMenuItem);
        dtoToReturn = modelMapper.map(returnedItem, MenuDto.class);
        
        return dtoToReturn;
    }
    
    public ArrayList<MenuDto> getMenu(){
    	ArrayList<Menu> returnedItems = new ArrayList<Menu>(); 
    	MenuDto singleMenuItemDto;
    	ArrayList<MenuDto> dtoToReturn = new ArrayList<MenuDto>();
    	 
        returnedItems = (ArrayList<Menu>) menuRep.findAll();
       
		Iterator menuItemsIterator = returnedItems.iterator(); 
		
		while(menuItemsIterator.hasNext())
		{
			singleMenuItemDto = new MenuDto();
			BeanUtils.copyProperties(menuItemsIterator.next(), singleMenuItemDto);
			dtoToReturn.add(singleMenuItemDto);
		}
        return dtoToReturn;
    }
}
