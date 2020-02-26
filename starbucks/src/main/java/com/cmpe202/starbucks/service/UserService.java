package com.cmpe202.starbucks.service;

import com.cmpe202.starbucks.dto.CurrentUserDto;
import com.cmpe202.starbucks.security.IPermissionRepository;
import com.cmpe202.starbucks.security.Permission;
import com.cmpe202.starbucks.security.StarbucksUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.cmpe202.starbucks.dto.UserDto;
import com.cmpe202.starbucks.model.User;
import com.cmpe202.starbucks.repository.IUserRepository;

@Service
public class UserService {
	private final IUserRepository userRep ;
	private final IPermissionRepository permissionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserRepository userRep, IPermissionRepository permissionRepository){
        this.userRep = userRep;
        this.modelMapper = new ModelMapper();
        this.permissionRepository = permissionRepository;
    }

    
    public UserDto resgiterUser(UserDto accountDto) throws Exception {
    	User returnedItem = new User(); 
    	UserDto dtoToReturn = new UserDto();
    	
        if (userRep.findByUsername(accountDto.getUsername())!=null) {
            throw new Exception(
              "There is an account with that email adress:" + accountDto.getUsername());
        }
        
        User user = new User();
        user.setFirstname(accountDto.getFirstname());
        user.setUsername(accountDto.getUsername());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));

        Permission permission = new Permission();
        permission.setPermission("USER");
        permission.setUsername(user.getUsername());


        returnedItem = userRep.save(user);
        permissionRepository.save(permission);
         
        BeanUtils.copyProperties(returnedItem, dtoToReturn);
        
        return dtoToReturn;
    }

    public CurrentUserDto getCurrentUserDto(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.isAuthenticated()){
            CurrentUserDto currentUserDto = modelMapper.map(((StarbucksUserDetails)auth.getPrincipal()).getUser(),CurrentUserDto.class);
            return currentUserDto;
        }

        return new CurrentUserDto(-1,"Guest","na");


    }

}
