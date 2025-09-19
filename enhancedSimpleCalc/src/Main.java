import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        char operator;
        String numberInput;
        double[] numbers;
        int size;
        String giveResult = "this is the result: ";
        boolean valid = false;
        while (!valid) {
            while (true) {


                System.out.print("choose an operator + | - | * | / | ^ : ");
                operator = scanner.next().charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '^') {
                    break;
                } else {
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
            while (true) {
                System.out.print("enter the numbers you wanna operate (spaced): ");
                numberInput = scanner.nextLine().trim().replace(',', '.');
                String[] parts = numberInput.split("\\s+");
                try {
                    numbers = new double[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        numbers[i] = Double.parseDouble(parts[i]);
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format, try again!");
                    continue;
                }
            }

            switch (operator) {
                case '+' -> System.out.println(giveResult + plus(numbers));
                case '-' -> System.out.println(giveResult + minus(numbers));
                case '*' -> System.out.println(giveResult + times(numbers));
                case '/' -> System.out.println(giveResult + division(numbers));
                case '^' -> System.out.println(giveResult + power(numbers));
            }

        }
        scanner.close();
    }
    static double plus(double... numbers){
        double result = 0;
        for(double number : numbers){
            result += number;
        }
        return result;
    }
    static double minus(double... numbers){
        double result = numbers[0];
        for(int i = 1 ; i < numbers.length; i++){
            result -= numbers[i];
        }
        return result;
    }
    static double times(double... numbers){
        double result = numbers[0];
        for (int i = 1 ; i < numbers.length; i++){
            result *= numbers[i];
        }

        return result;
    }
    static double division(double... numbers){
        double result = numbers[0];
        for (int i = 1 ; i < numbers.length; i++){
            if (numbers[i] == 0){
                System.out.println("Invalid number,Can't devide by zero");
                return 0;
            }
            result /= numbers[i];
        }
        return result;
    }
    static double power(double... numbers){
        double result = numbers[0];
        for (int i = 1 ; i < numbers.length; i++){
            result = Math.pow(result, numbers[i]);
        }
        return result;
    }
}
