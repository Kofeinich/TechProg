package ru.sync;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import ru.exception.CatalogLoadException;
import ru.exception.ItemAlreadyExistsException;
import ru.billing.client.CatalogLoader;
import ru.billing.client.CatalogFileLoader;
import ru.billing.client.CatalogStubLoader;

public class U901Main {
    public static void main(String[] args) throws InterruptedException, CatalogLoadException, ItemAlreadyExistsException{
        var bankMain = new U901Bank();
        var threadOne = new U901Thread(bankMain, 100, 2000);
        threadOne.setName("First");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        threadOne.start();
        System.out.println(bankMain.intTo + " " + bankMain.intFrom);

        var threadTwo = new U901Thread(bankMain, 50, 300);
        threadTwo.setName("Second");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();
        System.out.println(bankMain.intTo + " " + bankMain.intFrom);

        System.out.println(Thread.currentThread().getName());
        var cat = new ItemCatalog();
        var first = new GenericItem();
        var second = new GenericItem();
        cat.addItem(first);
        cat.addItem(second);


        var loader = new CatalogStubLoader();
        try {
            loader.load(cat);
        }
        catch (CatalogLoadException | ItemAlreadyExistsException e){
            e.printStackTrace();
        }
        cat.printItems();

/*
        var loader2 = new CatalogFileLoader("items.lst");
        loader2.load(cat);
        cat.printItems();

 */
    }
}
