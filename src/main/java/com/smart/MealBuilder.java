package com.smart;

import com.smart.items.drink.Coke;
import com.smart.items.drink.Pepsi;
import com.smart.items.food.ChickenBurger;
import com.smart.items.food.VegBurger;

public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
