package com.project.controller;

import com.project.dto.ReqDtoProducto;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.imp.ProductoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    @Autowired
    private ProductoImp productoImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> agregarProducto(@RequestBody ReqDtoProducto reqDtoProducto){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(productoImp.agregarProducto(reqDtoProducto), HttpStatus.OK);
        }catch (NoGuardadoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Object> modificarProducto(@PathVariable Long id,@RequestBody ReqDtoProducto reqDtoProducto){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(productoImp.modificarProducto(id,reqDtoProducto),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return  rs;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarProducto(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(productoImp.eliminarProducto(id),HttpStatus.OK);
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return  rs;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<Object> listarProducto(){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(productoImp.listarProducto(),HttpStatus.OK);
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return  rs;
    }
}
