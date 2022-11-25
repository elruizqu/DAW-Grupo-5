/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Cita;
import com.proyecto.repository.CitaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author elena
 */
@Service
public class CitaService implements ICitaService{
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> getAllCita() {
        return (List<Cita>) citaRepository.findAll();
    }

    @Override
    public Cita getCitaById(long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCita(Cita cita) {
        citaRepository.save(cita);
    }

    @Override
    public void delete(long id) {
        citaRepository.deleteById(id);
    }

    @Override
    public Cita findByNombre(String nombre) {
      return citaRepository.findByNombre(nombre);
    }
    
}
