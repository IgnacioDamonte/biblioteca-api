package com.facultad.biblioteca.controller;
import com.facultad.biblioteca.model.Libro;
import com.facultad.biblioteca.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/libros") @CrossOrigin(origins="*")
public class LibroController {
    @Autowired private LibroService svc;
    @GetMapping public ResponseEntity<List<Libro>> getAll(){ return ResponseEntity.ok(svc.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Libro> getById(@PathVariable Long id){ return ResponseEntity.ok(svc.findById(id)); }
    @PostMapping public ResponseEntity<Libro> create(@Valid @RequestBody Libro l){ return ResponseEntity.status(HttpStatus.CREATED).body(svc.save(l)); }
    @PutMapping("/{id}") public ResponseEntity<Libro> update(@PathVariable Long id,@Valid @RequestBody Libro l){ return ResponseEntity.ok(svc.update(id,l)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){ svc.delete(id); return ResponseEntity.noContent().build(); }
}