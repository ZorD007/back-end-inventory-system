package com.project.imp;

import com.project.dto.ReqDtoSucursal;
import com.project.dto.ResponseDtoSucursal;
import com.project.exception.NoEncontradoException;
import com.project.mapping.MappingObjetoSucursal;
import com.project.model.Sucursal;
import com.project.repository.SucursalRepository;
import com.project.service.ISucursalService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalImp implements ISucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;
    @Autowired
    private MappingObjetoSucursal transformarObjetos;

    @Override
    public ResponseDtoSucursal agregarSucursal(ReqDtoSucursal reqDtoSucursal) throws Exception{
        ResponseDtoSucursal responseDtoSucursal;
        Sucursal sucursalLocal;

        try{
            sucursalLocal = new Sucursal();
            sucursalLocal.setIdSucursal(reqDtoSucursal.getIdSucursalDto());
            sucursalLocal.setNombreSucursal(reqDtoSucursal.getNombreSucursalDto());

            responseDtoSucursal = transformarObjetos.transformarSucursalResponseDto(sucursalRepository.save(sucursalLocal));

        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return responseDtoSucursal;
    }

    @Override
    public boolean eliminarSucursal(Long id) throws Exception {
        try{

            Sucursal sucursal = transformarObjetos.transformarOptionalSucursal(sucursalRepository.findById(id));
            if(null == sucursal){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }else{
                sucursalRepository.deleteById(id);
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
    public Sucursal buscarPorId(Long id) throws Exception {

        Sucursal sucursallocal;
        try{
            sucursallocal = transformarObjetos.transformarOptionalSucursal(sucursalRepository.findById(id));
            if(null == sucursallocal){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return sucursallocal;
    }
}
