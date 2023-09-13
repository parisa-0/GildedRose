package com.gildedrose;

public class DefaultRules implements Rules {
    @Override
    public void apply(Item item) {
        item.sellIn = item.sellIn - 1;
        decreaseQuality(item);
        if (pastSellByDate(item)) {
            decreaseQuality(item);
        }
    }
}
