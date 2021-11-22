package hierarchy;

import hierarchy.animals.*;
import hierarchy.food.Food;
import hierarchy.food.Meat;
import hierarchy.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String type;
    public static String name;
    public static double weight;
    public static String livingRegion;
    public static String breed;
    public static String foodType;
    public static int quantity;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String animalInput = sc.nextLine();

        while (!animalInput.equals("End")) {

            extractAnimalInfo(animalInput);

            Animal animal = createAnimal();
            animal.makeSound();

            extractFoodInfo(sc);

            Food food = typeOfFood(quantity);

            try {
                animal.eat(food);

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            animalInput = sc.nextLine();
        }

        animals.forEach(System.out::println);
    }

    private static void extractFoodInfo(Scanner sc) {

        String[] splitFoodInput = sc.nextLine().split("\\s+");
        foodType = splitFoodInput[0];
        quantity = Integer.parseInt(splitFoodInput[1]);

    }

    private static Food typeOfFood(int quantity) {
        switch (foodType) {
            case "Vegetable":
                return new Vegetable(quantity);

            case "Meat":
                return new Meat(quantity);
            default:
                throw new IllegalArgumentException("No such food.");
        }

    }

    private static Animal createAnimal() {
        switch (type) {
            case "Mouse":
                return new Mouse(name, type, weight, livingRegion);
            case "Zebra":
                return new Zebra(name, type, weight, livingRegion);
            case "Cat":
                return new Cat(name, type, weight, livingRegion, breed);
            case "Tiger":
                return new Tiger(name, type, weight, livingRegion);
            default:
                throw new IllegalArgumentException("No such animal.");
        }

    }

    private static void extractAnimalInfo(String input) {

        String[] splitAnimalInfo = input.split("\\s+");
        type = splitAnimalInfo[0];
        name = splitAnimalInfo[1];
        weight = Double.parseDouble(splitAnimalInfo[2]);
        livingRegion = splitAnimalInfo[3];

        if (type.equals("Cat")) {
            breed = splitAnimalInfo[4];
        }

    }
}
