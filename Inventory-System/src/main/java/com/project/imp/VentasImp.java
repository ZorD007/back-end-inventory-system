package com.project.imp;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ReqDtoVentas2;
import com.project.dto.ResponseDtoVentas;
import com.project.exception.NoEncontradoException;
import com.project.mapping.MappingObjetoVentas;
import com.project.model.Sucursal;
import com.project.model.Usuario;
import com.project.model.Ventas;
import com.project.model.VentasProducto;
import com.project.repository.SucursalRepository;
import com.project.repository.UsuarioRepository;
import com.project.repository.VentasProductoRepository;
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
    private SucursalRepository sucursalRepository;

    @Autowired
    private VentasProductoRepository ventasProductoRepository;

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
        Ventas ventasLocal = null;
        VentasProducto ventasProductoLocal = null;

        try{
            Usuario validarUsuario = usuarioRepository.findByUserName(reqDtoVentas.getVendedorDto());
            Sucursal sucursal = sucursalRepository.findByNombre(reqDtoVentas.getNombreSucursalDto());
            if(validarUsuario != null && sucursal != null){
                ventasLocal = new Ventas();
                ventasLocal.setUsuario(validarUsuario);
                ventasLocal.setSucursal(sucursal);
                ventasLocal.setFechaVenta(reqDtoVentas.getFechaVentaDto());
                ventasLocal.setNuOperacion(ventasLocal.getIdVentas());
                ventasLocal.setCantidadVendidos(reqDtoVentas.getCantidadVendidosDto());






            }
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return ventasLocal;
    }


    @Override
    public List<ResponseDtoVentas> mostrarVenta(ReqDtoVentas2 reqDtoVentas2) throws Exception {
        List<ResponseDtoVentas> DtoVentasLista = new ArrayList<>();
        Ventas ventasLocal;
        try {
            Ventas validarVenta = ventasRepository.findByFechaVenta(reqDtoVentas2.getFechaDto());
            if (validarVenta != null){
                VentasProducto buscarProducto = ventasProductoRepository.findProducto()
                ventasLocal = validarVenta;
                DtoVentasLista.add(mappingObjetoVentas.transformModeltoResponse(ventasLocal));
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return DtoVentasLista;
    }
}