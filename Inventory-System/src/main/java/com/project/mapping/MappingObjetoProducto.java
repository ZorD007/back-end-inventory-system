package com.project.mapping;

import com.project.dto.ResponseDtoProducto;
import com.project.model.Producto;
import com.project.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingObjetoProducto {

    public ResponseDtoProducto transformarProductoResponseDto(Producto producto) throws Exception{
        ResponseDtoProducto responseDtoProducto = null;
       try{
           if (null != producto){
               responseDtoProducto = new ResponseDtoProducto();
               responseDtoProducto.setIdProductoDto(producto.getIdProducto());
               responseDtoProducto.setCantidadDto(producto.getCantidad());
               responseDtoProducto.setFechaProductoDto(producto.getFechaProducto());
               responseDtoProducto.setSistemaOperativoDto(producto.getSistemaOperativo());
               responseDtoProducto.setModeloDto(producto.getModelo());
               responseDtoProducto.setPrecioDto(producto.getPrecio());
               // aqui agrego la marca a la tabla
               responseDtoProducto.setMarcaDto(producto.getMarca().getNombreMarca());
           }
       } catch (Exception ex){
           ex.printStackTrace();
           throw new Exception(Constant.ERROR_SISTEMA);
       }
       return responseDtoProducto;
    }

    public Producto transformarOptionaProducto(Optional<Producto> productoOptional) throws Exception {
       Producto producto = null;
        try {
            if(productoOptional.isPresent()){
                producto = new Producto();
                producto.setPrecio(productoOptional.get().getPrecio());
                producto.setCantidad(productoOptional.get().getCantidad());
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return producto;
    }
}
