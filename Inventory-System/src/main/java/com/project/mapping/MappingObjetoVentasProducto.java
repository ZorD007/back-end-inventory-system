package com.project.mapping;

import com.project.model.Producto;
import com.project.model.Ventas;
import com.project.model.VentasProducto;
import org.springframework.stereotype.Service;

@Service
public class MappingObjetoVentasProducto {

    public VentasProducto transformarAVentasProducto(Ventas ventas, Producto producto) throws Exception{
        VentasProducto ventasProductoLocal;
        try {
            ventasProductoLocal = new VentasProducto();
            ventasProductoLocal.setVentas(ventas);
            ventasProductoLocal.setProducto(producto);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return ventasProductoLocal;
    }

}
