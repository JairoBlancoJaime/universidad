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
@Table(name = "profesor")
public class Profesor {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "id_profesor", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @MapsId
    @OneToOne( optional = false)
    @JoinColumn(name = "id_profesor", nullable = false)
    private Persona persona;

    @ManyToOne( optional = false)
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento idDepartamento;

    @OneToMany(mappedBy = "idProfesor", fetch = FetchType.EAGER)
    private Set<Asignatura> asignaturas = new LinkedHashSet<>();

}