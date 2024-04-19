package com.ejercicios.ejerciciosjpa.interfaces;

import com.ejercicios.ejerciciosjpa.Thematics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Creamos nuestra interfaz que extiende de JpaRepository
@Repository
public interface ThematicRepository extends JpaRepository<Thematics, Integer> {
}
