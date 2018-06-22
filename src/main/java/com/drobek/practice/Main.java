package com.drobek.practice;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String... arg) {
        Menu menu = new Menu();
        DoubleLinked doubleLinkedList = new DoubleLinked();
        int menuInput;
        do {
            menu.menu();
            menuInput = scanner.nextInt();


            switch (menuInput) {
                case 1:
                    System.out.println();
                    doubleLinkedList.print();
                    break;
                case 2:
                    System.out.println("Enter value for node ");
                    int input = scanner.nextInt();
                    doubleLinkedList.addNode(input);
                    break;
                case 3:
                    doubleLinkedList.removeLast();
                    break;
                case 4:
                    System.out.println("which node you want to remove?");
                    doubleLinkedList.removeAny(scanner.nextInt());
                    break;
            }
        } while (menuInput <= 4 && menuInput > 0);
    }
}
