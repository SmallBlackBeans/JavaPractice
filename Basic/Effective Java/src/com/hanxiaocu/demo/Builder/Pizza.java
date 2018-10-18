package com.hanxiaocu.demo.Builder;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/18 2:57 PM
 */
public class Pizza implements Serializable {


    public enum Topping {
        HAM,//火腿
        MUSHROOM,//蘑菇
        ONION,//洋葱
        PEPPER,//胡椒
        SAUSAGE香肠
    }


    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> { //递归
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            //类似于模板模式
            return self();
        }

        abstract Pizza build();

        //子类重写
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        this.toppings = builder.toppings.clone();
    }

    static class MyPizza extends Pizza {
        private final boolean hasSauce; //酱汁

        private static class Builder extends Pizza.Builder<Builder> {

            private boolean hasSauce = false;

            public Builder hasSauce() {
                hasSauce = true;
                return this;
            }



            @Override
            protected Builder self() {
                return this;
            }

            @Override
            MyPizza build() {
                return new MyPizza(this);
            }
        }

        private MyPizza(Builder builder) {
            super(builder);
            hasSauce = builder.hasSauce;
        }

    }

    public static void main(String[] args) {
        MyPizza pizza = new MyPizza.Builder().addTopping(Topping.HAM).addTopping(Topping.ONION).build();
    }
}



