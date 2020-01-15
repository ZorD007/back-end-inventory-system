package com.project.imp;

import com.project.dto.ReqDtoSucursal;
import com.project.dto.ResponseDtoProducto;
import com.project.dto.ResponseDtoSucursal;
import com.project.exception.NoActualizarException;
import com.project.exception.NoEncontradoException;
import com.project.mapping.MappingObjetoSucursal;
import com.project.model.Producto;
import com.project.model.Sucursal;
import com.project.repository.SucursalRepository;
import com.project.service.ISucursalService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ResponseDtoSucursal> listarSucursal() throws Exception {
        List<ResponseDtoSucursal> listSucursal = new ArrayList<>();
        try {
            List<Sucursal> sucursals = sucursalRepository.findAll();
            for(Sucursal s : sucursals){
                listSucursal.add(transformarObjetos.transformarSucursalResponseDto( s ));
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return listSucursal;
    }

    @Override
    public ResponseDtoSucursal modificarSucursal(Long id, ReqDtoSucursal reqDtoSucursal) throws Exception {
        ResponseDtoSucursal responseDtoSucursal = null;
        try{
            Sucursal sucursal = sucursalRepository.findById(id).get();
            if(reqDtoSucursal != null){
                sucursal.setNombreSucursal(reqDtoSucursal.getNombreSucursalDto());
                Sucursal sucursalActualizada = sucursalRepository.save(sucursal);
                responseDtoSucursal = transformarObjetos.transformarSucursalResponseDto(sucursalActualizada);
                responseDtoSucursal = transformarObjetos.transformarSucursalResponseDto(sucursalRepository.saveAndFlush(sucursal));

            }else{
                throw new NoActualizarException(Constant.ERROR_ACTUALIZAR);
            }
        }catch(NoActualizarException ex){
            ex.printStackTrace();
            throw new NoActualizarException(ex.getMessage());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return responseDtoSucursal;
    }
}
