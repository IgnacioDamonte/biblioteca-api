package com.facultad.biblioteca.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;
@Entity @Table(name="libros") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Libro {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank(message="El titulo es obligatorio") @Column(nullable=false) private String titulo;
    private String isbn;
    private String genero;
    private Integer anioPublicacion;
    @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="autor_id") private Autor autor;
    @OneToMany(mappedBy="libro",cascade=CascadeType.ALL,fetch=FetchType.LAZY) @JsonIgnore private List<Prestamo> prestamos;
}