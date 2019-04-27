package com.jesse.session2builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractBuilder {
    public enum Topping{HAM, MUSHROOM}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract AbstractBuilder build();

        //subclass must override this method and return this.
        protected abstract T self();
    }

    AbstractBuilder(Builder<?> builder){
        toppings = builder.toppings.clone();
    }

}
