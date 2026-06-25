package com.facultad.biblioteca.service;
import com.facultad.biblioteca.exception.ResourceNotFoundException;
import com.facultad.biblioteca.model.Autor;
import com.facultad.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class AutorService {
    @Autowired private AutorRepository repo;
    public List<Autor> findAll(){ return repo.findAll(); }
    public Autor findById(Long id){ return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Autor",id)); }
    public Autor save(Autor a){ return repo.save(a); }
    public Autor update(Long id,Autor d){ Autor a=findById(id); a.setNombre(d.getNombre()); a.setNacionalidad(d.getNacionalidad()); a.setFechaNacimiento(d.getFechaNacimiento()); return repo.save(a); }
    public void delete(Long id){ findById(id); repo.deleteById(id); }
}