package com.example.Jardineria.ModuloIngresoProducto.DTO;


import lombok.Data;

@Data
public class GamaProductoDTO {
    private String gama;
    private String Descripcion;

    public GamaProductoDTO() {
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
