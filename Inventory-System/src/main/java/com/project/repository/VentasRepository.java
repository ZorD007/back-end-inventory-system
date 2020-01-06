package com.project.repository;

import com.project.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {

    @Query(value = "SELECT u FROM Ventas u WHERE u.fechaVenta >= :fechaInicio and u.fechaVenta <= :fechaFin",nativeQuery = true)
    List<Ventas> findVentasByDate(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
}
