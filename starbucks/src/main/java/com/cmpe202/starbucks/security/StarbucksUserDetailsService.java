package com.cmpe202.starbucks.security;

import com.cmpe202.starbucks.model.User;
import com.cmpe202.starbucks.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarbucksUserDetailsService implements UserDetailsService {

    private final IUserRepository userRepository;
    private final com.cmpe202.starbucks.security.IPermissionRepository IPermissionRepository;

    public StarbucksUserDetailsService(IUserRepository userRepository, IPermissionRepository authGroupRepository){
        super();
        this.userRepository = userRepository;
        this.IPermissionRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if(null==user){
            throw new UsernameNotFoundException("cannot find username: " + username);
        }
        List<Permission> permissions = this.IPermissionRepository.findByUsername(username);
        return new StarbucksUserDetails(user, permissions);
    }
}
