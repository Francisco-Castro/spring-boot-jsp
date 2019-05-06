package com.catra.springbootjsp.controllers;


import com.catra.springbootjsp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class IndexController {


    @GetMapping({"/index","/","/home"})
    public String index(Map<String, Object> map) {
        map.put("titulo","Hola SpringFramework con Map");
        return "index";
    }

    @GetMapping("/index-mv")
    public ModelAndView indexMV(ModelAndView mv){
        mv.addObject("titulo", "Model and view");
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/index-model")
    public String indexMV(Model model){
        model.addAttribute("titulo", "Just Model");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        User user = new User();
        user.setFirstName("Pablito");
        user.setLastName("Ruiz");
        user.setEmail("someemail@email.com");
        model.addAttribute("usuario", user);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(user.getFirstName()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){

        model.addAttribute("titulo", "Listado de usuarios");

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<User> poblarUsuarios(){
        List<User> usuarios = Arrays.asList(
                new User("fName1", "lName1", "email1"),
                new User("fName2", "lName2", "email2"),
                new User("fName3", "lName3", "email3")
        );
        return usuarios;
    }


}
