package com.example.Jardineria.ModuloEntidades.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Proveedores {
    @Id
    private String codigoProveedor;
    private String nombreProveedor;
    private String direccionPrincipal;
    private String numeroTelefonico;
    private String correoElectronico;



    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy ="proveedores")
    @JsonIgnore
    private List<Producto> productos;

    @ManyToOne
    @JoinColumn(name="Codigo_Postal")
    @JsonIgnoreProperties({"ciudad", "Departamento"})
    private Ciudad ciudad;

}