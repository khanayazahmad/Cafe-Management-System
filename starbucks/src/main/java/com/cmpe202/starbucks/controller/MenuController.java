package com.cmpe202.starbucks.controller;

import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.beans.BeanUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cmpe202.starbucks.dto.MenuDto;
import com.cmpe202.starbucks.model.response.MenuResponseModel;
import com.cmpe202.starbucks.service.MenuService;

@RestController
@RequestMapping(value = "api/menu")
public class MenuController {
	private final MenuService menuService;
	
	@Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/addMenuItem")
	@PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody
    MenuResponseModel addMenuItem(@RequestBody MenuDto menuDto){
		
		MenuResponseModel returnModel = new MenuResponseModel();
		MenuDto returnedDto = new MenuDto();
		returnedDto =  menuService.addMenuItem(menuDto);
		
		ModelMapper mapper = new ModelMapper();
		mapper = new ModelMapper();
		returnModel = mapper.map(returnedDto, MenuResponseModel.class);
		
		return returnModel;
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/getMenu")
    public @ResponseBody
    ArrayList<MenuResponseModel> getMenu(){
		
		ArrayList<MenuResponseModel> returnModel = new ArrayList<MenuResponseModel>();
		MenuResponseModel singleResponseModel;
		ArrayList<MenuDto> retrunedDto = new ArrayList<MenuDto>();
		
		retrunedDto =  menuService.getMenu();
		
		Iterator menuItemsDtoIterator = retrunedDto.iterator(); 
		
		while(menuItemsDtoIterator.hasNext())
		{
			singleResponseModel = new MenuResponseModel();
			BeanUtils.copyProperties(menuItemsDtoIterator.next(), singleResponseModel);
			returnModel.add(singleResponseModel);
		}
        return returnModel;
    }
}

