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

