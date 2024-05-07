package com.example.Jardineria.ModuloEntidades.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity

public class TrazabilidadPedido {

    @Id
    private String codigoEstado;
    private String nombreEstado;

    @ManyToOne
    @JoinColumn(name="fecha")
    @JsonIgnoreProperties("trazabilidadpedido")
    private Pedido pedido;
}
