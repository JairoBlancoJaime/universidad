package org.iesvdm.univ.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "asignatura")
public class Asignatura {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Lob
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "curso", columnDefinition = "tinyint UNSIGNED not null")
    private Short curso;

    @Column(name = "cuatrimestre", columnDefinition = "tinyint UNSIGNED not null")
    private Short cuatrimestre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor idProfesor;

    @ManyToOne( optional = false)
    @JoinColumn(name = "id_grado", nullable = false)
    private Grado idGrado;
    @OneToMany(mappedBy = "idAsignatura")
    private Set<AlumnoSeMatriculaAsignatura> alumnoSeMatriculaAsignaturas = new LinkedHashSet<>();

    @Column(name = "creditos", columnDefinition = "float UNSIGNED not null")
    private Double creditos;

}