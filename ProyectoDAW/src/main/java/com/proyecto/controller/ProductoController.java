/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;


import com.proyecto.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author owenm
 */
@Controller
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    
     @GetMapping("/comprarProductos")
    public String comprarProductos(){
        return "comprarProductos/comprarProductos";
    }
}
