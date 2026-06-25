package com.facultad.biblioteca.repository;
import com.facultad.biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository public interface PrestamoRepository extends JpaRepository<Prestamo,Long> {}