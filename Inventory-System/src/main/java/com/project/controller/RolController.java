package com.project.controller;

import com.project.dto.ReqDtoRol;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.imp.RolImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/roles")
public class RolController {

    @Autowired
    private RolImp rolImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> agregarRol(@RequestBody ReqDtoRol reqDtoRol) {
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(rolImp.añadirRol(reqDtoRol), HttpStatus.OK);
        } catch (NoGuardadoException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(rolImp.buscarPorId(id), HttpStatus.OK);
        } catch (NoEncontradoException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

}
