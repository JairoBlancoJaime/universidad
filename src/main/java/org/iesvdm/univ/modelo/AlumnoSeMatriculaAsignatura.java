package org.iesvdm.univ.modelo;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "alumno_se_matricula_asignatura")
public class AlumnoSeMatriculaAsignatura {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private AlumnoSeMatriculaAsignaturaId id;

    @ToString.Exclude
    @MapsId("idAlumno")
    @ManyToOne( optional = false)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Persona idAlumno;

    @ToString.Exclude
    @MapsId("idAsignatura")
    @ManyToOne( optional = false)
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura idAsignatura;

    @ToString.Exclude
    @MapsId("idCursoEscolar")
    @ManyToOne( optional = false)
    @JoinColumn(name = "id_curso_escolar", nullable = false)
    private CursoEscolar idCursoEscolar;

}