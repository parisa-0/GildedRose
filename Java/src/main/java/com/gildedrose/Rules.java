package com.gildedrose;

interface Rules {
    default void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    default boolean pastSellByDate(Item item) {
        return item.sellIn < 0;
    }

    default void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public void apply(Item item);
}
