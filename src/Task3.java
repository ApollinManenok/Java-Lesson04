import java.util.Scanner;

class Patient {
    private String _name;
    private int _age;
    private boolean _ill;
    private String _diagnosis;

    public String getName() {
        return _name;
    }

    public void setName(String newName) {
        _name = newName;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int newAge) {
        _age = newAge;
    }

    public boolean getStatus() {
        return _ill;
    }

    public void setStatus(boolean illness) {
        _ill = illness;
    }

    public String getDiagnosis() {
        return _diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        _diagnosis = diagnosis;
    }

    public String toString() {
        String str = "Patient " + _name + " - Age = " + _age;
        if (_ill)
            str = str.concat(" Current status: ill");
        else
            str = str.concat(" Current status: healthy");
        return str;
    }
}

public class Task3 {

    public static Patient fillInfo() {
        Patient person = new Patient();
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter patient name: ");
        String name = scan.nextLine();
        person.setName(name);
        System.out.print("Enter patient age: ");
        person.setAge(scan.nextInt());
        scan.nextLine();
        while (true) {
            System.out.print("Enter current status (ill/healthy): ");
            String status = scan.nextLine();
            if (status.contentEquals("ill")) {
                person.setStatus(true);
                System.out.print("Enter current diagnosis: ");
                person.setDiagnosis(scan.nextLine());
                break;
            } else if (status.contentEquals("healthy")) {
                person.setStatus(false);
                person.setDiagnosis("None");
                break;
            } else {
                System.out.println("Wrong enter.");
            }
        }
        return person;
    }

    public static void fullInfo(Patient person) {
        String str = person.toString();
        if (person.getStatus())
            str = str.concat(" " + person.getDiagnosis());
        System.out.println(str);
    }

    public static void shortInfo(Patient person) {
        System.out.println(person.toString());
    }

    public static boolean findPatient(Patient person, String name) {
        return person.getName().contains(name);
    }

    public static boolean findPatient(Patient person, int age) {
        return person.getAge() == age;
    }

    public static void main(String[] args) {
        Patient[] cardFiles = new Patient[5];
        for (int i = 0; i < cardFiles.length; i++) {
            cardFiles[i] = fillInfo();
        }
        System.out.println();
        for (int i = 0; i < cardFiles.length; i++) {
            shortInfo(cardFiles[i]);
        }
        boolean exit = false;
        while (!exit) {
            System.out.print("\nIf you want to find patient by name press 1\nIf you want to find patient by age press 2\nIf you want to exit press 3\nEnter here: ");
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
                    boolean result = false;
                    for (int i = 0; i < cardFiles.length; i++) {
                        if (findPatient(cardFiles[i], name)) {
                            fullInfo(cardFiles[i]);
                            result = true;
                        }
                    }
                    if (!result)
                        System.out.println("There is no patient with such name.");
                    break;
                }
                case 2: {
                    System.out.print("Enter patient age: ");
                    int age = scan.nextInt();
                    boolean result = false;
                    for (int i = 0; i < cardFiles.length; i++) {
                        if (findPatient(cardFiles[i], age)) {
                            fullInfo(cardFiles[i]);
                            result = true;
                        }
                    }
                    if (!result)
                        System.out.println("There is no patient with such age.");
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

