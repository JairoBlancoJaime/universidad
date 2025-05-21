package org.iesvdm.univ.repositorio;

import org.iesvdm.univ.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}