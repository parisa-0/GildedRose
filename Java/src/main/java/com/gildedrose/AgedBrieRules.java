package com.gildedrose;

public class AgedBrieRules implements Rules {
    @Override
    public void apply(Item item) {
        item.sellIn = item.sellIn - 1;
        increaseQuality(item);
        if (pastSellByDate(item)) {
            increaseQuality(item);
        }
    }
}
