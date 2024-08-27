//Employee
class Employee {
    private int id;
    private String name;
    private double basic;
    private double DA;
    private double HRA;
    private double CCA;
    private double grossPay;
    private double netPay;
    private boolean isMetro;

    // Constructor
    public Employee(int id, String name, double basic, boolean isMetro) {
        this.id = id;
        this.name = name;
        this.basic = basic;
        this.isMetro = isMetro;
        calculateSalaries();
    }

    // Method to calculate salaries
    private void calculateSalaries() {
        this.DA = 0.87 * basic; // DA is 87% of basic
        this.HRA = 1000; // HRA is Rs. 1000
        this.CCA = isMetro ? 500 : 250; // CCA is Rs. 500 for metro, Rs. 250 for others
        this.grossPay = basic + DA + HRA + CCA;

        // Deduct Income Tax at 10% if gross pay exceeds Rs. 50,000
        if (grossPay > 50000) {
            double incomeTax = 0.10 * grossPay;
            this.netPay = grossPay - incomeTax;
        } else {
            this.netPay = grossPay;
        }
    }

    // Method to display employee details
    public void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.printf("Basic Salary: Rs. %.2f%n", basic);
        System.out.printf("DA: Rs. %.2f%n", DA);
        System.out.printf("HRA: Rs. %.2f%n", HRA);
        System.out.printf("CCA: Rs. %.2f%n", CCA);
        System.out.printf("Gross Pay: Rs. %.2f%n", grossPay);
        System.out.printf("Net Pay: Rs. %.2f%n", netPay);
        System.out.println();
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        // Array of Employee objects
        Employee[] employees = new Employee[3];

        // Creating Employee objects
        employees[0] = new Employee(101, "John Doe", 40000, true);
        employees[1] = new Employee(102, "Jane Smith", 55000, false);
        employees[2] = new Employee(103, "Bob Brown", 60000, true);

        // Displaying employee details
        for (Employee emp : employees) {
            emp.display();
        }
    }
}
