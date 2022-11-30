/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Producto;
import com.proyecto.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author elena
 */
@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProducto() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void delete(long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto findByProducto(String producto) {
      return productoRepository.findByProducto(producto);
    }

}
