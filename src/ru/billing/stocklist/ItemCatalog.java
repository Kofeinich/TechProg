package ru.billing.stocklist;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.IntStream;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog =
                new HashMap<Integer,GenericItem>();
        private ArrayList<GenericItem> ALCatalog =
                new ArrayList<GenericItem>();

        public void addItem(GenericItem item) {
            catalog.put(item.ID, item);
            ALCatalog.add(item);
        }

        public void printItems(){
            for(GenericItem i : ALCatalog){
                System.out.println(i.toString());
            }
        }

        public GenericItem findItemByID(int id){
            return catalog.getOrDefault(id, null);
        }

        public GenericItem findItemByIDAL(int id){
            for(GenericItem i : ALCatalog){
                if(i.ID==id) return i;
            }
            return null;
        }

        public void runtimeCheck(){
            long begin = new Date().getTime();
            IntStream.range(0, 100000).map(i -> 6).forEach(this::findItemByID);
            long end = new Date().getTime();
            System.out.println("In HashMap: "+(end-begin)); begin = new Date().getTime();
            IntStream.range(0, 100000).map(i -> 6).forEach(this::findItemByIDAL);
            end = new Date().getTime();
            System.out.println("In ArrayList: "+(end-begin));

        }

        public void addedObject(GenericItem item, FoodItem foodItem, TechicalItem techicalItem){
            IntStream.range(0, 50).forEach(i -> {
                this.addItem(item);
                this.addItem(foodItem);
                this.addItem(techicalItem);
            });
        }

        public void cleanUpMyCatalog(){
            catalog.clear();
            ALCatalog.clear();
        }
}

