package org.iesvdm.univ;

import org.iesvdm.univ.modelo.*;
import org.iesvdm.univ.repositorio.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

/**
 1
 Devuelve un listado con el primer apellido, segundo apellido y el nombre de
 todos los alumnos. El listado deberá estar ordenado alfabéticamente de menor
 a mayor por el primer apellido, segundo apellido y nombre.


 2
 Averigua el nombre y los dos apellidos de los alumnos que no han dado de alta
 su número de teléfono en la base de datos.

 3
 Devuelve el listado de los alumnos que nacieron en 1999.

 4
 Devuelve el listado de profesores que no han dado de alta su número de teléfono
 en la base de datos y además su nif termina en K.

 5
 Devuelve el listado de las asignaturas que se imparten en el primer cuatrimestre,
 en el tercer curso del grado que tiene el identificador 7.

 6
 Devuelve un listado con el nombre de las asignaturas, año de inicio y año de fin
 del curso escolar del alumno con nif 26902806M.

 7
 Devuelve un listado con el nombre de todos los departamentos que tienen profesores
 que imparten alguna asignatura en el Grado en Ingeniería Informática (Plan 2015).

 8
 Devuelve un listado con todos los alumnos que se han matriculado en alguna
 asignatura durante el curso escolar 2018/2019.

 9
 Devuelve un listado con los profesores que no imparten ninguna asignatura.

 10
 Devuelve un listado con las asignaturas que no tienen un profesor asignado.

 11
 Devuelve un listado con todos los departamentos que tienen alguna asignatura
 que no se haya impartido en ningún curso escolar. El resultado debe mostrar el
 nombre del departamento y el nombre de la asignatura que no se haya impartido nunca.

 12
 Calcula cuántos profesores hay en cada departamento. El resultado sólo debe
 mostrar dos columnas, una con el nombre del departamento y otra con el número
 e profesores que hay en ese departamento. El resultado sólo debe incluir los
 departamentos que tienen profesores asociados y deberá estar ordenado de mayor
 a menor por el número de profesores.

 13
 Devuelve un listado con el nombre de todos los grados existentes en la base de
 datos y el número de asignaturas que tiene cada uno, de los grados que tengan
 más de 40 asignaturas asociadas

 14
 Devuelve un listado con los profesores que tienen un departamento asociado
 y que no imparten ninguna asignatura.

 */

@SpringBootTest
class UnivApplicationTests {

    @Autowired
    AlumnoSeMatriculaAsignaturaRepository alumnoSeMatriculaAsignaturaRepository;

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Autowired
    CursoEscolarRepository cursoEscolarRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    GradoRepository gradoRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Test
    void contextLoads() {

        personaRepository.findAll().forEach(System.out::println);

    }

    /*   1
         Devuelve un listado con el primer apellido, segundo apellido y el nombre de
         todos los alumnos. El listado deberá estar ordenado alfabéticamente de menor
         a mayor por el primer apellido, segundo apellido y nombre.
    */

    @Test
    void test1() {

        List<Persona> list = personaRepository.findAll();

        var alumnos = list.stream()
                .filter(profAlu -> profAlu.getTipo().equals("alumno"))
                .sorted(comparing(Persona::getApellido1)
                        .thenComparing((Persona::getApellido2))
                        .thenComparing(Persona::getNombre))
                .map(persona -> persona.getApellido1() + " " + persona.getApellido2() + " " + persona.getNombre())
                .toList();

        System.out.println(alumnos);

    }

    /*   2
         Averigua el nombre y los dos apellidos de los alumnos que no han dado de alta
         su número de teléfono en la base de datos.
    */

    @Test
    void test2() {

        List<Persona> list = personaRepository.findAll();

        var sintelefono = list.stream()
                .filter(profAlu -> profAlu.getTipo().equals("alumno")
                        && profAlu.getTelefono()==null)
                .map(persona -> persona.getNombre() + " " + persona.getApellido1() + " " + persona.getApellido2())
                .toList();

        System.out.println(sintelefono);

    }

    /*  3
        Devuelve el listado de los alumnos que nacieron en 1999.
    */

    @Test
    void test3() {

        List<Persona> list = personaRepository.findAll();

        LocalDate anyo1998 = LocalDate. of(1998, 12, 31);
        LocalDate anyo2000 = LocalDate. of(2000, 1, 1);

        var nacido1999 = list.stream()
                .filter(profAlu -> profAlu.getTipo().equals("alumno")
                        && profAlu.getFechaNacimiento().isAfter(anyo1998)
                        && profAlu.getFechaNacimiento().isBefore(anyo2000))
                .toList();

        System.out.println(nacido1999);
    }

    /*   4
         Devuelve el listado de profesores que no han dado de alta su número de teléfono
         en la base de datos y además su nif termina en K.
    */

    @Test
    void test4() {

        List<Persona> list = personaRepository.findAll();

        var sinTelefonoK = list.stream()
                .filter(profAlu -> profAlu.getTipo().equals("profesor")
                        && profAlu.getTelefono()==null
                        && profAlu.getNif().endsWith("K"))
                .toList();

        System.out.println(sinTelefonoK);
    }

    /*   5
         Devuelve el listado de las asignaturas que se imparten en el primer cuatrimestre,
         en el tercer curso del grado que tiene el identificador 7.
    */

    @Test
    void test5() {

        List<Asignatura> list = asignaturaRepository.findAll();

//        var sintelefono = list.stream()
//                .
//                .toList();

        // cursoescolar getId == 3

    }

    /*   6
         Devuelve un listado con el nombre de las asignaturas, año de inicio y año de fin
         del curso escolar del alumno con nif 26902806M.
    */

    @Test
    void test6() {

        List<Asignatura> list = asignaturaRepository.findAll();

        var alum = list.stream()

                .toList();

        System.out.println(alum);

    }

    /*   7
         Devuelve un listado con el nombre de todos los departamentos que tienen profesores
         que imparten alguna asignatura en el Grado en Ingeniería Informática (Plan 2015).
    */

    @Test
    void test7() {

        List<Departamento> list = departamentoRepository.findAll();

        var nomDeps = list.stream()

                .toList();

        System.out.println(nomDeps);

    }

    /*   8
         Devuelve un listado con todos los alumnos que se han matriculado en alguna
         asignatura durante el curso escolar 2018/2019.
    */

    @Test
    void test8() {

        List<Persona> list = personaRepository.findAll();

        var alumMat = list.stream()

                .toList();

        System.out.println(alumMat);

    }

    /*   9
        Devuelve un listado con los profesores que no imparten ninguna asignatura.
    */

    @Test
    void test9() {

        List<Asignatura> list = asignaturaRepository.findAll();

//        var profSinAsig = list.stream()
//                .filter(profAsig -> profAsig.getIdProfesor()==null)
//                .flatMap(asignatura -> this.profesorRepository.findById(asignatura.))
//                .toList();

    }

    /*  10
        Devuelve un listado con las asignaturas que no tienen un profesor asignado.
    */

    @Test
    void test10() {

        List<Asignatura> list = asignaturaRepository.findAll();

        var asigSinProf = list.stream()
                .filter(profAlu -> profAlu.getIdProfesor()==null)
                .toList();

        System.out.println(asigSinProf);

    }

    /*   11
         Devuelve un listado con todos los departamentos que tienen alguna asignatura
         que no se haya impartido en ningún curso escolar. El resultado debe mostrar el
         nombre del departamento y el nombre de la asignatura que no se haya impartido nunca.
    */

    @Test
    void test11() {

        List<Departamento> list = departamentoRepository.findAll();

        var depList = list.stream()

                .toList();

        System.out.println(depList);

    }

    /*    12
         Calcula cuántos profesores hay en cada departamento. El resultado sólo debe
         mostrar dos columnas, una con el nombre del departamento y otra con el número
         e profesores que hay en ese departamento. El resultado sólo debe incluir los
         departamentos que tienen profesores asociados y deberá estar ordenado de mayor
         a menor por el número de profesores.
    */

    @Test
    void test12() {

        List<Profesor> list = profesorRepository.findAll();

        var profXdep = list.stream()

                .toList();

        System.out.println(profXdep);


    }

    /*   13
         Devuelve un listado con el nombre de todos los grados existentes en la base de
         datos y el número de asignaturas que tiene cada uno, de los grados que tengan
         más de 40 asignaturas asociadas
    */

    @Test
    void test13() {

        List<Grado> list = gradoRepository.findAll();

        var gradExist = list.stream()

                .toList();

        System.out.println(gradExist);

    }

    /*   14
         Devuelve un listado con los profesores que tienen un departamento asociado
         y que no imparten ninguna asignatura.
    */

    @Test
    void test14() {
        List<Persona> list = personaRepository.findAll();

        var profDepSinAsig = list.stream()
                .filter(profAlu -> profAlu.getTipo().equals("profesor")
                        && profAlu.getTelefono()==null
                        && profAlu.getNif().endsWith("K"))
                .toList();

        System.out.println(profDepSinAsig);
    }

}
