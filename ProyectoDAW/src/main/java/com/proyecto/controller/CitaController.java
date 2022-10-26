/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.entity.Cita;
import com.proyecto.entity.Servicio;
import com.proyecto.service.ICitaService;
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
 * @author elena
 */
@Controller
public class CitaController {
    @Autowired
    private ICitaService citaService;
    
    @Autowired
    private IServicioService servicioService;
    
    @GetMapping("/cita")
    public String index(Model model){
        List<Cita> listaCita = citaService.getAllCita();
        model.addAttribute("titulo", "Citas Agendadas");
        model.addAttribute("citas", listaCita);
        return "citas";
    }
    
    @GetMapping("/citaN")
    public String crearCita(Model model){
        List<Servicio> listaServicios = servicioService.listServicio();
        model.addAttribute("cita", new Cita());
        model.addAttribute("servicios", listaServicios);
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarCita(@ModelAttribute Cita cita){
        citaService.saveCita(cita);
        return "redirect:/cita";
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
        return "redirect:/cita";
    }
}
