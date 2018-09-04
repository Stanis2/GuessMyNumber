package tsi.stanislaw.gmn;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random rand = new Random();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Start a new game?");
        String answer = askAns();

        if (answer.equals("No")) {
            System.exit(0);
        } else if (answer.equals("Yes")) {

            do {
                int myNum = rand.nextInt(100) + 1;
                System.out.println(myNum);
                boolean userLost = true;
                boolean userWin = false;

                for (int i = 1; i < 11; i++) {
                    System.out.println("Attempt #" + i);
                    int userNum = askNum();

                    if (userNum > myNum) {
                        System.out.println("Too much!");
                    } else if (userNum < myNum) {
                        System.out.println("Too little!");
                    } else {
                        System.out.println("You've guessed my number!");
                        userLost = false;
                        userWin = true;
                        break;
                    }
                }

                if (userLost) {
                    System.out.println("Try again?");
                    answer = askAns();
                }

                if (userWin) {
                    System.out.println("Play again?");
                    answer = askAns();
                }
            } while (answer.equals("Yes"));
        }
    }

    private static String askAns() {
        String answer;
        do {
            System.out.println("Yes or No");
            answer = scan.next();
        } while (!answer.equals("Yes") && !answer.equals("No"));
        return answer;
    }

    private static int askNum() {
        int answer;
        do {
            try {
                answer = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Only numbers!");
                scan.next();
                continue;
            }
            if (answer < 1 || answer > 100) {
                System.out.println("Only numbers between 1 - 100");
            } else {
                return answer;
            }
        } while (true);
    }
}
