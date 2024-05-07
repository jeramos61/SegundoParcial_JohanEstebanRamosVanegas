package com.example.Jardineria.ModuloIngresoProducto.Excepciones;

public class ProveedoresNotFoundExcepton extends RuntimeException {

    public ProveedoresNotFoundExcepton(String message) {
        super(message);
    }
}