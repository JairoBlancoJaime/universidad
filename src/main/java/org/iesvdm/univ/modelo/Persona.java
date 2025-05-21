package org.iesvdm.univ.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
@Table(name = "persona")
public class Persona {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "nif", length = 9)
    private String nif;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "apellido1", nullable = false, length = 50)
    private String apellido1;

    @Column(name = "apellido2", length = 50)
    private String apellido2;

    @Column(name = "ciudad", nullable = false, length = 25)
    private String ciudad;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Column(name = "telefono", length = 9)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Lob
    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Lob
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @OneToMany(mappedBy = "idAlumno", fetch = FetchType.EAGER)
    private Set<AlumnoSeMatriculaAsignatura> alumnoSeMatriculaAsignaturas = new LinkedHashSet<>();

//    @ManyToMany( fetch = FetchType.EAGER)
//    private Set<Departamento> departamentos = new LinkedHashSet<>();

}