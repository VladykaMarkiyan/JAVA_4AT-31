package org.example;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4};

        for (int num : numbers) {
            System.out.println(num);
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        System.out.println("сума - "+ sum);
    }
}