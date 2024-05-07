package com.example.Jardineria.ModuloEntidades.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EstadoPedido {
    @Id
    private Integer idEstadoPedido;
    private String nombre;

    @ManyToOne
    @JoinColumn(name="codigo_pedido")
    @JsonIgnoreProperties("estadoPedido")
    private Pedido pedido;

}