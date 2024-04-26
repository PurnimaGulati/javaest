import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Exp6 {
    static class StudentList {
        ArrayList<String> arr;
        Scanner in;

        StudentList() {
            arr = new ArrayList<>();
            in = new Scanner(System.in);
        }

        void Menu() {
            while (true) {
                System.out.println("1. Add\n2. Delete\n3. Display\n4. Search\n-1. Exit");
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1)
                    Add();
                else if (choice == 2)
                    Delete();
                else if (choice == 3)
                    Display();
                else if (choice == 4)
                    Search();
                else if (choice == -1)
                    break;
                else
                    System.out.println("Please Enter a valid choice");
            }
        }

        void Add() {
            System.out.print("Enter the string you want to add: ");
            String input = in.nextLine();
            arr.add(input);
        }

        void Delete() {
            System.out.print("Please Enter the string you want to delete : ");
            String s = in.nextLine();
            if (arr.contains(s)) {
                int index = arr.indexOf(s);
                arr.remove(index);
            } else {
                System.out.println("Element doesn't exist");
            }
        }

        void Display() {
            Iterator<String> it = arr.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

        void Search() {
            System.out.print("Please Enter the string you want to Search : ");
            String s = in.nextLine();
            if (arr.contains(s)) {
                int index = arr.indexOf(s);
                System.out.println("Element found at index : " + index);
            } else {
                System.out.println("Element doesn't exist");
            }
        }
    }

    public static void main(String[] args) {
        StudentList obj = new StudentList();
        obj.Menu();
    }
}
