/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.entity.Cita;
import com.proyecto.entity.Producto;
import com.proyecto.entity.Servicio;
import com.proyecto.service.ICitaService;
import com.proyecto.service.IProductoService;
import com.proyecto.service.IServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author owena
 */
@Controller
public class SalonController {
    @Autowired
    private ICitaService citaService;
    
    @Autowired
    private IServicioService servicioService;
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/home")
    public String index(){
        return "index";
    }
    
    @GetMapping("/salonServicios")
    public String servicios(){
        return "Servicios/Servicios";
    }
    
    @GetMapping("/salonProductos")
    public String productos(){
        return "Productos/Productos";
    }
    
    @GetMapping("/salonPromociones")
    public String promociones(){
        return "Promociones/Promociones";
    }
    
    @GetMapping("/PromocionInfo")
    public String promocionesInfo(){
        return "Promociones/PromocionInfo";
    }
    
    @GetMapping("/comprarProductos")
    public String producto(Model model){
        List<Producto> listaProductos = productoService.getAllProducto();
        model.addAttribute("titulo", "Productos por comprar");
        model.addAttribute("productos", listaProductos);
        return "comprarProductos/comprarProductos";
    }
    
    @GetMapping("/Shampoo")
    public String Shampoo(Model model){
        List<Producto> listaProductos = productoService.getAllProducto();
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", listaProductos);
        return "Productos/Shampoo";
    }
    
    @GetMapping("/Tratamiento")
    public String Tratamiento(Model model){
        List<Producto> listaProductos = productoService.getAllProducto();
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", listaProductos);
        return "Productos/Tratamiento";
    }
    
    @GetMapping("/Crema")
    public String Crema(Model model){
        List<Producto> listaProductos = productoService.getAllProducto();
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", listaProductos);
        return "Productos/Crema";
    }
    
    @GetMapping("/Aceite")
    public String Aceite(Model model){
        List<Producto> listaProductos = productoService.getAllProducto();
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", listaProductos);
        return "Productos/Aceite";
    }
    
    @GetMapping("/Esmalte")
    public String Esmalte(Model model){
        List<Producto> listaProductos = productoService.getAllProducto();
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", listaProductos);
        return "Productos/Esmalte";
    }
    
    @GetMapping("/Sombras")
    public String Sombras(Model model){
        List<Producto> listaProductos = productoService.getAllProducto();
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", listaProductos);
        return "Productos/Sombras";
    }
    
    @GetMapping("/Labiales")
    public String Labiales(Model model){
        List<Producto> listaProductos = productoService.getAllProducto();
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", listaProductos);
        return "Productos/Labiales";
    }
    
    @GetMapping("/Mascarilla")
    public String Mascarilla(Model model){
        List<Producto> listaProductos = productoService.getAllProducto();
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", listaProductos);
        return "Productos/Mascarilla";
    }
    
    @PostMapping("/saveProd")
    public String guardarProducto(@ModelAttribute Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/comprarProductos";
    }
    
    @GetMapping("/deleteProd/{id}")
    public String eliminarProd(@PathVariable("id") Long idProducto){
        productoService.delete(idProducto);
        return "redirect:/comprarProductos";
    }
    
    @GetMapping("/salonCita")
    public String index(Model model){
        List<Cita> listaCita = citaService.getAllCita();
        model.addAttribute("titulo", "Citas Agendadas");
        model.addAttribute("citas", listaCita);
        return "citas/citas";
    }
    
    @GetMapping("/salonAgendar")
    public String crearCita(Model model){
        List<Servicio> listaServicios = servicioService.listServicio();
        model.addAttribute("cita", new Cita());
        model.addAttribute("servicios", listaServicios);
        return "crear/crear";
    }
    
    @GetMapping("/salonContacto")
    public String contacto(){
        return "Contacto/Contacto";
    }
    
    @GetMapping("/salonEnviado")
    public String enviado(){
        return "Contacto/Enviado";
    }
    
    @PostMapping("/save")
    public String guardarCita(@ModelAttribute Cita cita){
        citaService.saveCita(cita);
        return "redirect:/salonCita";
    }
    
    @GetMapping("/editCita/{id}")
    public String editarCita (@PathVariable("id") Long idCita, Model model){
        Cita cita = citaService.getCitaById(idCita);
        List<Servicio> listaServicios = servicioService.listServicio();
        model.addAttribute("cita", cita);
        model.addAttribute("servicios", listaServicios);
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarCita(@PathVariable("id") Long idCita){
        citaService.delete(idCita);
        return "redirect:/salonCita";
    }
}
