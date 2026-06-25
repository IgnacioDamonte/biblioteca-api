package com.facultad.biblioteca.service;
import com.facultad.biblioteca.exception.ResourceNotFoundException;
import com.facultad.biblioteca.model.*;
import com.facultad.biblioteca.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class LibroService {
    @Autowired private LibroRepository libroRepo;
    @Autowired private AutorRepository autorRepo;
    public List<Libro> findAll(){ return libroRepo.findAll(); }
    public Libro findById(Long id){ return libroRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Libro",id)); }
    public Libro save(Libro l){ resolveAutor(l); return libroRepo.save(l); }
    public Libro update(Long id,Libro d){ Libro l=findById(id); l.setTitulo(d.getTitulo()); l.setIsbn(d.getIsbn()); l.setGenero(d.getGenero()); l.setAnioPublicacion(d.getAnioPublicacion()); if(d.getAutor()!=null) l.setAutor(d.getAutor()); resolveAutor(l); return libroRepo.save(l); }
    public void delete(Long id){ findById(id); libroRepo.deleteById(id); }
    private void resolveAutor(Libro l){ if(l.getAutor()!=null&&l.getAutor().getId()!=null){ Autor a=autorRepo.findById(l.getAutor().getId()).orElseThrow(()->new ResourceNotFoundException("Autor",l.getAutor().getId())); l.setAutor(a); } }
}