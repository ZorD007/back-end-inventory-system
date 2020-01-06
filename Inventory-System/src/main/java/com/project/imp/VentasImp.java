package com.project.imp;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ResponseDtoVentas;
import com.project.mapping.MappingObjetoVentas;
import com.project.model.Ventas;
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
    private VentasRepository ventasRepository;

    @Autowired
    private MappingObjetoVentas mappingObjetoVentas;

    @Override
    public List<Ventas> reporteDeGanancias(Date fechaInicio, Date fechaFin) throws Exception {
        List<Ventas> ventas;
        try{
            List<Ventas> listaVentas = ventasRepository.findVentasByDate(fechaInicio, fechaFin);
            ventas = new ArrayList<Ventas>();


        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return null;
    }

    @Override
    public Ventas venderProductos(ReqDtoVentas reqDtoVentas) throws Exception {
        return null;
    }

    @Override
    public ResponseDtoVentas mostrarVenta(ReqDtoVentas reqDtoVentas) throws Exception {
        return null;
    }
}
