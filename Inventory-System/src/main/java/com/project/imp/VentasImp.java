package com.project.imp;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ResponseDtoVentas;
import com.project.exception.NoMostrarException;
import com.project.mapping.MappingObjetoVentas;
import com.project.model.Ventas;
import com.project.repository.UsuarioRepository;
import com.project.repository.VentasRepository;
import com.project.service.IVentasService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
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
    public ResponseDtoVentas mostrarVenta(ReqDtoVentas reqDtoVentas) throws Exception {
        ResponseDtoVentas ventasDtoLocal;
        Ventas ventaLocal;
        try {
            Ventas validateSell = ventasRepository.findByDateAndSeller(reqDtoVentas.getRangoFechaDto(), usuarioRepository.findByUserName(reqDtoVentas.getVendedorDto()));
            if (validateSell != null){
                ventaLocal = validateSell;
                ventasDtoLocal = mappingObjetoVentas.transformModeltoResponse(ventaLocal);
            }else {
                throw new NoMostrarException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (NoMostrarException ex){
            ex.printStackTrace();
            throw new NoMostrarException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
       return ventasDtoLocal;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //formato de fecha
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
