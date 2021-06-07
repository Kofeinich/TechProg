package ru.billing.client;

import ru.billing.stocklist.*;

public class Main {
    public static void main(String[] args) {
        var catalog = new ItemCatalog();
        var item = new GenericItem();
        CatalogLoader loader = new CatalogStubLoader();
        loader.load(catalog);
        catalog.printItems();
    }
}
