//subject class
public class Subject {
    private String subjectCode;
    private String subjectName;
    private int internalMarks;
    private int externalMarks;

    public Subject(String subjectCode, String subjectName, int internalMarks, int externalMarks) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.internalMarks = internalMarks;
        this.externalMarks = externalMarks;
    }

    public int getTotalMarks() {
        return internalMarks + externalMarks;
    }

    // Getters and setters for the fields can be added here if needed
}

//student class
import java.util.ArrayList;

public class Student {
    private int rollNo;
    private String name;
    private String dateOfBirth;
    private String courseOfStudy;
    private ArrayList<Subject[]> semesters; // ArrayList containing arrays of subjects for each semester

    public Student(int rollNo, String name, String dateOfBirth, String courseOfStudy) {
        this.rollNo = rollNo;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.courseOfStudy = courseOfStudy;
        this.semesters = new ArrayList<>();
    }

    public void addSemester(Subject[] semester) {
        semesters.add(semester);
    }

    public int calculateSemesterTotal(int semesterIndex) {
        int semesterTotal = 0;
        for (Subject subject : semesters.get(semesterIndex)) {
            semesterTotal += subject.getTotalMarks();
        }
        return semesterTotal;
    }

    public int calculateGrandTotal() {
        int grandTotal = 0;
        for (int i = 0; i < semesters.size(); i++) {
            grandTotal += calculateSemesterTotal(i);
        }
        return grandTotal;
    }

    // Getters and setters for the fields can be added here if needed
}

//student management class
import java.util.ArrayList;

public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudentDetails() {
        for (Student student : students) {
            System.out.println("Roll No: " + student.getRollNo());
            System.out.println("Name: " + student.getName());
            System.out.println("Course: " + student.getCourseOfStudy());
            for (int i = 0; i < 8; i++) {
                System.out.println("Semester " + (i + 1) + " Total: " + student.calculateSemesterTotal(i));
            }
            System.out.println("Grand Total: " + student.calculateGrandTotal());
            System.out.println("----------------------------------");
        }
    }

    // Additional methods for managing students can be added here
}

//main class
public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();

        // Creating subjects for a semester
        Subject[] semester1 = {
            new Subject("CS101", "Data Structures", 20, 50),
            new Subject("CS102", "Algorithms", 22, 48),
            // Add more subjects here
        };

        // Creating a student and adding semesters
        Student student1 = new Student(1, "John Doe", "01-01-2000", "Computer Science");
        student1.addSemester(semester1);
        // Add more semesters here

        // Adding student to management
        management.addStudent(student1);

        // Displaying details
        management.displayStudentDetails();
    }
}
