package com.example.Jardineria.ModuloEntidades.Repository;

import com.example.Jardineria.ModuloEntidades.Entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, String> {
}
