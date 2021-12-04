package com.maharaja.stitchline.controller;

import com.maharaja.stitchline.entity.User;
import com.maharaja.stitchline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Dilki Cooray <dilkicooray97@gmal.com>
 * @since 12/4/2021
 **/
@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/signup" ,method = RequestMethod.GET)
    public ModelAndView signup(){
        ModelAndView modelAndView=new ModelAndView();
        User user=new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView createNewUser(User user, BindingResult bindingResult){
        ModelAndView modelAndView=new ModelAndView();
        User userExists=userService.findUserByUsername(user.getUsername());
        if(userExists!=null){
            bindingResult.rejectValue("username","error.user","user already registererd");

        }
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("signup");
        }else {
            userService.saveUser(user);
            modelAndView.addObject("success","successfully registered");
            modelAndView.addObject("user",new User());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public ModelAndView dashboard(){
        ModelAndView modelAndView=new ModelAndView();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        User user=userService.findUserByUsername(auth.getName());
        modelAndView.addObject("currentuser",user);
        modelAndView.addObject("name","welcome"+user.getName());
        modelAndView.addObject("adminmessge","avalable with admin role");
        modelAndView.setViewName("dashboard");
        return modelAndView;

    }

    @RequestMapping(value ={"/", "/home"},method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;

    }


}
