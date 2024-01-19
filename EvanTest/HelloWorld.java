import java.util.Scanner;

public final class HelloWorld {
    private HelloWorld() {
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int result = 5;
        // Prompting the user for a number
        System.out.println("Please input a number");

        int userNumber = Integer.valueOf(scanner.nextLine());

        System.out.println("Please input an operation");

        // scanner.nextLine();

        String userOperation = scanner.nextLine();

        System.out.println("Please input a second number");

        int userNumber2 = Integer.valueOf(scanner.nextLine());

        if (userOperation == "plus") {
            result = userNumber + userNumber2;
        }
        if (userOperation == "-") {
            result = userNumber - userNumber2;
        }
        if (userOperation == "*") {
            result = userNumber * userNumber2;
        }
        if (userOperation == "/") {
            result = userNumber / userNumber2;
        } else {
            result = userNumber + userNumber2;
            System.out.println("Operation not recognized" + userNumber + userNumber2 + userOperation + result);
        }

        System.out.println("The answser is " + result);

    }
}
