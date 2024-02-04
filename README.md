# Employee_payroll_System
A simple Employee Payroll System implemented in Java using Object-Oriented Programming (OOP) concepts. This system allows the addition and removal of employees, along with displaying their details.

# Table of Contents #
## Introduction ##
The Employee Payroll System is designed to manage employee information and calculate salaries based on employment type. The system includes two types of employees: Full-Time Employees and Part-Time Employees.
## Project Structure ##
Employee.java: Abstract class representing a generic employee.<br>
FullTimeEmployee.java: Class for full-time employees, extending the Employee class. <br>
PartTimeEmployee.java: Class for part-time employees, also extending the Employee class. <br>
PayrollSystem.java: Class managing the payroll system, including adding, removing, and displaying employees. <br>
Main.java: Main class to demonstrate the functionality of the Employee Payroll System. <br>

## How to Use ##

### Adding Employees:
<br>
Instantiate FullTimeEmployee or PartTimeEmployee objects.
<br>
Use the addEmployee method in PayrollSystem to add employees.
<br>

### Removing Employees: ###
Use the removeEmployee method in PayrollSystem by providing the employee's ID.
<br>

### Displaying Employees:###
Utilize the displayEmployees method in PayrollSystem to show the current list of employees.
## Code Snippets ##
import java.util.ArrayList;

//code snippet for Employee Class
abstract class Employee{

    private String name;
    private int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();
    @Override
    public  String toString(){
        return "Employee [name="+name+", id="+id+" salary="+calculateSalary()+"]";
    }
}


//code snippet for FullTimeEmployee Class
class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

}

//code snippet for PartTimeEmployee Class
class PartTimeEmployee extends Employee{

    private int hourWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name, int id,int hourWorked, double hourlyRate){
        super(name,id);
        this.hourWorked=hourWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return (hourWorked*hourlyRate);
    }
}

//code snippet for Payroll System
class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList =new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for (Employee employee:employeeList) {
            if (employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for (Employee employee :employeeList) {
            System.out.println(employee);
        }
    }
}

//code snippet for main Method
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem=new PayrollSystem();
        FullTimeEmployee fullTimeEmployee=new FullTimeEmployee("Akash",1,60000);
        PartTimeEmployee partTimeEmployee=new PartTimeEmployee("Shinu",2,8,200);

        payrollSystem.addEmployee(fullTimeEmployee);
        payrollSystem.addEmployee(partTimeEmployee);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employee Details: ");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details");
        payrollSystem.displayEmployees();
    }
}




## Build and Run Instructions ##
Compile the Java files using a Java compiler.
<br>
Run the Main class
## Contact Information ##
Name: Akash Pal<br>
Mobile Num:9321365436<br>
Email Id: akashpal91522@gmail.com<br>
Linkedin: https://www.linkedin.com/in/akash-pal113/



