package tsi.stanislaw.gmn;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Начать игру? Да или Нет.");
        String answer = scan.next();

        if (answer.equals("Нет")){
            System.exit(0);
        }

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
                    System.out.println("Играть еще раз? Да или Нет.");
                    i = 11;
                }
            }

            if (userLost) {
                System.out.println("Попробовать еще раз? Да или Нет.");
                answer = scan.next();
            }

            if (userWin) {
                answer = scan.next();
            }

        } while (answer.equals("Да"));

    }
}
