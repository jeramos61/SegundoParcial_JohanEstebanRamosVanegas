package com.example.Jardineria.ModuloIngresoProducto.Controller;


import com.example.Jardineria.ModuloEntidades.Entity.Proveedores;
import com.example.Jardineria.ModuloIngresoProducto.Service.ProveedoresService;
import com.example.Jardineria.ModuloIngresoProducto.DTO.ProveedoresDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2/api/Proveedores")
public class ProveedoresController {
    @Autowired
    private ProveedoresService proveedoresService;

    @GetMapping
    public List<Proveedores> findAll(){
        return proveedoresService.getProveedores();
    }


    @GetMapping("/{Proveedor}")
    public Optional<Proveedores> getById(@PathVariable("Proveedor")String proveedor){
        return proveedoresService.getProveedor(proveedor);
    }

    @PostMapping("/Crear")
    public void save(@RequestBody ProveedoresDTO proveedoresDTO){
        proveedoresService.save(proveedoresDTO);
    }
    @PutMapping("/Actualizar")
    public void update(@RequestBody ProveedoresDTO proveedoresDTO){

    }

    @DeleteMapping("/{gama}")
    public void delete(@PathVariable("gama") String gama){
        proveedoresService.delete(gama);
    }

}
