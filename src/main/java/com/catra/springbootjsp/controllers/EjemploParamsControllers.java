package com.catra.springbootjsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsControllers {


    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("resultado", "Esto es el res de: ");
        return "params/index";
    }


    @GetMapping("/string")
    public String param(@RequestParam(value = "textY", required = false, defaultValue = "algun valor...") String textoX, Model model){

        model.addAttribute("resultado", "El texto enviado es: "+ textoX);

        return "params/ver";

    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){

        model.addAttribute("resultado",
                "El saludo enviado es: " +
                        saludo + "num: " + numero);

        return "params/ver";

    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        }catch (NumberFormatException e){
            numero = 0;
        }
        String saludo = request.getParameter("saludo");

        model.addAttribute("resultado",
                "El saludo enviado es: " +
                        saludo + "num: " + numero);

        return "params/ver";

    }


}
