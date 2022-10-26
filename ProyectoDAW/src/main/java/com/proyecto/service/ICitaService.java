/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Cita;
import java.util.List;

/**
 *
 * @author elena
 */
public interface ICitaService {
    public List<Cita> getAllCita();
    public Cita getCitaById(long id);
    public void saveCita(Cita cita);
    public void delete(long id);
}
