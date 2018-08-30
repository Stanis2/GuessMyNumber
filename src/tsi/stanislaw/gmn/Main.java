package tsi.stanislaw.gmn;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int myNum = rand.nextInt(100) + 1;
        System.out.println(myNum);
        boolean userLost = true;
        boolean userYes = false;

        for (int i = 1; i < 11; i++) {
            System.out.println("Попытка #" + i);
            int userNum = scan.nextInt();

            if (userNum > myNum) {
                System.out.println("Много");
            } else if (userNum < myNum) {
                System.out.println("Мало");
            } else {
                System.out.println("Угадал");
                userLost = false;
                System.out.println("Играть еще раз?");
                userYes = false;
            }
        }

        if (userLost) {
            System.out.println("Попробовать еще раз?");
            userYes = true;
        }

        if (userYes) {
            System.exit(1);
        } else {
            System.exit(0);
        }
    }
}
