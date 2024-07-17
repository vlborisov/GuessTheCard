package org.example;

import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static String[] cards = {"6", "7", "8", "9", "10", "в", "д", "к", "т"};

    public static void main(String[] args) {
        System.out.println("Привет!\nЯ игра Угадайка");
        while (true) {
            System.out.println("Напиши любой номинал карты (6,7,8,9,10,В,Д,К,Т): ");
            String randomChoice = cards[(int) (Math.random() * cards.length)];
            String playerChoice = input();
            if (randomChoice.equals(playerChoice)) {
                System.out.printf("Ты угадал!\nЯ загадывал: %s\nХочешь попробовать снова? Введи да или нет: %n", randomChoice.toUpperCase());
                if (!repeatCheck()) {
                    System.out.println("Пока! Приходи еще :)");
                    break;
                }
            } else {
                System.out.printf("Ты не угадал!\nЯ загадывал: %s\nХочешь попробовать снова?%n", randomChoice.toUpperCase());
                if (!repeatCheck()) {
                    System.out.println("Пока! Приходи еще :)");
                    break;
                }
            }
        }
    }

    public static String input() {
        while (true) {
            String inputLine = in.nextLine().toLowerCase();
            if (checkMatch(inputLine)) {
                return inputLine;
            } else {
                System.out.println("Некорректный ввод!\nНапиши любой номинал карты (6,7,8,9,10,В,Д,К,Т): ");
            }
        }
    }

    public static boolean checkMatch(String input) {
        for (int i = 0; i < cards.length; i++) {
            if (input.equals(cards[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean repeatCheck() {
        while (true) {
            String inputLine = in.nextLine().toLowerCase();
            if (inputLine.equals("да") || inputLine.equals("нет")) {
                if (inputLine.equals("да")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println("Некорректный ввод!\nНапиши \"да\" или \"нет\": ");
            }
        }
    }
}

