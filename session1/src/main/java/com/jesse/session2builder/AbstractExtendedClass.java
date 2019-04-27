package com.jesse.session2builder;

import java.util.Objects;

public class AbstractExtendedClass extends AbstractBuilder {
    public enum Size{SMALL, BIG}
    private final Size size;


    //AbstractBuilder.Builder can return the subclass type.
    //so we transfer the Builder to AbstractBuilder.Builder<Builder>
    //and the self function and addTopping function will return AbstractExtendedClass.Builder
    public static class Builder extends AbstractBuilder.Builder<Builder>{

        private final Size size;

        @Override
        AbstractExtendedClass build() {
            return new AbstractExtendedClass(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }
    }


    public AbstractExtendedClass(Builder builder) {
        super(builder);
        this.size =  builder.size;
    }

    public static void main(String[] args) {
        AbstractExtendedClass extendedClass = new AbstractExtendedClass.Builder(Size.SMALL).addTopping(Topping.HAM).build();
    }
}
