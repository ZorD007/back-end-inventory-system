package com.project.imp;

import com.project.dto.ReqDtoRol;
import com.project.dto.ResponseDtoRol;
import com.project.exception.NoActualizarException;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.mapping.MappingObjetoRol;
import com.project.model.Rol;
import com.project.repository.RolRepository;
import com.project.service.IRolService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public ResponseDtoRol modificarRol(Long id, ReqDtoRol reqDtoRol) throws Exception {
        ResponseDtoRol responseDtoRol= null;
        try{

            Rol rol = rolRepository.findById(id).get();
            if(null != reqDtoRol){

                rol.setCargo(reqDtoRol.getCargoDto());
                rol.setIdRol(reqDtoRol.getIdRolDto());

                Rol rolActualizado = rolRepository.save(rol);
                responseDtoRol = mappingObjetoRol.transformModelaResponse(rolActualizado);

                rol.setCargo(reqDtoRol.getCargoDto());
                rol.setIdRol(reqDtoRol.getIdRolDto());

                responseDtoRol = mappingObjetoRol.transformModelaResponse(rolRepository.saveAndFlush(rol));

            }else{
                throw new NoActualizarException(Constant.ERROR_ACTUALIZAR);
            }
        }catch(Exception ex){

            ex.printStackTrace();
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

    @Override
    public boolean eliminarRol(Long id) throws Exception {
        try{
            Rol rol = mappingObjetoRol.transformOptionalaModel(rolRepository.findById(id));
            if(null == rol){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }else{
                rolRepository.deleteById(id);
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
    public List<ResponseDtoRol> listarRol() throws Exception {

        List<ResponseDtoRol> listRol = new ArrayList<>();
        try {
            List<Rol> rols = rolRepository.findAll();
            for(Rol p : rols){
                listRol.add(mappingObjetoRol.transformModelaResponse( p ));
            }

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return listRol;
    }
}
