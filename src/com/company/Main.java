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

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i].length() > numbers[j].length()) {
                    String temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println(numbers[0] + " the shortest. Length: " + numbers[0].length());
        System.out.println(numbers[numbers.length - 1] + " the longest. Length: " + numbers[numbers.length - 1].length());
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length / 2; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");

        String smallestAmountOfUniqueSymbols = numbers[0];
        int evenOnlyAmount = 0;
        for (String number : numbers) {
            if (numberOfUniqueSymbols(number) < numberOfUniqueSymbols(smallestAmountOfUniqueSymbols)) {
                smallestAmountOfUniqueSymbols = number;
            }
            if (evenAmount(number) == number.length()) {
                evenOnlyAmount++;
            }
        }
        System.out.println(smallestAmountOfUniqueSymbols + " smallest amount of unique symbols");
        System.out.println(evenOnlyAmount + " even symbols only amount");

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
        int shiftedMatrix[][]=new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                shiftedMatrix[i][j]=matrix[i][(j+shift)%n];
            }
        }
        System.out.println(Arrays.deepToString(shiftedMatrix) + " shifted right");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                shiftedMatrix[i][j]=matrix[(i+shift)%n][j];
            }
        }
        System.out.println(Arrays.deepToString(shiftedMatrix) + " shifted down");

        //9.3
        int count=0;
        int record=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length-1; j++) {
                if (matrix[i][j] < matrix[i][j + 1]) {
                    count++;
                } else {
                    if (record<count) {
                        record=count;
                    }
                    count=0;
                }
            }
        }
        System.out.println(record + " max length of increasing sequence");
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Choose program(1-6)");
        int program = sc.nextInt();
        switch (program) {
            case 1:
                greating();
                break;
            case 2:
                argumentsBackOrder(args);
                break;
            case 3:
                randToRowAndString();
                break;
            case 4:
                passwordCheck();
                break;
            case 5:
                argsSumAndMultyplying(args);
                break;
            case 6:
                six();
                break;
        }*/

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
        //System.out.println(Arrays.toString(arr));
    }

    private static void six() {
        Scanner scf = new Scanner(System.in);
        String allNumbers = scf.nextLine();
        String[] numbers = allNumbers.split(" ");
        int max = Integer.parseInt(numbers[0]);
        int min = Integer.parseInt(numbers[0]);
        HashMap<Integer, String> map = new HashMap<>();
        for (String num : numbers) {
            int numAsInt = Integer.parseInt(num);
            if (numAsInt % 2 == 0) {
                map.put(numAsInt, "even");
            } else {
                map.put(numAsInt, "odd");
            }
            if ((numAsInt % 3 == 0) || (numAsInt % 9 == 0)) {
                map.put(numAsInt, "div 3 or 9");
            }
            if ((numAsInt % 5 == 0) && (numAsInt % 7 == 0)) {
                map.put(numAsInt, "div 5 and 7");
            }
            if (numAsInt > max) {
                max = numAsInt;
            }
            if (numAsInt < min) {
                min = numAsInt;
            }
            String[] letters = num.split("");
            if (letters.length == 4) {
                if ((Integer.parseInt(letters[0]) + Integer.parseInt(letters[1])) == (Integer.parseInt(letters[2]) + Integer.parseInt(letters[3]))) {
                    map.put(numAsInt, "happy");
                }
            }
        }
        System.out.println(map);
        System.out.println("max " + max);
        System.out.println("min " + min);
    }

    private static void argsSumAndMultyplying(String[] args) {
        int sum = 0, mul = 1;
        for (String arg : args) {
            sum += Integer.parseInt(arg);
            mul *= Integer.parseInt(arg);
        }
        System.out.println(sum);
        System.out.println(mul);
    }

    private static void passwordCheck() {
        System.out.println("enter your password");
        Scanner sc2 = new Scanner(System.in);
        String uin = sc2.nextLine();
        if (uin.equals(password)) {
            System.out.println("Password correct");
        } else {
            System.out.println("Password incorrect");
        }
    }

    private static void randToRowAndString() {
        System.out.println("Insert number of elements");
        Scanner sc1 = new Scanner(System.in);
        int num = sc1.nextInt();
        Random arr[] = new Random[num];
        for (int i = 0; i < num; i++) {
            arr[i] = new Random();
            System.out.print(arr[i].nextInt() + " ");
        }
        System.out.println("");
        for (int i = 0; i < num; i++) {
            System.out.println(arr[i].nextInt());
        }
    }

    private static void argumentsBackOrder(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }

    private static void greating() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Hi, " + name);
    }
}
