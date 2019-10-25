package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String password = "ttt1234567";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numbers = input.split("\\s+");

        int avgLength = 0;
        for (int i = 0; i < numbers.length; i++) {
            avgLength += numbers[i].length();
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i].length() > numbers[j].length()) {
                    String temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        avgLength /= numbers.length;

        //1-3 out
        System.out.println(numbers[0] + " the shortest. Length: " + numbers[0].length());
        System.out.println(numbers[numbers.length - 1] + " the longest. Length: " + numbers[numbers.length - 1].length());
        System.out.println("Sorted shortest-longest");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Sorted longest-shortest");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
        System.out.println("Less than average length");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].length() < avgLength) {
                System.out.print(numbers[i] + " ");
            } else {
                break;
            }
        }
        System.out.println("");

        //4
        String smallestAmountOfUniqueSymbols = numbers[0];

        for (String number : numbers) {
            if (numberOfUniqueSymbols(number) < numberOfUniqueSymbols(smallestAmountOfUniqueSymbols)) {
                smallestAmountOfUniqueSymbols = number;
            }
        }
        System.out.println(smallestAmountOfUniqueSymbols + " smallest amount of unique symbols");

        //5
        for (String number : numbers) {
            if (Integer.parseInt(number) % 2 == 0) {
                if (evenAmount(number) == number.length() / 2) {
                    System.out.print(number + " ");
                }
            }
        }
        System.out.println("");
        System.out.println("Equal amount of oods and evens from only odd numbers");

        //6
        for (String number : numbers) {
            String[] numAsArray = number.split("");
            int[] numAsIntArray = new int[numAsArray.length];
            for (int i = 0; i < numAsArray.length; i++) {
                numAsIntArray[i] = Integer.parseInt(numAsArray[i]);
            }
            Arrays.sort(numAsIntArray);
            int similarCount = 0;
            for (int i = 0; i < numAsArray.length; i++) {
                if (numAsIntArray[i] == Integer.parseInt(numAsArray[i])) {
                    similarCount++;
                }
            }
            if (similarCount == numAsArray.length) {
                System.out.println(number + " symbols from smallest to biggest");
                break;
            }
        }

        //7
        for (String number : numbers) {
            if (numberOfUniqueSymbols(number) == number.length()) {
                System.out.println(number + " all symbols unique");
                break;
            }
        }


        //9
        System.out.println("Task 9. Enter n-size");
        Scanner sc1 = new Scanner(System.in);
        int n = Integer.parseInt(sc1.nextLine());

        //matrix init
        int matrix[][] = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix.length; i1++) {
                matrix[i][i1] = (int) Math.round(Math.random() * 10 - 5);
            }
            bubbleSort(matrix[i]);
        }

        //а так не может заполнить массив. Почему?
        /*for (int[] ints : matrix) {
            for (int anInt : ints) {
                anInt= (int) Math.round(Math.random()*10-5);
                System.out.println(anInt);
            }
        }*/

        System.out.println(Arrays.deepToString(matrix) + " sorted by table strings");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (matrix[j][i] > matrix[j + 1][i]) {
                    int tmp = matrix[j][i];
                    matrix[j][i] = matrix[j + 1][i];
                    matrix[j + 1][i] = tmp;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix) + " sorted by table row");

        //9.2
        int shift = 2;
        int shiftedMatrix[][] = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                shiftedMatrix[i][j] = matrix[i][(j + shift) % n];
            }
        }
        System.out.println(Arrays.deepToString(shiftedMatrix) + " shifted right");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                shiftedMatrix[i][j] = matrix[(i + shift) % n][j];
            }
        }
        System.out.println(Arrays.deepToString(shiftedMatrix) + " shifted down");

        //9.3
        int count = 0;
        int record = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (matrix[i][j] < matrix[i][j + 1]) {
                    count++;
                } else {
                    if (record < count) {
                        record = count;
                    }
                    count = 0;
                }
            }
        }
        System.out.println(record + " max length of increasing sequence");
    }

    private static int evenAmount(String number) {
        String numberAsArray[] = number.split("");
        int evenAmount = 0;
        for (String s : numberAsArray) {
            if (Integer.parseInt(s) % 2 == 0) {
                evenAmount++;
            }
        }
        return evenAmount;
    }

    private static int numberOfUniqueSymbols(String number) {
        String numberAsArray[] = number.split("");
        int uniqueCount = 0;
        for (String s : numberAsArray) {
            int unique = 0;
            for (String s1 : numberAsArray) {
                if (!s.equals(s1)) {
                    unique++;
                }
            }
            if (unique == numberAsArray.length - 1) {
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    private static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
