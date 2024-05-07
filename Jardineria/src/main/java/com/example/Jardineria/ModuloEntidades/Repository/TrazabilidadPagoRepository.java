package com.example.Jardineria.ModuloEntidades.Repository;

import com.example.Jardineria.ModuloEntidades.Entity.TrazabilidadPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrazabilidadPagoRepository extends JpaRepository<TrazabilidadPedido, String> {
}
