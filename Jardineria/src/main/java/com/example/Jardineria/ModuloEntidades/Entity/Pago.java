package com.example.Jardineria.ModuloEntidades.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Data
@Entity
public class Pago {

    @Id

    private String idTransaccion;
    private Date fechaPago;
    private Integer total;
    private String codigoMetodoPago;
    private String codigoEstadoPago;

}
