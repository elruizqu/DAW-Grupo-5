/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Servicio;
import com.proyecto.repository.ServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author elena
 */
@Service
public class ServicioService implements IServicioService{
    
    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> listServicio() {
        return (List<Servicio>) servicioRepository.findAll();
    }

    
}
