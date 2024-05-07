package com.example.Jardineria.ModuloEntidades.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Departamento {
    @Id
    private String codigoDepartamento;
    private String nombreDepartamento;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("departamento")
    private List<Ciudad> ciudades;
}
