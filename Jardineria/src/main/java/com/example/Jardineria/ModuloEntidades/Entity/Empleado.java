package com.example.Jardineria.ModuloEntidades.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Empleado {

    @Id

    private Integer codigoEmpleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String extension;
    private String email;
    private String codigoOficina;
    private Integer codigoEmpleadoRepVentas;
    private Integer limiteCredito;
}
