package com.facultad.biblioteca.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Entity @Table(name="prestamos") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Prestamo {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank(message="El nombre del prestatario es obligatorio") @Column(nullable=false) private String nombrePrestatario;
    private String emailPrestatario;
    private String fechaPrestamo;
    private String fechaDevolucion;
    @Column(nullable=false) private String estado;
    @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="libro_id") private Libro libro;
}