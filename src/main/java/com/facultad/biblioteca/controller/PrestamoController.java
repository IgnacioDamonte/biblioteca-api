package com.facultad.biblioteca.controller;
import com.facultad.biblioteca.model.Prestamo;
import com.facultad.biblioteca.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/prestamos") @CrossOrigin(origins="*")
public class PrestamoController {
    @Autowired private PrestamoService svc;
    @GetMapping public ResponseEntity<List<Prestamo>> getAll(){ return ResponseEntity.ok(svc.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Prestamo> getById(@PathVariable Long id){ return ResponseEntity.ok(svc.findById(id)); }
    @PostMapping public ResponseEntity<Prestamo> create(@Valid @RequestBody Prestamo p){ return ResponseEntity.status(HttpStatus.CREATED).body(svc.save(p)); }
    @PutMapping("/{id}") public ResponseEntity<Prestamo> update(@PathVariable Long id,@Valid @RequestBody Prestamo p){ return ResponseEntity.ok(svc.update(id,p)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){ svc.delete(id); return ResponseEntity.noContent().build(); }
}