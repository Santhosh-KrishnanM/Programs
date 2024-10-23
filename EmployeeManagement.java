import java.util.*;

class Employee {
   private String ID;
   private String name;
   private String desig;
   private String dept;
   private double salary;

   Employee(String ID, String name, String desig, String dept, double salary) {
      this.ID = ID;
      this.name = name;
      this.desig = desig;
      this.dept = dept;
      this.salary = salary;
   }

   @Override
   public boolean equals(Object ob) {
      if (this == ob)
         return true;
      if (ob instanceof Employee) {
          Employee employee = (Employee) ob;
          return Objects.equals(ID, employee.ID);
      }
      return false;
       // Compare based on Employee ID
   }

   @Override
   public String toString() {
      return "[" + ID + ", " + name + ", " + desig + ", " + dept + ", " + salary + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(ID);
   }
}

class EmployeeManagement {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      Employee[] emp = new Employee[10];
      System.out.println("1. Enter Details\n2. Display Details\n3. Exit");
      while (true) {
         System.out.print("Enter a choice: ");
         int ch = scan.nextInt();
         switch (ch) {
            case 1:
               System.out.println("Enter employee details");
               System.out.print("Employee ID: ");
               String ID = scan.next();
               scan.nextLine(); // Consume the newline
               System.out.print("Name: ");
               String name = scan.nextLine();
               System.out.print("Designation: ");
               String desig = scan.nextLine();
               System.out.print("Department: ");
               String dept = scan.nextLine();
               System.out.print("Salary: ");
               double salary = scan.nextDouble();

               Employee employee = new Employee(ID, name, desig, dept, salary);
               int index = Math.abs(employee.hashCode()) % 10; // Ensuring positive index

               if (emp[index] == null) {
                  emp[index] = employee;
                  System.out.println("Employee added at index " + index);
               } else if (emp[index].equals(employee)) {
                  System.out.println("Duplicate employee. Cannot add.");
               }
               break;

            case 2:
               // Display employee details
               System.out.println("Employee Details:");
               for (int k = 0; k < emp.length; k++) { // Loop through all possible indices
                  if (emp[k] != null) {
                     System.out.println("Index " + k + ": " + emp[k]);
                  } else {
                     System.out.println("Index " + k + ": [Empty]");
                  }
               }
               break;

            case 3:
               System.out.println("Exiting");
               return; // Exit the program

            default:
               System.out.println("Invalid choice");
               break;
         }
      }
   }
}
