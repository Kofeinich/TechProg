import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class GenericItem {
    public int ID;
    public String name;
    public float price;
    Category category = Category.GENERAL;

    public enum Category{FOOD, PRINT, DRESS, GENERAL}

    public Set<GenericItem> analogs = new HashSet<>();

    public void setCategory(Category newCategory){
        category = newCategory;
    }

    public GenericItem(int itemId, String itemName, float itemPrice){
        this.ID = itemId;
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
        //String.format("GenericItem [ID=%1", this.ID);
        return "GenericItem [ID=" +this.ID + ", Name=" + this.name + ", price=" + this.price + ", category=" + this.category + "]";
    }
}
