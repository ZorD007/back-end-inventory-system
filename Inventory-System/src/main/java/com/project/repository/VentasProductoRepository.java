package com.project.repository;

import com.project.model.VentasProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasProductoRepository extends JpaRepository<VentasProducto, Long> {

    @Query(value = "select precio_venta, modelo from ventas_has_producto as v \n" +
            "inner join producto as p\n" +
            "where p.id_producto = idProducto",
            nativeQuery = true)
    VentasProducto findProducto(Long idProducto);
}
