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
@Table(name = "departamento")
public class Departamento {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "profesor",
//            joinColumns = @JoinColumn(name = "id_departamento"),
//            inverseJoinColumns = @JoinColumn(name = "id_profesor"))
//    private Set<Persona> personas = new LinkedHashSet<>();

}