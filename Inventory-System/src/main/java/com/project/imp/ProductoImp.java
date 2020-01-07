package com.project.imp;

import com.project.dto.ReqDtoProducto;
import com.project.dto.ResponseDtoProducto;
import com.project.exception.NoActualizarException;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.mapping.MappingObjetoProducto;
import com.project.model.Producto;
import com.project.repository.ProductoRepository;
import com.project.service.IProductoService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoImp implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private MappingObjetoProducto transformarObjetos;

    @Override
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

    @Override
    public ResponseDtoProducto modificarProducto(Long id, ReqDtoProducto reqDtoProducto) throws Exception {
        ResponseDtoProducto responseDtoProducto= null;
        try{

            Producto producto = productoRepository.findById(id).get();
            if(null != reqDtoProducto){

                producto.setCantidad(reqDtoProducto.getCantidadDto());
                producto.setPrecio(reqDtoProducto.getPrecioDto());
                //producto.setIdProducto(reqDtoProducto.getIdProductoDto());
                //producto.setFechaProducto(reqDtoProducto.getFechaProductoDto());
                //producto.setMarca(reqDtoProducto.getMarcaDto());
                //producto.setModelo(reqDtoProducto.getModeloDto());
                //producto.setSistemaOperativo(reqDtoProducto.getSistemaOperativoDto());
                //producto.setFechaProducto(reqDtoProducto.getFechaProductoDto());

                Producto productoActualizado = productoRepository.save(producto);
                responseDtoProducto = transformarObjetos.transformarProductoResponseDto(productoActualizado);
            }else{
                throw new NoActualizarException(Constant.ERROR_ACTUALIZAR);
            }
        }catch(Exception ex){

            ex.printStackTrace();
        }
        return responseDtoProducto;
    }

    @Override
    public Producto buscarPorId(Long id) throws Exception {

        Producto productoLocal;
        try{
            productoLocal = transformarObjetos.transformarOptionaProducto(productoRepository.findById(id));
            if(null == productoLocal){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return productoLocal;
    }

    @Override
    public boolean eliminarProducto(Long id) throws Exception {
        try{

           Producto producto = transformarObjetos.transformarOptionaProducto(productoRepository.findById(id));
            if(null == producto){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }else{
                productoRepository.deleteById(id);
                return true;
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
    }

    @Override
    public List<ResponseDtoProducto> listarProducto() throws Exception {

        List<ResponseDtoProducto> listProducto = new ArrayList<>();
        try {
            List<Producto> productos = productoRepository.findAll();
            for(Producto p : productos){
                listProducto.add(  transformarObjetos.transformarProductoResponseDto( p ));
            }

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return listProducto;
    }

}
