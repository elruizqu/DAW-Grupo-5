/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Producto;
import java.util.List;

/**
 *
 * @author elena
 */
public interface IProductoService {
    public List<Producto> listProducto();
    public Producto getProductoById(long id);
    public void saveProducto(Producto producto);
    public void delete(long id);
}
