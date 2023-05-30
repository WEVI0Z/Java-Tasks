import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        school.addStudent("Alex", "Garkaviy");
        school.addTeacher("Sergei", "Streha");
        school.addStudent("Eugene", "Soroka");
        school.addTeacher("Vadim", "Lazuk");

        school.removeStudent("Alex", "Garkaviy");

        school.students.forEach(student -> System.out.println(student.firstName));
        school.teachers.forEach(teacher -> System.out.println(teacher.firstName));
    }
}

class School {
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    void addStudent(String firstName, String lastName) {
        students.add(new Student(firstName, lastName));
    }

    void addTeacher(String firstName, String lastName) {
        this.teachers.add(new Teacher(firstName, lastName));
    }

    void removeTeacher(String firstName, String lastName) {
        this.teachers.removeIf(
                teacher -> teacher.firstName.equals(firstName) &&
                        teacher.lastName.equals(lastName)
        );
    }

    void removeStudent(String firstName, String lastName) {
        this.students.removeIf(
                student -> student.firstName.equals(firstName) &&
                        student.lastName.equals(lastName)
        );
    }
}

class Person {
    String firstName;
    String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class Student extends Person {
    Student(String firstName, String lastName) {
        super(firstName, lastName);
    }
}

class Teacher extends Person {
    Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }
}