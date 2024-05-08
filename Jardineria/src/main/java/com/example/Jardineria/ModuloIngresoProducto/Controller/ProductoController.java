package com.example.Jardineria.ModuloIngresoProducto.Controller;


import com.example.Jardineria.ModuloEntidades.Entity.Producto;
import com.example.Jardineria.ModuloEntidades.Repository.ProductoRepository;
import com.example.Jardineria.ModuloIngresoProducto.Service.ProductoService;
import com.example.Jardineria.ModuloIngresoProducto.DTO.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2/api/Productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> findAll(){
        return productoService.getProductos();
    }


    @GetMapping("/{id}")
    public Optional<Producto> getById(@PathVariable("id")String id){
        return productoService.getProducto(id);
    }

    @PostMapping("/crear")
    public void crearProducto(@RequestBody ProductoDTO productoDTO) {
        productoService.save(productoDTO);
    }
    @PatchMapping("/Actualizar")
    public void guardarProducto(@RequestBody ProductoDTO productoDTO) {
        productoService.update(productoDTO);
    }

    @DeleteMapping("/eliminar")
    public void delete(@RequestParam String nombre){
        productoService.delete(nombre);
    }

    @GetMapping("/porNombre")
    public List<Producto> buscarProductosPorNombre(@RequestParam String nombre) {
        return productoRepository.findByNombre(nombre);
    }
}
