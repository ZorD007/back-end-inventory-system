package com.project.imp;

import com.project.dto.ReqDtoMarca;
import com.project.model.Marca;
import com.project.service.IMarcaService;

public class MarcaImp implements IMarcaService {

    @Override
    public Marca agregarMarca(ReqDtoMarca reqDtoMarca) throws Exception{
        try{

        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return null;
    }

    @Override
    public Marca eliminarMarca() throws Exception {
        try{

        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return null;
    }
}