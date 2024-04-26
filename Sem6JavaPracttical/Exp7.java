import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Exp7 {
    static class Employee{
        int E_id;
        String name;
        int salary;
        Employee(Scanner in){
            System.out.print("Please Enter ID of Employee : ");
            E_id = in.nextInt();
            in.nextLine();
            System.out.print("Please Enter Name of Employee : ");
            name = in.nextLine();
            System.out.print("Please Enter salary of Employee : ");
            salary = in.nextInt();
        }
    }
    static class EmployeeUse{
        ArrayList<Employee> arr = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        void Menu(){
            while (true){
                System.out.println("1 -> Add Employee\n2 -> All Employee\n3 -> Exit The App");
                int choice = in.nextInt();
                in.nextLine();
                if(choice==1)
                    Add();
                if(choice==2)
                    Display();
                if(choice==3){
                    System.out.println("Exiting...");
                    break;
                }
            }
        }
        void Add(){
            Employee obj = new Employee(in);
            arr.add(obj);
        }
        void Display(){
            for (int i = 0; i < arr.size(); i++) {
                System.out.println("Employee name : " + arr.get(i).name);
                System.out.println("Employee ID : " + arr.get(i).E_id);
                System.out.println("Employee salary : " + arr.get(i).salary);

            }
        }
    }

    public static void main(String[] args) {
        EmployeeUse obj = new EmployeeUse();
        obj.Menu();
    }
}
