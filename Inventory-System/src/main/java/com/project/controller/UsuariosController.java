package com.project.controller;

import com.project.dto.ReqDtoUsuario;
import com.project.exception.NoGuardadoException;
import com.project.exception.NoValidarSesionException;
import com.project.imp.UsuarioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioImp usuarioImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> registrarUsuario(@RequestBody ReqDtoUsuario reqDtoUsuario){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(usuarioImp.registrarUsuario(reqDtoUsuario), HttpStatus.OK);
        }catch (NoGuardadoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.POST)
    public ResponseEntity<Object> validarSesion(@RequestBody ReqDtoUsuario reqDtoUsuario){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(usuarioImp.validarSesion(reqDtoUsuario), HttpStatus.OK);
        }catch (NoValidarSesionException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }
}
