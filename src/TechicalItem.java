public class TechicalItem extends GenericItem{
    short warrantyTime;

    public TechicalItem(int itemId, String itemName, float itemPrice, short wTime) {
        super(itemId, itemName, itemPrice);
        this.warrantyTime = wTime;
    }

    @Override
    void printAll() {
        super.printAll();
        System.out.printf("warranty: %s \n", warrantyTime);
    }

    @Override
    public boolean equals(Object o) {

        if (this.getClass().isInstance(o.getClass())){
            return false;
        }
        TechicalItem obj = (TechicalItem) o;
        return obj.name.equals(this.name) && (obj.ID == this.ID) && (obj.price == this.price)
                && ((obj.category).equals(this.category)) && (obj.warrantyTime == this.warrantyTime);
    }

    @Override
    public Object clone(){
        TechicalItem obj = new TechicalItem(this.ID, this.name, this.price, this.warrantyTime);
        return obj;
    }

    @Override
    public String toString( ){
        return "TechicalItem [ID=" +this.ID + ", Name=" + this.name + ", price=" + this.price + ", category=" + this.category + ", warranty=" + this.warrantyTime + "]";
    }

}
