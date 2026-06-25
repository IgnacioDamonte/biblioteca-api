package com.facultad.biblioteca.service;
import com.facultad.biblioteca.exception.ResourceNotFoundException;
import com.facultad.biblioteca.model.*;
import com.facultad.biblioteca.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class PrestamoService {
    @Autowired private PrestamoRepository prestamoRepo;
    @Autowired private LibroRepository libroRepo;
    public List<Prestamo> findAll(){ return prestamoRepo.findAll(); }
    public Prestamo findById(Long id){ return prestamoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Prestamo",id)); }
    public Prestamo save(Prestamo p){ resolveLibro(p); return prestamoRepo.save(p); }
    public Prestamo update(Long id,Prestamo d){ Prestamo p=findById(id); p.setNombrePrestatario(d.getNombrePrestatario()); p.setEmailPrestatario(d.getEmailPrestatario()); p.setFechaPrestamo(d.getFechaPrestamo()); p.setFechaDevolucion(d.getFechaDevolucion()); p.setEstado(d.getEstado()); if(d.getLibro()!=null) p.setLibro(d.getLibro()); resolveLibro(p); return prestamoRepo.save(p); }
    public void delete(Long id){ findById(id); prestamoRepo.deleteById(id); }
    private void resolveLibro(Prestamo p){ if(p.getLibro()!=null&&p.getLibro().getId()!=null){ Libro l=libroRepo.findById(p.getLibro().getId()).orElseThrow(()->new ResourceNotFoundException("Libro",p.getLibro().getId())); p.setLibro(l); } }
}