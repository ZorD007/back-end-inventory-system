package com.project.controller;

import com.project.dto.ReqDtoRol;
import com.project.dto.ReqDtoSucursal;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.imp.SucursalImp;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/sucursal")
public class SucursalController {

    @Autowired
    private SucursalImp sucursalImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> agregarSucursal(@RequestBody ReqDtoSucursal reqDtoSucursal){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(sucursalImp.agregarSucursal(reqDtoSucursal), HttpStatus.OK);
        }catch (NoGuardadoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarSucursal(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(sucursalImp.eliminarSucursal(id),HttpStatus.OK);
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return  rs;
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> buscarPorId(@PathVariable  Long id){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(sucursalImp.buscarPorId(id), HttpStatus.OK);
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_MODIFIED);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> modificarSucursal(@PathVariable  Long id, @RequestBody ReqDtoSucursal reqDtoSucursal){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(sucursalImp.modificarSucursal(id, reqDtoSucursal), HttpStatus.OK);
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_MODIFIED);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<Object> listarSucursal(){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(sucursalImp.listarSucursal(), HttpStatus.OK);
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_MODIFIED);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

}
