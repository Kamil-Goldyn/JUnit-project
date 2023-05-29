package org.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;
    @BeforeEach
    void initializeOrder() {
        order = new Order();
    }

    @AfterEach
    void cleanUp() {
        order.cancel();
    }

    @Test
    void testAssertArrayEquals() {
        //given
        int[] ints1 = {1,2,3};
        int[] ints2 = {1,2,3};
        //then
        assertArrayEquals(ints1,ints2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder() {
        //then
        assertThat(order.getMeals(), empty());
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {
        //given
        Meal meal = new Meal(10);
        //when
        order.addMealToOrder(meal);
        //then
        assertThat(order.getMeals(),not(empty()));
    }

    @Test

    void removingMealFromOrderShouldDecreaseOrderSize() {
        //given
        Meal meal = new Meal(10);
        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);
        //then
        assertThat(order.getMeals(),empty());
    }

    @Test

    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder() {
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(15);
        Meal meal3 = new Meal(17);
        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        order.addMealToOrder(meal3);
        //then
        assertThat(order.getMeals(), contains(meal1,meal2,meal3));
    }

    @Test

    void testIfTwoMealListsAreTheSame() {
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(15);
        Meal meal3 = new Meal(17);

        List<Meal> meals1 = Arrays.asList(meal1, meal2);
        List<Meal> meals2 = Arrays.asList(meal1, meal2);
        //then
        assertThat(meals1,is(meals2));
    }
}