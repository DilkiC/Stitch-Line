package com.maharaja.stitchline.service;

import com.maharaja.stitchline.entity.Role;
import com.maharaja.stitchline.entity.User;
import com.maharaja.stitchline.repo.RoleRepo;
import com.maharaja.stitchline.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

/**
 * @author Dilki Cooray <dilkicooray97@gmal.com>
 * @since 12/3/2021
 **/
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public User findUserByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public void saveUser (User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
         Role userRole = roleRepo.findByRole("ADMIN");
         user.setRoles(new HashSet<>(Arrays.asList(userRole)));
         userRepo.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);

        if(user!=null){
            List<GrantedAuthority> authorities=getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user,authorities);
        }else {
            throw new UsernameNotFoundException("user name not found");
        }


    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);

    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach(role -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });

        List<GrantedAuthority> grantedAuthorities=new ArrayList<>(roles);

        return grantedAuthorities;
    }
}
