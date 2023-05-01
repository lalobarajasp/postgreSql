package com.grid.postgreSql.rest;

import com.grid.postgreSql.model.Persona;
import com.grid.postgreSql.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persona/")
public class PersonaREST {
    @Autowired
    private PersonaService personaService;

    @PostMapping
    private ResponseEntity<Persona> guardar (@RequestBody Persona persona){
        Persona temporal = personaService.create(persona);
        try {
            return ResponseEntity.created(new URI("/api/persona"+temporal.getId())).body(temporal);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping
    private ResponseEntity<List<Persona>> listarTodasLasPersona (){
        return ResponseEntity.ok(personaService.getAllPersonas());
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarPersona (@RequestBody Persona persona){
        personaService.delete(persona);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Persona>> listarPersonasPorID (@PathVariable ("id") Long id){
        return ResponseEntity.ok(personaService.findById(id));
    }
}
