package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GildedRoseTest {
     //use beforeeach
     //    Item item = new Item("Item",0,0);
     //    GildedRose app = new GildedRose(new Item[] {item});

   @Test void sellByDatePassedQualityDegradesTwiceAsFast() {
       //Once the sell by date has passed, Quality degrades twice as fast
       Item random = new Item("Random",5,20);
       random.sellIn = -1;
       int expected = random.quality - 2;
       GildedRose uq = new GildedRose(new Item[] {random});
       uq.updateQuality();
       assertEquals(expected,random.quality);
    }

    @Test void qualityBetweenZeroAndFifty() {
       //The Quality of an item is never negative
        // The Quality of an item is never more than 50
        //Just for clarification, an item can never have its Quality increase above 50
        Item random = new Item("Random",5,49);
        GildedRose uq = new GildedRose(new Item[] {random});
        assertFalse(random.quality < 0 || random.quality > 50);
    }

    @Test void agedBrieIncreaseQuality() {
       //"Aged Brie" actually increases in Quality the older it gets
        Item agedBrie = new Item("Aged Brie",5,10);
        agedBrie.sellIn = -5;
        GildedRose uq = new GildedRose(new Item[] {agedBrie});
        uq.updateQuality();
        assertTrue(agedBrie.quality > 10);
    }

    @Test void legendaryItemQuality() {
       //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
       //however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros",5,80);
        GildedRose uq = new GildedRose(new Item[] {sulfuras});
        int expected = 80;
        uq.updateQuality();
        assertEquals(expected,sulfuras.quality);
    }

    @Test void backstagePassesQualityEqualToZeroIfPastSellByDate() {
        // but Quality drops to 0 after the concert
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert",6,15);
        GildedRose uq = new GildedRose(new Item[] {backstagePasses});
        backstagePasses.sellIn = -2;
        int expected = 0;
        uq.updateQuality();
        assertEquals(expected,backstagePasses.quality);
    }

    @Test void backstagePassesIncreaseQualityAsSellInValueApproaches() {
        //"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert",6,15);
        GildedRose uq = new GildedRose(new Item[] {backstagePasses});
        backstagePasses.sellIn = 2;
        uq.updateQuality();
        assertTrue(backstagePasses.quality > 15);
    }

    @Test void backstagePassesIncreaseQualityByDays() {
        // Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert",12,15);
        GildedRose uq = new GildedRose(new Item[] {backstagePasses});
        for(int i = 1; i < 11; i++) {
            if(i <= 10 && i > 5) {
                backstagePasses.sellIn = i;
                int expected = backstagePasses.quality + 2;
                uq.updateQuality();
                assertEquals(expected, backstagePasses.quality);
            }
           else if(i < 5) {
                backstagePasses.sellIn = i;
                int expected = backstagePasses.quality + 3;
                uq.updateQuality();
                assertEquals(expected, backstagePasses.quality);
            }
        }
    }
}
