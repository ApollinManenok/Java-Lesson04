import java.util.Scanner;

public class Task3 {


    public static void main(String[] args) {
        Container arr = new Container(3);
        arr.add();
        arr.add();
        arr.add();
        arr.show();
        boolean exit = false;
        while (!exit) {
            System.out.print("\n\nIf you want to find patient by name press 1\nIf you want to find patient by age press 2\nIf you want to exit press 3\nEnter here: ");
            Scanner scan = new Scanner(System.in);
            int input;
            try {
                input = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong enter");
                continue;
            }
            switch (input) {
                case 1: {
                    scan.nextLine();
                    System.out.print("Enter patient name: ");
                    String name = scan.nextLine();
                    arr.findPatient(name);
                    break;
                }
                case 2: {
                    boolean check = true;
                    while (check) {
                        System.out.print("Enter patient age: ");
                        try{
                            int age = scan.nextInt();
                            arr.findPatient(age);
                            check = false;
                        } catch(Exception e){
                            System.out.println("Wrong enter.");
                        }
                        scan.nextLine();
                    }
                    break;
                }
                case 3: {
                    exit = true;
                    break;
                }
                default: {
                    System.out.println("There is no such option");
                }
            }
        }
        System.out.println("You exit the program.");
    }
}

