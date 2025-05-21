package org.iesvdm.univ.repositorio;

import org.iesvdm.univ.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}