package ru.billing.stocklist;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GenericItem {
    protected int ID;
    protected String name;
    protected float price;
    private static int currentID;
    protected Category category = Category.GENERAL;
    private Set<GenericItem> analogs = new HashSet<>();

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public float getPrice() {
        return price;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public Category getCategory() {
        return category;
    }

    public Set<GenericItem> getAnalogs() {
        return analogs;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static void setCurrentID(int currentID) {
        GenericItem.currentID = currentID;
    }

    public void setAnalogs(Set<GenericItem> analogs) {
        this.analogs = analogs;
    }

    public void setCategory(Category newCategory){
        category = newCategory;
    }

    public GenericItem(){
    }

    public GenericItem(String name, float price, Category category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(int itemId, String itemName, float itemPrice){
        this.ID = GenericItem.currentID++;
        this.name = itemName;
        this.price = itemPrice;
    }

    void printAll(){
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f , category: %-20s \n",ID,name,price,category);
    }

    public void addAnalog(GenericItem item){
        analogs.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericItem that = (GenericItem) o;
        return ID == that.ID && Float.compare(that.price, price) == 0 && Objects.equals(name, that.name) && category == that.category && Objects.equals(analogs, that.analogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, price, category, analogs);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GenericItem clone = (GenericItem) super.clone();
        Set<GenericItem> set = new HashSet<>(clone.analogs);
        clone.analogs = set;
        return clone;
    }

    @Override
    public String toString( ){
        return "ru.billing.stocklist.GenericItem [ID=" +this.ID + ", Name=" + this.name + ", price=" + this.price + ", category=" + this.category + "]";
    }
}
