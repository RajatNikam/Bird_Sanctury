package com.blz.birdsanctury;

import java.util.Objects;

public class Bird {

    protected String name;
    protected String bid;
    protected String colour;
    protected boolean isFlyable;
    protected boolean isSwimmable;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return bid.equals(bird.bid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bid);
    }

    public void fly(){
        System.out.println(name + " is flying");
    }
    public void swim(){
        System.out.println(name + " is swimming");
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", bid='" + bid + '\'' +
                ", colour=" + colour +
                ", isFlyable=" + isFlyable +
                ", isSwimmable=" + isSwimmable +
                '}';
    }
}