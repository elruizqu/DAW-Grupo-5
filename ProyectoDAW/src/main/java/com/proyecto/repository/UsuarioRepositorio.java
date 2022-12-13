/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.repository;

import com.proyecto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author owenm
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	public Usuario findByEmail(String email);
	
}
