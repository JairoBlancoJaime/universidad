package org.iesvdm.univ.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class AlumnoSeMatriculaAsignaturaId implements Serializable {
    private static final long serialVersionUID = 8076704959383006182L;
    @Column(name = "id_alumno", columnDefinition = "int UNSIGNED not null")
    private Long idAlumno;

    @Column(name = "id_asignatura", columnDefinition = "int UNSIGNED not null")
    private Long idAsignatura;

    @Column(name = "id_curso_escolar", columnDefinition = "int UNSIGNED not null")
    private Long idCursoEscolar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AlumnoSeMatriculaAsignaturaId entity = (AlumnoSeMatriculaAsignaturaId) o;
        return Objects.equals(this.idAlumno, entity.idAlumno) &&
                Objects.equals(this.idCursoEscolar, entity.idCursoEscolar) &&
                Objects.equals(this.idAsignatura, entity.idAsignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlumno, idCursoEscolar, idAsignatura);
    }

}