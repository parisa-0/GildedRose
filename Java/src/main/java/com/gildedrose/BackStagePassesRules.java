package com.gildedrose;

public class BackStagePassesRules implements Rules {
    @Override
    public void apply(Item item) {
        item.sellIn = item.sellIn - 1;
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        if (pastSellByDate(item)) {
            item.quality = 0;
        }
    }


}
