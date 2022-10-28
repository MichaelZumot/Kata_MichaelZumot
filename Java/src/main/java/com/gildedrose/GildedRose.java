package com.gildedrose;

import javax.naming.OperationNotSupportedException;

import static java.util.Objects.nonNull;

class GildedRose {
    static Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static void updateQuality() throws OperationNotSupportedException {

        if (nonNull(items) && items.length == 0) {
            throw new OperationNotSupportedException();
        }

        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {

                case "Sulfuras, Hand of Ragnaros":
                    break;

                case "Aged Brie":
                    items[i].quality++;
                    break;

                case "Conjured Mana Cake":
                    items[i].quality -= 2;
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstageConcert(i);
                    break;

                default:
                    items[i].quality--;
                    break;
            }
            items[i].sellIn--;
        }

        for (Item item : items) {
            if (item.quality > 50 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality = 50;
            }
            if (item.quality < 0) {
                item.quality = 0;
            }
        }

    }

    private static void updateBackstageConcert(int i) {
        if (items[i].sellIn <= 5) {
            items[i].quality += 3;
        } else if (items[i].sellIn > 5 && items[i].sellIn <= 10) {
            items[i].quality += 2;
        } else {
            items[i].quality++;
        }
    }


//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
}

