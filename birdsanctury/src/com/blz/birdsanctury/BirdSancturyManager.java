package com.blz.birdsanctury;

import java.util.*;

public class BirdSancturyManager {
    Scanner scanner = new Scanner(System.in);

    private static BirdSancturyManager instance;

    private BirdSancturyManager() {

    }

    Set<Bird> birdList = new HashSet();

    public synchronized static BirdSancturyManager getInstance() {
        if (instance == null) {
            instance = new BirdSancturyManager();
            return instance;
        }
        return instance;
    }

    public void addDummyBird() {     // Needs to be deleted in production
        Bird bird1 = new Bird();
        bird1.name = "penguin";
        bird1.bid = "pen001";
        bird1.colour = "black";
        bird1.isSwimmable = true;
        bird1.isFlyable = false;
        birdList.add(bird1);

        Bird bird2 = new Bird();
        bird2.name = "crow";
        bird2.bid = "cro001";
        bird2.colour = "black";
        bird2.isSwimmable = true;
        bird2.isFlyable = true;
        birdList.add(bird2);

        Bird bird3 = new Bird();
        bird3.name = "chimni";
        bird3.bid = "chi001";
        bird3.colour = "black";
        bird3.isSwimmable = true;
        bird3.isFlyable = true;
        birdList.add(bird3);

        Bird bird4 = new Bird();
        bird4.name = "mor";
        bird4.bid = "mor001";
        bird4.colour = "black";
        bird4.isSwimmable = false;
        bird4.isFlyable = false;
        birdList.add(bird4);
    }


    public void add(Bird bird) {
        System.out.println("Enter Name of Bird : ");
        bird.name = scanner.next();
        System.out.println("Enter Bird id : ");
        bird.bid = scanner.next();
        System.out.println("Enter Colour of Bird : ");
        bird.colour = scanner.next();
        flyable(bird);
        swimmable(bird);
        birdList.add(bird);
    }

    public void flyable(Bird bird) {
        while (true) {
            try {
                System.out.println("Bird is Flyable Enter true or false : ");
                bird.isFlyable = inputFlyUser();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
    }

    public boolean inputFlyUser() {
        Scanner sc = new Scanner(System.in);
        return sc.nextBoolean();
    }

    public void swimmable(Bird bird) {
        while (true) {
            try {
                System.out.println("Bird is Swimmable Enter true or false : ");
                bird.isSwimmable = inputSwimUser();break;
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
    }

    public boolean inputSwimUser() {
        Scanner sc = new Scanner(System.in);
        return sc.nextBoolean();
    }


    public void remove(Bird bird) {
        if (bird != null) {
            birdList.remove(bird);
        } else {
            System.out.println("id not matched with any data available");
        }
    }

    public Bird getBird(String id) {
//        for (Bird bird : birdList) {
//            if (bird.bid.equals(id)) {
//                return bird;
//            } else {
//                System.out.println("Enter proper bird id");
//            }
//        }

        return birdList.stream().filter(i -> i.bid.equals(id)).findFirst().orElse(null);

    }

    public void printFlyable() {
//        for (Bird bird : birdList) {
//            if (bird.isFlyable) {
//                bird.fly(bird);
//            }
//            birdList.stream().filter(i -> i.isFlyable).forEach(i -> System.out.println(i));
        birdList.stream().filter(i -> i.isFlyable).forEach(bird -> bird.fly());
//        }
    }

    public void printSwimmable() {
//        for (Bird bird : birdList) {
//            if (bird.isSwimmable) {
//                bird.swim(bird);
//            }
//        }
//        birdList.stream().filter(i -> i.isSwimmable).forEach(i -> System.out.println(i));
        birdList.stream().filter(i -> i.isFlyable).forEach(bird -> bird.swim());
    }

    public void print() {
        if (!birdList.isEmpty()) {
            birdList.stream().forEach(i -> System.out.println(i));
        } else {
            System.out.println("Nothing to print add bird first !!!");
        }
//        for (Bird bird : birdList) {
//            System.out.println(bird);
//        }
    }

    public void Search() {
        System.out.println("Enter bird id to Edit details : ");
        String userBid = scanner.next();
        for (Bird bird : birdList) {
            if (bird.bid.equals(userBid)) {
                edit(bird);
                break;
            }
        }
        System.out.println("Bird id not found in System ...");
    }

    public void edit(Bird bird) {
        System.out.println("1.name\n2.bird id\n3.colour of bird\n4.isFlyable\n5.isSwimmable");
        System.out.println("What Details you want to change :");
        int userInp = scanner.nextInt();
        switch (userInp) {
            case 1:
                System.out.println("Enter Name of Bird : ");
                bird.name = scanner.next();
                break;
            case 2:
                System.out.println("Enter Bird id : ");
                bird.bid = scanner.next();
                break;
            case 3:
                System.out.println("Enter Colour of Bird : ");
                bird.colour = scanner.next();
                break;
            case 4:
                flyable(bird);
                break;
            case 5:
                swimmable(bird);
                break;
        }
    }

    public void map() {
//        List<String> mappedList;
//        mappedList = birdList.stream().map(i -> i.name).collect(Collectors.toList());
//        mappedList.forEach(i-> System.out.println(i));
        birdList.stream().map(i -> i.name).forEach(i -> System.out.print(i + " |"));
        long numberOfBirds = birdList.stream().count();
        System.out.println(numberOfBirds);
    }
}

