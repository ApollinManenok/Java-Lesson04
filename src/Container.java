import java.util.Scanner;

public class Container {
    private Patient[] array;
    private int index = 0;

    public Container(int size) {
        array = new Patient[size];
    }

    public void add() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter patient name: ");
        String name = scan.nextLine();
        int age = 0;
        boolean check = true;
        while (check) {
            System.out.print("Enter patient age: ");
            try {
                age = scan.nextInt();
                check = false;
            } catch (Exception e) {
                System.out.println("Wrong enter");
            }
            scan.nextLine();
        }
        boolean ill;
        String diagnosis;
        while (true) {
            System.out.print("Enter current status (ill/healthy): ");
            String status = scan.nextLine();
            if (status.contentEquals("ill")) {
                ill = true;
                System.out.print("Enter current diagnosis: ");
                diagnosis = scan.nextLine();
                break;
            } else if (status.contentEquals("healthy")) {
                ill = false;
                diagnosis = "None";
                break;
            } else {
                System.out.println("Wrong enter.");
            }
        }
        array[index] = new Patient(name, age, ill, diagnosis);
        index++;
    }

    public void show(){
        for (int i = 0; i < index; i++) {
            System.out.print(array[i].toString());
        }
    }

    public void findPatient(String name) {
        boolean result = true;
        for (int i = 0; i < index; i++) {
            if (array[i].getName().contains(name)) {
                System.out.print(array[i].toString());
                result = false;
            }
        }
        if(result)
            System.out.println("There is no patient with such name.");
    }

    public void findPatient(int age) {
        boolean result = true;
        for (int i = 0; i < index; i++) {
            if (array[i].getAge() == age) {
                System.out.print(array[i].toString());
                result = false;
            }
        }
        if(result)
            System.out.println("There is no patient with such age.");
    }
}
