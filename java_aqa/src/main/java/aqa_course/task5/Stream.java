package aqa_course.task5;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        int count = args.length > 0 ? Integer.parseInt(args[0]) : 10;
        Random random = new Random();

        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User u = new User();
            u.setId(random.nextInt(1000));
            u.setName("User" + (char) (65 + random.nextInt(26)));
            u.setHobbies(new ArrayList<>(List.of("reading", "gaming", "coding", "hiking")));
            users.add(u);
        }

        System.out.println("=== Original users ===");
        users.forEach(System.out::println);

        List<User> sorted = users.stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getId))
                .toList();

        System.out.println("\n=== Sorted users ===");
        sorted.forEach(System.out::println);

        List<User> filtered = users.stream()
                .filter(u -> u.getId() > 500)
                .filter(u -> u.getHobbies().contains("coding"))
                .toList();

        System.out.println("\n=== Filtered users (id > 500 & has coding) ===");
        filtered.forEach(System.out::println);

        List<String> names = users.stream()
                .map(User::getName)
                .toList();

        System.out.println("\n=== Collected names ===");
        names.forEach(System.out::println);
    }
}