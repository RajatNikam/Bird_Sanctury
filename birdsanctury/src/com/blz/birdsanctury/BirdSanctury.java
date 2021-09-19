package com.blz.birdsanctury;

import java.util.Scanner;

public class BirdSanctury {
    Scanner scanner = new Scanner(System.in);
    public static BirdSanctury birdSanctury = new BirdSanctury();

    public static void main(String[] args) {
        birdSanctury.Display();
        birdSanctury.showOptions();
    }

    public void Display() {
        System.out.println("1.add bird\n2.remove bird\n3.update bird details" +
                "\n4.print all birds\n5.print Flyable birds\n" +
                "6.print Swimable birds\n7.display options again\n8.Exit\n9.Map");
    }

    public void showOptions() {
        BirdSancturyManager birdSancturyManager = BirdSancturyManager.getInstance();
        boolean isLoop = true;
        while (isLoop) {
            System.out.print("\nEnter your option here (1-8) : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
//                    birdSancturyManager.addDummyBird();
                    Bird bird = new Bird();
                    birdSancturyManager.add(bird);
                    break;

                case 2:
                    System.out.println("Enter id of bird : ");
                    String id = scanner.next();
                    birdSancturyManager.remove(birdSancturyManager.getBird(id));
                    birdSancturyManager.print();
                    break;

                case 3:
                    birdSancturyManager.Search();break;


                case 4:
                    birdSancturyManager.print();
                    break;

                case 5:
                    birdSancturyManager.printFlyable();break;

                case 6:
                    birdSancturyManager.printSwimmable();break;

                case 7:
                    birdSanctury.Display();break;

                case 8:
                    System.out.println("Thank You for Your Time...");
                    isLoop = false;break;
                case 9:
                    birdSancturyManager.map();break;

                default:
                    System.out.println("plz Enter from given options ...\n");
                    break;
            }
        }
    }

    public void recurring() {
        System.out.println("Do you want to perform more operations (y/n) : ");
        if (Character.toLowerCase(scanner.next().charAt(0)) == 'y') {

        }
    }

}