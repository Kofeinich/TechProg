import java.util.Date;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        GenericItem Item1 = new GenericItem(1, "Tomato", 129);
        GenericItem Item2 = new GenericItem(2, "Korn", 69);
        GenericItem Item3 = new GenericItem(3, "Hat", 1678);
        Item1.setCategory(GenericItem.Category.FOOD);
        Item1.printAll();
        Item2.printAll();
        Item3.printAll();
        Date date = new Date(); Date date2 = new Date();
        FoodItem Food = new FoodItem("Humus");
        FoodItem Food2 = new FoodItem("Burger", 8, Food, date, (short) 5 );
        FoodItem Food1 = new FoodItem("Pizza", 654, Food, date, (short) 34);
        TechicalItem Tech1 = new TechicalItem(5, "Branch", 880, (short) 180);
        GenericItem[] mas = {Food1, Tech1};
        for (GenericItem obj : mas) {
            obj.printAll();
        }

        System.out.printf("res1: %b \n", Food1.equals(Food1));
        System.out.printf("res1: %b \n", Item1.equals(Food1));
        System.out.printf("res2: %b \n", Food1.equals(Food2));
        System.out.printf("resOfClone2: %b \n", Food1.equals(Food1.clone()));
        System.out.println(Item2);
        Item1.addAnalog(Item3);
        Item1.addAnalog(Item2);
        Item2.addAnalog(Item3);
    }
}
