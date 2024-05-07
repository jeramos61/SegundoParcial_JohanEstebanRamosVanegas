package com.example.Jardineria.ModuloEntidades.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pedido {
    @Id
    private Integer codigoPedido;
    private Date fecha;
    private String comentarios;
    private Integer codigoCliente;
    private String codigoEstado;


    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy ="pedido")
    @JsonIgnoreProperties("pedido")
    private List<TrazabilidadPedido> trazabilidadPedido;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy ="pedido")
    @JsonIgnoreProperties("pedido")
    private List<EstadoPedido> estadoPedido;


}
