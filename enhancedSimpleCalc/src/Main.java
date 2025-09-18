import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        char operator;
        String numberInput;
        double[] numbers;
        int size;
        while (true) {


            System.out.print("choose an operator + | - | * | / | ^ : ");
            operator = scanner.next().charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '^') {
                break;
            }else {
                System.out.println("Invalid operator, try again:");
            }
        }
        scanner.nextLine();
        /*
        while (true){
            System.out.print("how much numbers you wanna operate: ");
            try{
                size = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid input accepts only numbers!");
                continue;
            }
            scanner.nextLine();
            if (size < 0){
                System.out.println("does not accept negative numbers");
                continue;
            }else {
                numbers = new double[size];
                break;
            }
        }

         */
        while (true){
            System.out.print("enter the numbers you wanna operate (spaced): ");
            numberInput = scanner.nextLine().trim().replace(',', '.');
            String[] parts = numberInput.split("\\s+");
            try{
                numbers = new double[parts.length];
                for (int i = 0; i < parts.length ; i++){
                    numbers[i] = Double.parseDouble(parts[i]);
                }
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid number format, try again!");
                continue;
            }
        }

        System.out.println("You chose operator: " + operator);
        System.out.print("Numbers: ");
        for (double n : numbers) {
            System.out.print(n + " ");
        }
        scanner.close();
    }
}
