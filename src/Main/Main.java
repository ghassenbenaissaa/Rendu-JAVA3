package Main;

import Entities.Student;
import Entities.StudentManagement;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice", 22);
        Student student2 = new Student(2, "Bob", 20);
        Student student3 = new Student(3, "Charlie", 25);

        List<Student> studentList = Arrays.asList(student1, student2, student3);
        StudentManagement studentManagement = new StudentManagement();

        System.out.println("---- Affichage de tous les étudiants ----");
        studentManagement.displayStudents(studentList, System.out::println);

        System.out.println("---- Affichage des étudiants de plus de 21 ans ----");
        studentManagement.displayStudentsByFilter(studentList, student -> student.getAge() > 21, System.out::println);

        System.out.println("---- Noms des étudiants ----");
        String studentNames = studentManagement.returnStudentsNames(studentList, Student::getNom);
        System.out.println(studentNames);

        System.out.println("---- Création d'un nouvel étudiant ----");
        Student newStudent = studentManagement.createStudent(() -> new Student(4, "David", 23));
        System.out.println("Nouvel étudiant créé : " + newStudent);

        System.out.println("---- Tri des étudiants par ID ----");
        List<Student> sortedStudents = studentManagement.sortStudentsById(studentList, Comparator.comparingInt(Student::getId));
        studentManagement.displayStudents(sortedStudents, System.out::println);

        System.out.println("---- Conversion de la liste en flux ----");
        Stream<Student> studentStream = studentManagement.convertToStream(studentList);
        studentStream.forEach(System.out::println);
    }
}
