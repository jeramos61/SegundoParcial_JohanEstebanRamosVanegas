package com.example.Jardineria.ModuloEntidades.Repository;

import com.example.Jardineria.ModuloEntidades.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, String> {
    List<Producto> findByNombre(String nombre);

    @Query(value = "SELECT MAX(p.codigoProducto) FROM Producto p")
    String obtenerUltimoCodigoProducto();
}
