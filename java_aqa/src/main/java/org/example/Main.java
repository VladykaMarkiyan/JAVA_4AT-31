package org.example;
// V 4: Primitive Arrays 
// Objective: To understand and use arrays in Java with primitive types.
// Instructions:
// Declare and initialize an array of integers.
// Use a for loop to print the elements of the array to the console.
// Use a for loop to find the sum of the elements in the array.

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
