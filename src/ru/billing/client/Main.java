package ru.billing.client;

import ru.billing.stocklist.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        GenericItem Item1 = new GenericItem(1, "Tomato", 129);
        GenericItem Item2 = new GenericItem(2, "Korn", 69);
        GenericItem Item3 = new GenericItem(3, "Hat", 1678);
        Item1.setCategory(Category.FOOD);
        Date date = new Date(); Date date2 = new Date();
        FoodItem Food = new FoodItem("Humus");
        FoodItem Food2 = new FoodItem("Burger", 8, Food, date, (short) 5 );
        FoodItem Food1 = new FoodItem("Pizza", 654, Food, date, (short) 34);
        TechicalItem Tech1 = new TechicalItem(5, "Branch", 880, (short) 180);

        ItemCatalog Catalog = new ItemCatalog();
        Catalog.addedObject(Item1, Food1, Tech1);
        Catalog.runtimeCheck();
        Catalog.cleanUpMyCatalog();
        CatalogLoader loader = new CatalogStubLoader();
        loader.load(Catalog);
        Catalog.printItems();
    }
}
