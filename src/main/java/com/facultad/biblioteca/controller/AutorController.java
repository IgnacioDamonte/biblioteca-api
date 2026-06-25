package com.facultad.biblioteca.controller;
import com.facultad.biblioteca.model.Autor;
import com.facultad.biblioteca.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/autores") @CrossOrigin(origins="*")
public class AutorController {
    @Autowired private AutorService svc;
    @GetMapping public ResponseEntity<List<Autor>> getAll(){ return ResponseEntity.ok(svc.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Autor> getById(@PathVariable Long id){ return ResponseEntity.ok(svc.findById(id)); }
    @PostMapping public ResponseEntity<Autor> create(@Valid @RequestBody Autor a){ return ResponseEntity.status(HttpStatus.CREATED).body(svc.save(a)); }
    @PutMapping("/{id}") public ResponseEntity<Autor> update(@PathVariable Long id,@Valid @RequestBody Autor a){ return ResponseEntity.ok(svc.update(id,a)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){ svc.delete(id); return ResponseEntity.noContent().build(); }
}