package com.facultad.biblioteca.config;
import com.facultad.biblioteca.model.*;
import com.facultad.biblioteca.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component public class DataInitializer implements CommandLineRunner {
    @Autowired private AutorRepository ar;
    @Autowired private LibroRepository lr;
    @Autowired private PrestamoRepository pr;
    @Override public void run(String... args){
        Autor g=new Autor(); g.setNombre("Gabriel Garcia Marquez"); g.setNacionalidad("Colombiana"); g.setFechaNacimiento("1927-03-06"); ar.save(g);
        Autor b=new Autor(); b.setNombre("Jorge Luis Borges"); b.setNacionalidad("Argentina"); b.setFechaNacimiento("1899-08-24"); ar.save(b);
        Autor r=new Autor(); r.setNombre("J.K. Rowling"); r.setNacionalidad("Britanica"); r.setFechaNacimiento("1965-07-31"); ar.save(r);
        Libro l1=new Libro(); l1.setTitulo("Cien años de soledad"); l1.setIsbn("978-0-06-088328-7"); l1.setGenero("Realismo magico"); l1.setAnioPublicacion(1967); l1.setAutor(g); lr.save(l1);
        Libro l2=new Libro(); l2.setTitulo("Ficciones"); l2.setIsbn("978-0-8021-3030-5"); l2.setGenero("Ficcion"); l2.setAnioPublicacion(1944); l2.setAutor(b); lr.save(l2);
        Libro l3=new Libro(); l3.setTitulo("Harry Potter y la piedra filosofal"); l3.setIsbn("978-84-7888-476-0"); l3.setGenero("Fantasia"); l3.setAnioPublicacion(1997); l3.setAutor(r); lr.save(l3);
        Libro l4=new Libro(); l4.setTitulo("El Aleph"); l4.setIsbn("978-84-206-1933-5"); l4.setGenero("Cuentos"); l4.setAnioPublicacion(1949); l4.setAutor(b); lr.save(l4);
        Prestamo p1=new Prestamo(); p1.setNombrePrestatario("Maria Gonzalez"); p1.setEmailPrestatario("maria@email.com"); p1.setFechaPrestamo("2026-05-20"); p1.setFechaDevolucion("2026-06-03"); p1.setEstado("ACTIVO"); p1.setLibro(l1); pr.save(p1);
        Prestamo p2=new Prestamo(); p2.setNombrePrestatario("Carlos Perez"); p2.setEmailPrestatario("carlos@email.com"); p2.setFechaPrestamo("2026-05-15"); p2.setFechaDevolucion("2026-05-29"); p2.setEstado("DEVUELTO"); p2.setLibro(l2); pr.save(p2);
        Prestamo p3=new Prestamo(); p3.setNombrePrestatario("Ana Martinez"); p3.setEmailPrestatario("ana@email.com"); p3.setFechaPrestamo("2026-06-01"); p3.setFechaDevolucion("2026-06-15"); p3.setEstado("ACTIVO"); p3.setLibro(l3); pr.save(p3);
    }
}