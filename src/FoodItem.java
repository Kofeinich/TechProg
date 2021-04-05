import java.util.Date;

public class FoodItem extends GenericItem{
    public Date dateOfIncome;

    public short expires;

    public FoodItem(int itemId, String itemName, float itemPrice, Date date, short exp) {
        super(itemId, itemName, itemPrice);
        this.dateOfIncome = date;
        this.expires = exp;
    }

    @Override
    void printAll() {
        super.printAll();
        System.out.printf("date: %tA, exp: %s \n", dateOfIncome, expires);
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass().isInstance(o.getClass())){
            return false;
        }
        FoodItem obj = (FoodItem) o;
        return obj.name.equals(this.name) && (obj.ID == this.ID) && (obj.price == this.price) && ((obj.category).equals(this.category))
                && (obj.expires == this.expires) && (obj.dateOfIncome == this.dateOfIncome);
    }

    @Override
    public Object clone(){
        FoodItem obj = new FoodItem(this.ID, this.name, this.price, this.dateOfIncome, this.expires);
        return obj;
    }

    @Override
    public String toString( ){
        return "FoodItem [ID=" +this.ID + ", Name=" + this.name + ", price=" + this.price + ", category=" + this.category  + ", date=" + this.dateOfIncome + ", expires=" + this.expires + "]";
    }
}
