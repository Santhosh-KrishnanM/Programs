import java.util.ArrayList;
import java.util.List;

class Subject {
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

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }
}

class Student {
    private int rollNo;
    private String name;
    private String dateOfBirth;
    private String courseOfStudy;
    private List<Subject[]> semesters; // List of semesters, each semester has an array of subjects

    public Student(int rollNo, String name, String dateOfBirth, String courseOfStudy) {
        this.rollNo = rollNo;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.courseOfStudy = courseOfStudy;
        this.semesters = new ArrayList<>();
    }

    public void addSemester(Subject[] subjects) {
        semesters.add(subjects);
    }

    public int calculateSemesterTotal(int semesterIndex) {
        int total = 0;
        for (Subject subject : semesters.get(semesterIndex)) {
            total += subject.getTotalMarks();
        }
        return total;
    }

    public int calculateGrandTotal() {
        int grandTotal = 0;
        for (int i = 0; i < semesters.size(); i++) {
            grandTotal += calculateSemesterTotal(i);
        }
        return grandTotal;
    }

    public void printStudentDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Course of Study: " + courseOfStudy);
    }

    public void printSemesterDetails() {
        for (int i = 0; i < semesters.size(); i++) {
            System.out.println("Semester " + (i + 1) + ":");
            for (Subject subject : semesters.get(i)) {
                System.out.println("  " + subject.getSubjectName() + " (Code: " + subject.getSubjectCode() + ") - Total Marks: " + subject.getTotalMarks());
            }
            System.out.println("  Semester Total: " + calculateSemesterTotal(i));
        }
        System.out.println("Grand Total: " + calculateGrandTotal());
    }
}

class StudentManagement {
    private List<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printAllStudentsDetails() {
        for (Student student : students) {
            student.printStudentDetails();
            student.printSemesterDetails();
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating subjects for semester 1
        Subject[] semester1Subjects = {
            new Subject("CS101", "Mathematics", 30, 70),
            new Subject("CS102", "Physics", 25, 65),
            new Subject("CS103", "Chemistry", 28, 72),
            new Subject("CS104", "Biology", 27, 63),
            new Subject("CS105", "English", 29, 71),
            new Subject("CS106", "History", 26, 64),
            new Subject("CS107", "Geography", 24, 66),
            new Subject("CS108", "Computer Science", 31, 69)
        };

        // Creating a student and adding semester 1 subjects
        Student student1 = new Student(1, "John Doe", "01-01-2000", "BSc Computer Science");
        student1.addSemester(semester1Subjects);

        // Adding more semesters similarly
        // Repeat the above for other semesters and subjects as required

        // Managing students
        StudentManagement management = new StudentManagement();
        management.addStudent(student1);

        // Print details of all students
        management.printAllStudentsDetails();
    }
}
