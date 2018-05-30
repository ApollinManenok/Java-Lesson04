import java.util.Scanner;

public class Task2 {

    public static int checkPagesAmount(int recordAmount) {
        return (int) Math.ceil(recordAmount / 10.d);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter total amount of records: ");
        int records = scan.nextInt();
        scan.close();
        int pages = checkPagesAmount(records);
        System.out.print("You will need " + pages + " pages.");
    }
}
