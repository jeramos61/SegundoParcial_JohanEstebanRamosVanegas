package com.example.Jardineria.ModuloEntidades.Repository;

import com.example.Jardineria.ModuloEntidades.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
}
