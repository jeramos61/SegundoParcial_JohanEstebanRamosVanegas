package com.example.Jardineria.ModuloEntidades.Entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Cliente {

    @Id

    private Integer codigoCliente;
    private String nombreCliente;
    private String apellidoContacto; ;
    private String nombreContacto;
    private String Telefono;
    private String Fax;
    private String lineaDireccion1;
    private String lineaDireccion2;
    private String codigoPostal;
    private Integer codigoEmpleadoRepVentas;
    private Integer limiteCredito;
}
