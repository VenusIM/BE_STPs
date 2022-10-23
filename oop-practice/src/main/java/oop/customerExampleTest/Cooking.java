package oop.customerExampleTest;

public class Cooking {
    public Cook makeCook(MenuItem menuItem) {
        return new Cook(menuItem);
    }
}
