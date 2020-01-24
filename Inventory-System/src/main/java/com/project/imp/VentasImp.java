package com.project.imp;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ReqDtoVP;
import com.project.dto.ResponseDtoVentas;
import com.project.dto.ResponseDtoVentasProducto;
import com.project.exception.NoEncontradoException;
import com.project.mapping.MappingObjetoVentas;
import com.project.mapping.MappingObjetoVentasProducto;
import com.project.model.*;
import com.project.repository.*;
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
    private ProductoRepository productoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private VentasProductoRepository ventasProductoRepository;

    @Autowired
    private MappingObjetoVentas mappingObjetoVentas;

    @Autowired
    private MappingObjetoVentasProducto ma;

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
    public ResponseDtoVentasProducto venderProductos(ReqDtoVentas reqDtoVentas) throws Exception {
        ResponseDtoVentasProducto dtoVentasProducto = null;
        Ventas ventasLocal = null;
        VentasProducto ventasProductoLocal = null;

        try{
            Usuario validarUsuario = usuarioRepository.findByUserName(reqDtoVentas.getVendedorDto());
            Sucursal sucursal = sucursalRepository.findByNombreSucursal(reqDtoVentas.getNombreSucursalDto());
            Producto producto = productoRepository.findByModelo(reqDtoVentas.getModeloDto());
            if(validarUsuario != null && sucursal != null){
                ventasLocal = new Ventas();
                ventasLocal.setUsuario(validarUsuario);
                ventasLocal.setSucursal(sucursal);
                ventasLocal.setFechaVenta(reqDtoVentas.getFechaVentaDto());
                ventasLocal.setCantidadVendidos(reqDtoVentas.getCantidadVendidosDto());


                ventasProductoLocal = ventasProductoRepository.save(ma.transformarAVentasProducto(ventasLocal, producto));

                dtoVentasProducto = ma.transformModelToResponse(ventasProductoLocal);

            }
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return dtoVentasProducto;
    }


    @Override
    public List<ResponseDtoVentas> mostrarVenta(ReqDtoVP reqDtoVP) throws Exception {
        List<ResponseDtoVentas> DtoVentasLista = new ArrayList<>();
        Ventas ventasLocal;
        try {
            Ventas validarVenta = ventasRepository.findByFechaVenta(reqDtoVP.getFechaDto());
            if (validarVenta != null){
                //VentasProducto buscarProducto = ventasProductoRepository.findProducto();
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