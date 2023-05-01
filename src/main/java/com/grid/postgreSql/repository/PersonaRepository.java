package com.grid.postgreSql.repository;

import com.grid.postgreSql.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {

}
