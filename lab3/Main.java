package aqa_course.task3;

// V4.
//Array Intersection: Write a Java program that takes two arrays of integers and finds their intersection. Your program should prompt the user to enter the size and the elements of both arrays and then output the common elements between them.
//Make HashMap from the result array and perform the following operations: a) Add a key-value pair to the map; b) Remove a key-value pair from the map; c) Check if a key is in the map; d) Find the value associated with a given key; e) Print all the keys and values in the map;
//Make up the situation for NumberFormatException. Catch it and display the explanation for your custom case.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Розмір першого масиву: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Елементи першого масиву:");
        for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();

        System.out.print("Розмір другого масиву: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Елементи другого масиву:");
        for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();

        ArrayList<Integer> intersection = new ArrayList<>();
        for (int x : arr1)
            for (int y : arr2)
                if (x == y && !intersection.contains(x))
                    intersection.add(x);

        System.out.println("Перетин: " + intersection);

        HashMap<Integer, String> map = new HashMap<>();
        for (int num : intersection) map.put(num, "Значення" + num);

        map.put(99, "Додаткове");
        map.remove(99);
        System.out.println("Ключ 1 " + map.containsKey(1));
        System.out.println("Значення ключа 2: " + map.get(2));
        System.out.println("Всі елементи: " + map);
    }
}
