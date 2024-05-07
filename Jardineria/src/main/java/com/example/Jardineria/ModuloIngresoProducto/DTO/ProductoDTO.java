package com.example.Jardineria.ModuloIngresoProducto.DTO;
import lombok.Data;

@Data
public class ProductoDTO {
    private String nombre;
    private String dimensiones;
    private String descripcion;
    private Integer cantidadEnStock;
    private Integer precioVenta;
    private Integer precioProveedor;
    private String nombreGama;
    private String nombreProveedor;

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreGama() {
        return nombreGama;
    }

    public void setNombreGama(String nombreGama) {
        this.nombreGama = nombreGama;
    }

    public ProductoDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(Integer cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Integer precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(Integer precioProveedor) {
        this.precioProveedor = precioProveedor;
    }
}
