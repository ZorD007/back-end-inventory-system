package com.project.imp;

import com.project.dto.ReqDtoRol;
import com.project.dto.ResponseDtoRol;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.mapping.MappingObjetoRol;
import com.project.model.Rol;
import com.project.repository.RolRepository;
import com.project.service.IRolService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;

public class RolImp implements IRolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private MappingObjetoRol mappingObjetoRol;

    @Override
    public ResponseDtoRol añadirRol(ReqDtoRol reqDtoRol) throws Exception {
       ResponseDtoRol responseDtoRol;
       Rol rolLocal;
        try{
            Rol validarRol = rolRepository.findByCargo(reqDtoRol.getCargoDto());
            if(validarRol == null){
                rolLocal = new Rol();
                rolLocal.setCargo(reqDtoRol.getCargoDto());
                responseDtoRol = mappingObjetoRol.transformModelaResponse(rolRepository.save(rolLocal));
            }else{
                throw new NoGuardadoException(Constant.ERROR_GUARDAR);
            }
        }catch(NoGuardadoException ex){
            ex.printStackTrace();
            throw new  NoGuardadoException(ex.getMessage());
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return responseDtoRol;
    }

    @Override
    public Rol buscarPorId(Long id) throws Exception {
        Rol rolLocal;
        try{
            rolLocal = mappingObjetoRol.transformOptionalaModel(rolRepository.findById(id));
            if(rolLocal == null){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch(Exception ex){
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return rolLocal;
    }
}
