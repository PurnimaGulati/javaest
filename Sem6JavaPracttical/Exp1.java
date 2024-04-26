import java.util.Scanner;

public class Exp1 {
    static class Employee{
        int e_id;
        String name;
        int salary;
        String designation;
        Employee(){

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please Enter the number of employees ");
        int numberOfEmploye = in.nextInt();
        Employee[] employees = new Employee[numberOfEmploye];
        for (int i = 0; i < numberOfEmploye; i++) {
            employees[i] = new Employee();
            System.out.print("Please Enter the id of employee ");
            employees[i].e_id = in.nextInt();
            in.nextLine();
            System.out.print("Please Enter the name of employee ");
            employees[i].name = in.nextLine();
            System.out.print("Please Enter the salary of employee ");
            employees[i].salary = in.nextInt();
            in.nextLine();
            System.out.print("Please Enter the designation of employee ");
            employees[i].designation = in.nextLine();
        }
        for (int i = 0; i < numberOfEmploye; i++) {
            System.out.println("id of employee : "+employees[i].e_id);
            System.out.println("the name of employee "+employees[i].name);
            System.out.println("the salary of employee "+employees[i].salary);
            System.out.println("the designation of employee "+employees[i].designation);
        }
    }
}
