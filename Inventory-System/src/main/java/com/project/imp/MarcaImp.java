package com.project.imp;

import com.project.dto.ReqDtoMarca;
import com.project.dto.ResponseDtoMarca;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.mapping.MappingObjetoMarca;
import com.project.model.Marca;
import com.project.repository.MarcaRepository;
import com.project.service.IMarcaService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Marca validarMarca = marcaRepository.findByName(reqDtoMarca.getNombreMarcaDto());
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
}