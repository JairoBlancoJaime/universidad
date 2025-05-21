package org.iesvdm.univ.repositorio;

import org.iesvdm.univ.modelo.AlumnoSeMatriculaAsignatura;
import org.iesvdm.univ.modelo.AlumnoSeMatriculaAsignaturaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoSeMatriculaAsignaturaRepository extends JpaRepository<AlumnoSeMatriculaAsignatura, AlumnoSeMatriculaAsignaturaId> {
}