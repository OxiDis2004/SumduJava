package com.smart;

public class Main {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();

        System.out.println("Veg Meal Menu:");
        vegMeal.showItems();
        System.out.println("Veg Meal costs: " + vegMeal.getCost());
        System.out.println("--------------------------------------------------");
        System.out.println("Non Veg Meal Menu:");
        nonVegMeal.showItems();
        System.out.println("Non Veg Meal costs: " + nonVegMeal.getCost());
    }
}