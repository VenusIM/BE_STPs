package oop.customerExampleTest;

import java.util.Objects;

public class Cook {
    private final String name;
    private final int price;

    public Cook(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Cook(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
    }


    // 객체를 비교할 경우 equals를 overriding
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook cook = (Cook) o;
        return price == cook.price && Objects.equals(name, cook.name);
    }

    // equals를 overriding 할때에는 hashcode 또한 overriding 해주어야한다.
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
