package com.tw;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Operate operate = new Operate();

        while (true){
            int choice = operate.startShow();
            switch (choice){
                case 1:
                    operate.addStudent();
                    continue;
                case 2:
                    operate.showStudent();
                    continue;
                case 3:
                    System.exit(0);
            }
        }

    }
}
