package com.project.imp;

import com.project.dto.ReqDtoMarca;
import com.project.dto.ResponseDtoMarca;
import com.project.dto.ResponseDtoProducto;
import com.project.exception.NoActualizarException;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.mapping.MappingObjetoMarca;
import com.project.model.Marca;
import com.project.model.Producto;
import com.project.repository.MarcaRepository;
import com.project.service.IMarcaService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaImp implements IMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MappingObjetoMarca mappingObjetoMarca;

    @Override
    public ResponseDtoMarca agregarMarca(ReqDtoMarca reqDtoMarca) throws Exception{
        ResponseDtoMarca responseDtoMarca;
        Marca marcaLocal;
        try{
            Marca validarMarca = marcaRepository.findByNombreMarca(reqDtoMarca.getNombreMarcaDto());
            if(validarMarca == null){
                marcaLocal = new Marca();
                marcaLocal.setNombreMarca(reqDtoMarca.getNombreMarcaDto());
                responseDtoMarca = mappingObjetoMarca.transformModelaResponse(marcaRepository.save(marcaLocal));
            }else{
                throw new NoGuardadoException(Constant.ERROR_GUARDAR);
            }
        }catch(NoGuardadoException ex){
            ex.printStackTrace();
            throw new NoGuardadoException(ex.getMessage());
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return responseDtoMarca;
    }

    @Override
    public boolean eliminarMarca(Long id) throws Exception {
        try {
            Marca marcaLocal = mappingObjetoMarca.transformOptionalaModel(marcaRepository.findById(id));
            if (marcaLocal == null) {
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            } else {
                marcaRepository.deleteById(id);
                return true;
            }
        }catch(NoEncontradoException ex) {
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch(Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
    }

    @Override
    public Marca buscarPorId(Long id) throws Exception {
        Marca marcaLocal;
        try{
            marcaLocal = mappingObjetoMarca.transformOptionalaModel(marcaRepository.findById(id));
            if(null == marcaLocal){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return marcaLocal;
    }

    @Override
    public List<ResponseDtoMarca> listarMarca() throws Exception {
        List<ResponseDtoMarca> listMarca = new ArrayList<>();
        try {
            List<Marca> marcas = marcaRepository.findAll();
            for(Marca m : marcas){
                listMarca.add(mappingObjetoMarca.transformModelaResponse(m));
            }

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return listMarca;
    }

    @Override
    public ResponseDtoMarca modificarMarca(Long id, ReqDtoMarca reqDtoMarca) throws Exception {
        ResponseDtoMarca responseDtoMarca = null;
        try {
            Marca marca = marcaRepository.findById(id).get();
            if (null != reqDtoMarca){
                marca.setNombreMarca(reqDtoMarca.getNombreMarcaDto());

                Marca marcaActualizado = marcaRepository.save(marca);
                responseDtoMarca = mappingObjetoMarca.transformModelaResponse(marcaActualizado);
                marca.setNombreMarca(reqDtoMarca.getNombreMarcaDto());
                responseDtoMarca = mappingObjetoMarca.transformModelaResponse(marcaRepository.saveAndFlush(marca));
            }else{
                throw new NoActualizarException(Constant.ERROR_ACTUALIZAR);
            }
        }catch (NoActualizarException ex){
            ex.printStackTrace();
            throw new NoActualizarException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return responseDtoMarca;
    }
}