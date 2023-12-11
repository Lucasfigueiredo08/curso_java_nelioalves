package listas;

import jdk.nashorn.api.tree.TemplateLiteralTree;
import listas.entities.Employee;
import vetores.entities.Rent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc =new Scanner(System.in);

        List<Employee> employeesList = new ArrayList<>();

        System.out.println("How many employees will be registered? ");
        int n = sc.nextInt();

        for(int i = 0; i<n; i++){
            Employee aux  = new Employee();
            sc.nextLine();
            System.out.println("Employee #" + (i+1) + ":");
            System.out.print("Id: ");
            aux.setId(sc.nextLong());
            System.out.print("Name: ");
            aux.setName(sc.next());
            System.out.print("Salary: ");
            aux.setSalary(sc.nextDouble());

            employeesList.add(aux);
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        long id = sc.nextLong();

        boolean exists = false;

        for (var e : employeesList) {
            if (e.getId().equals(id)){
                System.out.print("Enter the percentage: ");
                int i = sc.nextInt();
                double v = (e.getSalary() / 100) * i;
                e.setSalary(e.getSalary() + v);
                exists = true;
            } else {
                System.out.println("ID não existe");
            }
        }

        if(exists){
            System.out.println();
            System.out.println("List of employees: ");
            for (var e : employeesList) {
                System.out.println(e);
            }
        }

        sc.close();
    }


}
