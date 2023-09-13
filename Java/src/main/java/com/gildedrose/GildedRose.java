package com.gildedrose;

class GildedRose {
    Item[] items;
    private final Rules legendaryRules = new LegendaryRules();

    private final Rules defaultRules = new DefaultRules();

    private final Rules backStagePassesRules = new BackStagePassesRules();

    private final Rules agedBrieRules = new AgedBrieRules();


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            Rules rules = getRules(item);
            rules.apply(item);
        }
    }

    private Rules getRules(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> agedBrieRules;
            case "Backstage passes to a TAFKAL80ETC concert" -> backStagePassesRules;
            case "Sulfuras, Hand of Ragnaros" -> legendaryRules;
            default -> defaultRules;
        };
    }


}
