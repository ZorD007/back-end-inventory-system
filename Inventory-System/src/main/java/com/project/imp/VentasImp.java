package com.project.imp;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ResponseDtoVentas;
import com.project.exception.NoEncontradoException;
import com.project.mapping.MappingObjetoVentas;
import com.project.model.Ventas;
import com.project.repository.UsuarioRepository;
import com.project.repository.VentasRepository;
import com.project.service.IVentasService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VentasImp implements IVentasService {

    @Autowired
    private ProductoImp productoImp;

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MappingObjetoVentas mappingObjetoVentas;

    @Override
    public List<Ventas> reporteDeGanancias(Date fechaInicio, Date fechaFin) throws Exception {
        List<Ventas> listaVentas = new ArrayList<Ventas>();
        try{
            List<Ventas> encontrarVentas = ventasRepository.findVentasByDate(fechaInicio, fechaFin);
            if (encontrarVentas != null){
                listaVentas.addAll(encontrarVentas);
            }

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return listaVentas;
    }

    @Override
    public Ventas venderProductos(ReqDtoVentas reqDtoVentas) throws Exception {
        return null;
    }

    @Override
    public ResponseDtoVentas mostrarVenta(Date fechaVenta) throws Exception {
        ResponseDtoVentas responseDtoVentas = null;
        Ventas ventasLocal = null;
        try {
            Ventas validarVenta = ventasRepository.findByFechaVenta(fechaVenta);
            if (validarVenta != null){
                responseDtoVentas = mappingObjetoVentas.transformModeltoResponse(ventasLocal);
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return responseDtoVentas;
    }
}