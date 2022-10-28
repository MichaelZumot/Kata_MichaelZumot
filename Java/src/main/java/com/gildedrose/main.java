package com.gildedrose;

import javax.naming.OperationNotSupportedException;

public class main {


    public static void main(String args[]) throws OperationNotSupportedException {
        System.out.println("hello from main");

        Item[] items = new Item[2];
        Item item1 = new Item("Choclat", 12, 10);
        Item item2 = new Item("Aged Brie", 9, 2);
        items[0] = item1;
        items[1] = item2;
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
        }

    }
}
