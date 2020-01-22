package com.project.controller;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ReqDtoVentasM;
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
    public ResponseEntity<Object> mostrarVenta(@RequestBody ReqDtoVentasM reqDtoVentas) {
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(ventasImp.mostrarVenta(reqDtoVentas), HttpStatus.OK);
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
