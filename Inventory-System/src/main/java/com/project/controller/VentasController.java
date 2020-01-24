package com.project.controller;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ReqDtoVP;
import com.project.exception.NoEncontradoException;
import com.project.imp.VentasImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/ventas")
public class VentasController {

    @Autowired
    private VentasImp ventasImp;

    @RequestMapping(value = "/reporte", method = RequestMethod.GET)
    public ResponseEntity<Object> reporteGanancias(@RequestParam Date fechaInicio, @RequestParam Date fechaFin){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(ventasImp.reporteDeGanancias(fechaInicio, fechaFin), HttpStatus.OK);
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/mostrar", method = RequestMethod.PUT)
    public ResponseEntity<Object> mostrarVenta(@RequestBody ReqDtoVP reqDtoVP) {
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(ventasImp.mostrarVenta(reqDtoVP), HttpStatus.OK);
        } catch (NoEncontradoException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/vender", method = RequestMethod.POST)
    public ResponseEntity<Object> venderProducto(@RequestBody ReqDtoVentas reqDtoVentas){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(ventasImp.venderProductos(reqDtoVentas), HttpStatus.OK);
        } catch (NoEncontradoException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }
}
