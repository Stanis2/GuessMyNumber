package tsi.stanislaw.gmn;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Начать игру?");
        String answer = ask();

        if (answer.equals("Нет")){
            System.exit(0);
        } else if (answer.equals("Да")) {

            do {

                int myNum = rand.nextInt(100) + 1;
                System.out.println(myNum);
                boolean userLost = true;
                boolean userWin = false;

                for (int i = 1; i < 11; i++) {
                    System.out.println("Попытка #" + i);
                    int userNum = scan.nextInt();

                    if (userNum > myNum) {
                        System.out.println("Много!");
                    } else if (userNum < myNum) {
                        System.out.println("Мало!");
                    } else {
                        System.out.println("Угадал!");
                        userLost = false;
                        userWin = true;
                        break;
                    }
                }

                if (userLost) {
                    System.out.println("Попробовать еще раз?");
                    answer = ask();
                }

                if (userWin) {
                    System.out.println("Играть еще раз?");
                    answer = ask();
                }

            } while (answer.equals("Да"));
        } else {
            System.out.println("Ошибка ввода!");
            System.exit(0);
        }
    }

    static String ask(){
        String answer;
        do {
            System.out.println("Да или Нет");
            answer = scan.next();
        } while (!answer.equals("Да") && !answer.equals("Нет"));
        return answer;
    }
}
