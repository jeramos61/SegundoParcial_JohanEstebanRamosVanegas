package com.example.Jardineria.ModuloIngresoProducto.Service;

import com.example.Jardineria.ModuloEntidades.Entity.GamaProducto;
import com.example.Jardineria.ModuloEntidades.Entity.Producto;
import com.example.Jardineria.ModuloEntidades.Entity.Proveedores;
import com.example.Jardineria.ModuloEntidades.Repository.GamaProductoRepository;
import com.example.Jardineria.ModuloEntidades.Repository.ProveedoresRepository;
import com.example.Jardineria.ModuloIngresoProducto.DTO.ProductoDTO;
import com.example.Jardineria.ModuloEntidades.Repository.ProductoRepository;
import com.example.Jardineria.ModuloIngresoProducto.Excepciones.GamaNotFoundException;
import com.example.Jardineria.ModuloIngresoProducto.Excepciones.ProductoNotFoundException;
import com.example.Jardineria.ModuloIngresoProducto.Excepciones.ProveedoresNotFoundExcepton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    private GamaProductoRepository gamaProductoRepository;
    @Autowired
    private ProveedoresRepository proveedoresRepository;
    public List<Producto> getProductos(){
        return  productoRepository.findAll();
    }

    public Optional<Producto> getProducto(String codigoProducto){
        return productoRepository.findById(codigoProducto);
    }

    public void save(ProductoDTO productoDTO){
        Producto producto = new Producto();
        GamaProducto gamaProducto = new GamaProducto();
        Proveedores proveedores = new Proveedores();
        String nuevoCodigoProducto = generarCodigoProducto();

        List<GamaProducto> listaGamas = gamaProductoRepository.findByGama(productoDTO.getNombreGama());
        List<Proveedores> listaProveedores = proveedoresRepository.findByNombreProveedor(productoDTO.getNombreProveedor());

        if (!listaProveedores.isEmpty()){
            proveedores = listaProveedores.get(0);
            producto.setProveedores(proveedores);
        }else{
            throw new ProveedoresNotFoundExcepton("No se encontró el proveedor especificado");
        }
        if (!listaGamas.isEmpty() ) {
            gamaProducto = listaGamas.get(0);
            producto.setGamaProducto(gamaProducto);

        } else {
            // Manejar el caso en el que no se encuentre ninguna gama
            throw new GamaNotFoundException("No se encontró la gama especificada");
        }
        producto.setProveedores(proveedores);
        producto.setGamaProducto(gamaProducto);
        producto.setCodigoProducto(nuevoCodigoProducto);
        producto.setNombre(productoDTO.getNombre());
        producto.setDimensiones(productoDTO.getDimensiones());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCantidadEnStock(productoDTO.getCantidadEnStock());
        producto.setPrecioVenta(productoDTO.getPrecioVenta());
        producto.setPrecioProveedor(productoDTO.getPrecioProveedor());

        productoRepository.save(producto);
    }
    public void update(ProductoDTO productoDTO){
        Producto producto = new Producto();
        Proveedores proveedores = new Proveedores();
        GamaProducto gamaProducto = new GamaProducto();

        List<Producto> listaProductos = productoRepository.findByNombre((productoDTO.getNombre()));
        List<GamaProducto> listaGamas = gamaProductoRepository.findByGama(productoDTO.getNombreGama());
        List<Proveedores> listaProveedores =  proveedoresRepository.findByNombreProveedor(productoDTO.getNombreProveedor());
        if (!listaProductos.isEmpty()) {
            producto = listaProductos.get(0);

        } else {
            // Manejar el caso en el que no se encuentre ninguna gama
            throw new ProductoNotFoundException("No se encontró el producto especificado");
        }
        if (!listaProveedores.isEmpty()){
            proveedores = listaProveedores.get(0);
            producto.setProveedores(proveedores);
        }else{
            throw new ProveedoresNotFoundExcepton("No se encontró el proveedor especificado");
        }
        if (!listaGamas.isEmpty()) {
            gamaProducto = listaGamas.get(0);
            producto.setGamaProducto(gamaProducto);
        } else {
            // Manejar el caso en el que no se encuentre ninguna gama
            throw new GamaNotFoundException("No se encontró la gama especificada");
        }
        producto.setProveedores(proveedores);
        producto.setGamaProducto(gamaProducto);
        producto.setNombre(productoDTO.getNombre());
        producto.setDimensiones(productoDTO.getDimensiones());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCantidadEnStock(productoDTO.getCantidadEnStock());
        producto.setPrecioVenta(productoDTO.getPrecioVenta());
        producto.setPrecioProveedor(productoDTO.getPrecioProveedor());
        productoRepository.save(producto);
    }
    private String generarCodigoProducto() {
        String ultimoCodigoProducto = productoRepository.obtenerUltimoCodigoProducto();
        int ultimoNumero = Integer.parseInt(ultimoCodigoProducto.substring(1));//P040
        int nuevoNumero = ultimoNumero + 1;
        String nuevoCodigoProducto = "P" + String.format("%03d", nuevoNumero);
        return nuevoCodigoProducto;
    }



    public void delete(String nombre){
        Producto producto = new Producto();
        List <Producto> listaProducto = productoRepository.findByNombre(nombre);
        if (!listaProducto.isEmpty()) {
            producto = listaProducto.get(0);

        } else {

            throw new ProductoNotFoundException("No se encontró el producto especificado");
        }
        productoRepository.deleteById(producto.getCodigoProducto());
    }

}
