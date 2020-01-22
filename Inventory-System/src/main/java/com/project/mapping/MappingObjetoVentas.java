package com.project.mapping;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ResponseDtoVentas;
import com.project.model.*;
import com.project.util.Constant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MappingObjetoVentas {

    public Ventas transformDtotoModel(ReqDtoVentas reqDtoVentas, Usuario usuario, Sucursal sucursal) throws Exception{
        Ventas ventasLocales;
        try{
            ventasLocales = new Ventas();
            ventasLocales.setUsuario(usuario);
            ventasLocales.setSucursal(sucursal);
            ventasLocales.setFechaVenta(reqDtoVentas.getRangoFechaDto());

        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return ventasLocales;
    }

    public ResponseDtoVentas transformModeltoResponse(Ventas ventas) throws Exception{
        ResponseDtoVentas responseDtoVentasLocal;
        try{
            responseDtoVentasLocal = new ResponseDtoVentas();
            responseDtoVentasLocal.setFechaDto(ventas.getFechaVenta());
            responseDtoVentasLocal.setCantidadVendidoDto(ventas.getCantidadVentas());
            responseDtoVentasLocal.setNombreVendedorDto(ventas.getUsuario().getNombreUsuario());
            List<VentasProducto> ventasProductoList = new ArrayList<>();
            for(VentasProducto vp : ventas.getVentasL() ){
                vp.getProducto().getMarca();
                vp.getProducto().getCantidad();
                vp.getProducto().getPrecioCompra();
                vp.getProducto().getPrecioVenta();
                vp.getProducto().getModelo();
                vp.getProducto().getSistemaOperativo();
                vp.getProducto().getFechaProducto();
                ventasProductoList.add(vp);
            }
            responseDtoVentasLocal.getProductoDto().setProductoL(ventasProductoList);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return responseDtoVentasLocal;
    }
}
