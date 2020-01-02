package com.project.mapping;

import com.project.dto.ResponseDtoProducto;
import com.project.model.Producto;
import com.project.util.Constant;
import org.springframework.stereotype.Service;

@Service
public class MappingObjetoProducto {

    public ResponseDtoProducto transformarProductoResponseDto(Producto producto) throws Exception{
        ResponseDtoProducto responseDtoProducto = null;
       try{
           if (null != producto){
               responseDtoProducto = new ResponseDtoProducto();
               responseDtoProducto.setIdProductoDto(producto.getIdProducto());
           }
       } catch (Exception ex){
           ex.printStackTrace();
           throw new Exception(Constant.ERROR_SISTEMA);
       }
       return responseDtoProducto;
    }
}
