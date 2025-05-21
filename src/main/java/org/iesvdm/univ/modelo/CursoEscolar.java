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
@Table(name = "curso_escolar")
public class CursoEscolar {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "anyo_inicio", nullable = false)
    private Integer anyoInicio;

    @Column(name = "anyo_fin", nullable = false)
    private Integer anyoFin;

    @OneToMany(mappedBy = "idCursoEscolar", fetch = FetchType.EAGER)
    private Set<AlumnoSeMatriculaAsignatura> alumnoSeMatriculaAsignaturas = new LinkedHashSet<>();

}