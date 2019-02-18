package com.cognizant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest {

    private Cart cart;

    @Before
    public void setUp(){
        cart=new Cart();
    }

    @Test
    public void cartShouldBeEmptyTest()
    {
        //SetUp
        int expected=0;

        //Excercise
        int actual=cart.getItems().size();
        System.out.println("Default value of actual item is " + actual);

        //Assert
        assertEquals("When I begin my Shopping Cart should be Empty", expected, actual);

    }

    @Test
    public void addItemShouldReturnTotalPriceTest(){

        //SetUP
       Item item=new Item("Handbag" , 100.00, false);
       Item item1=new Item("Earings", 50.00, true);

       cart.addItem(item,1);
       cart.addItem(item1,1);

       double expected=150.00;

      // Exercise
        double actual=cart.getTotalPrice();
        assertTrue(expected == actual);
    }

    @Test
    public void addingMoreItemsShouldShowNoOfQuantitiesTest()
    {
        //SetUP
        Item item=new Item("Soup", 5.00, false);
        Item item1=new Item("Biscuits", 3.00, false);

        cart.addItem(item, 2);
        cart.addItem(item1, 2);

        List<String> expected= Arrays.asList("'Soup - x2'", "'Biscuits - x2'");

        //Excercise
        List<String> actual=cart.itemQuantities();

        //Assert
        assertEquals("Adding more quantities should show name of the quantities with Name", expected, actual);

    }

    @Test
    public void addItemShouldReturnItemizedListTest()
    {
        //SetUP
        Item item1=new Item("Soup", 5.00, false);
        Item item2=new Item("Biscuit", 4.00, true);

        cart.addItem(item1,1);
        cart.addItem(item2,1);

        List<String> expected=Arrays.asList("'Soup x1 - $5.0'", "'Biscuit x1 - $4.0'");

        //Excercise
        List<String> actual=cart.itemizedList();

        //Assert
        assertEquals(expected , actual);
    }

    @Test
    public void addItemShouldReturnOnSaleItemsTest()
    {
        //SetUP
        Item item1=new Item("Soup", 5.00, true);
        Item item2=new Item("Biscuit", 4.00, false);
        Item item3=new Item("Waffles", 2.00, true);

        cart.addItem(item1,1);
        cart.addItem(item2,1);
        cart.addItem(item3,1);

        List<String> expected=Arrays.asList("'Soup x1 - $5.0'", "'Waffles x1 - $2.0'");

        //Excercise
        List<String> actual=cart.onSaleItems();

        //Assert
        assertEquals(expected, actual);
    }


}
