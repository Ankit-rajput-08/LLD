package designPattern.factory.abstracts;

interface MealFactory {
    Burger createBurger(String type);
    GarlicBread createGarlicBread(String type);
}