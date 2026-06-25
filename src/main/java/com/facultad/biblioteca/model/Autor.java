package com.facultad.biblioteca.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;
@Entity @Table(name="autores") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Autor {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank(message="El nombre es obligatorio") @Column(nullable=false) private String nombre;
    private String nacionalidad;
    private String fechaNacimiento;
    @OneToMany(mappedBy="autor",cascade=CascadeType.ALL,fetch=FetchType.LAZY) @JsonIgnore private List<Libro> libros;
}