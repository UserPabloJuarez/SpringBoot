package edu.cibertec.matricula.controller;

import edu.cibertec.matricula.dao.entity.UsuarioEntity;
import edu.cibertec.matricula.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Value("${aplicacion.nombre}")
    private String nombreApp;

    @RequestMapping("/")
    public String loginMostrar() {
        return "login";
    }

    @RequestMapping("loginAccion")
    public ModelAndView loginAccion(UsuarioEntity usuarioValida,
            HttpServletRequest request) {
        ModelAndView mv = null;
        UsuarioEntity ue = usuarioService.validaLogin(usuarioValida);
        if (ue == null) {
            mv = new ModelAndView("login", "msgError", "Usuario y clave no existen. Vuelva a intentar!");
        } else {
            request.getServletContext().setAttribute("nomApp", nombreApp);
            mv = new ModelAndView("menu", "usuario", ue);
        }
        return mv;
    }
}
