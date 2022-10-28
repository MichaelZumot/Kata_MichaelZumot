package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {

    @BeforeEach
    void setUp() {
        GildedRose.items = null;
    }

    @Test
    void testCorrectListItem() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("foo", 0, 0)};
        GildedRose.updateQuality();
        assertEquals("foo", GildedRose.items[0].name);
    }

    @Test
    void testItemWithNullName() {
        GildedRose.items = new Item[]{new Item(null, 10, 40)};
        Arrays.stream(GildedRose.items)
            .map(i -> i.name)
            .forEach(Assertions::assertNull);
    }

    @Test
    void testItemWithZeroSellIn() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("product", 0, 40)};
        GildedRose.updateQuality();
        assertEquals(-1, GildedRose.items[0].sellIn);
    }

    @Test
    void testItemWithZeroQuality() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("product", 10, 0)};
        GildedRose.updateQuality();
        assertEquals(0, GildedRose.items[0].quality);
    }

    @Test
    void testItemWithNegativeQuality() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("product", 10, -1)};
        GildedRose.updateQuality();
        assertEquals(0, GildedRose.items[0].quality);
    }

    @Test
    void testItemWithQualityHigherThanFifty() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("product", 10, 100)};
        GildedRose.updateQuality();
        assertEquals(50, GildedRose.items[0].quality);
    }

    @Test
    void testItemSellInWithNegativeSellIn() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("product", 10, 52)};
        GildedRose.updateQuality();
        assertEquals(9, GildedRose.items[0].sellIn);
    }

    @Test
    void testItemSellInWhenSellInIsNegative() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("product", -2, 52)};
        GildedRose.updateQuality();
        assertEquals(-3, GildedRose.items[0].sellIn);
    }

    @Test
    void testMaxQualityOfSulfuras() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
        GildedRose.updateQuality();
        assertEquals(80, GildedRose.items[0].quality);
    }

    @Test
    void testConjuredProductQuality() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("Conjured Mana Cake", 10, 8)};
        GildedRose.updateQuality();
        assertEquals(6, GildedRose.items[0].quality);
    }

    @Test
    void testConjuredProductWhenQualityIsZero() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("Conjured Mana Cake", 10, 0)};
        GildedRose.updateQuality();
        assertEquals(0, GildedRose.items[0].quality);
    }

    @Test
    void testConjuredProductWhenQualityIsNegative() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("Conjured Mana Cake", 10, -2)};
        GildedRose.updateQuality();
        assertEquals(0, GildedRose.items[0].quality);
    }

    @Test
    void testQualityOfConjuredProductWhenQualityIsNegative() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("Conjured Mana Cake", 10, -2)};
        GildedRose.updateQuality();
        assertEquals(0, GildedRose.items[0].quality);
    }

    @Test
    void testQualityOfBackstageProduct() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 20, 30)};
        GildedRose.updateQuality();
        assertEquals(31, GildedRose.items[0].quality);
    }

    @Test
    void testQualityOfBackstageProductLessThanTenDays() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 30)};
        GildedRose.updateQuality();
        assertEquals(32, GildedRose.items[0].quality);
    }

    @Test
    void testQualityOfBackstageProductLessThanFiveDays() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 30)};
        GildedRose.updateQuality();
        assertEquals(33, GildedRose.items[0].quality);
    }
    @Test
    void testQualityOfBrieProduct() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("Aged Brie", 20, 30)};
        GildedRose.updateQuality();
        assertEquals(31, GildedRose.items[0].quality);
    }

    @Test
    void testQualityOfBrieWhenQualityIsZero() throws OperationNotSupportedException {
        GildedRose.items = new Item[]{new Item("Aged Brie", 20, 0)};
        GildedRose.updateQuality();
        assertEquals(1, GildedRose.items[0].quality);
    }

}

