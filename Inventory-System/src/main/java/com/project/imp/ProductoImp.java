package com.project.imp;

import com.project.dto.ReqDtoProducto;
import com.project.dto.ResponseDtoProducto;
import com.project.exception.NoGuardadoException;
import com.project.mapping.MappingObjetoProducto;
import com.project.model.Producto;
import com.project.repository.ProductoRepository;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoImp {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private MappingObjetoProducto transformarObjetos;

    public ResponseDtoProducto agregarProducto(ReqDtoProducto reqDtoProducto) throws Exception{
        ResponseDtoProducto responseDtoProducto;
        Producto productoLocal;

        try{
            productoLocal = new Producto();
            productoLocal.setCantidad(reqDtoProducto.getCantidadDto());
            productoLocal.setFechaProducto(reqDtoProducto.getFechaProductoDto());
            productoLocal.setMarca(reqDtoProducto.getMarcaDto());
            productoLocal.setModelo(reqDtoProducto.getModeloDto());
            productoLocal.setPrecio(reqDtoProducto.getPrecioDto());
            productoLocal.setSistemaOperativo(reqDtoProducto.getSistemaOperativoDto());
            productoLocal.setFechaProducto(reqDtoProducto.getFechaProductoDto());

            responseDtoProducto = transformarObjetos.transformarProductoResponseDto(productoRepository.save(productoLocal));

        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return responseDtoProducto;
    }
}
