package com.cognizant;

import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.util.*;

public class Cart {
    private List<LineItem> lineItemList=new ArrayList<>();
    public double totalPrice=0.0;

    public List<LineItem> getItems() {
        return Collections.unmodifiableList(lineItemList);
    }


    public void addItem(Item item, int quantity) {
        lineItemList.add(new LineItem(item,quantity));
    }

    public double getTotalPrice() {
    for(int i=0;i<lineItemList.size();i++)
    {
     totalPrice+=lineItemList.get(i).getItem().getPrice() * lineItemList.get(i).getQuantity();
    }
    return totalPrice;
    }


    public List<String> itemQuantities() {
        List<String> itemNameList= new ArrayList<String>();
        for(int i=0;i<lineItemList.size();i++)
        {
            itemNameList.add("'" + lineItemList.get(i).getItem().getName() + " - x" + lineItemList.get(i).getQuantity() + "'");
        }
        return itemNameList;
    }

    public List<String> itemizedList() {
        List<String> itemPriceQuantity=new ArrayList<>();
        for(int i=0;i<lineItemList.size();i++)
        {
            itemPriceQuantity.add("'" + lineItemList.get(i).getItem().getName() + " x" + lineItemList.get(i).getQuantity() + " - " + "$" + lineItemList.get(i).getItem().getPrice() + "'");
        }
        return itemPriceQuantity;
    }

    public List<String> onSaleItems() {
        List<String> onSaleItemsList = new ArrayList<String>();
        for (int i = 0; i < lineItemList.size(); i++) {
            if (lineItemList.get(i).getItem().getOnSale()) {
                onSaleItemsList.add("'" + lineItemList.get(i).getItem().getName() + " x" + lineItemList.get(i).getQuantity() + " - " + "$" + lineItemList.get(i).getItem().getPrice() + "'");
            }
        }
        return onSaleItemsList;
    }
}

