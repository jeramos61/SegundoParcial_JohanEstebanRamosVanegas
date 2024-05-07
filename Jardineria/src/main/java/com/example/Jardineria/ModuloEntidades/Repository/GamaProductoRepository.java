package com.example.Jardineria.ModuloEntidades.Repository;

import com.example.Jardineria.ModuloEntidades.Entity.GamaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface GamaProductoRepository extends JpaRepository<GamaProducto, String> {
    List<GamaProducto> findByGama(String nombre);

    @Query(value = "SELECT MAX(g.codigoGama) FROM GamaProducto g")
    String obtenerUltimoCodigoGama();


}
