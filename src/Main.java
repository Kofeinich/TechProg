import java.util.Date;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        GenericItem Item1 = new GenericItem(1, "Tomato", 129);
        GenericItem Item2 = new GenericItem(2, "Korn", 69);
        GenericItem Item3 = new GenericItem(3, "Hat", 1678);
        Item1.setCategory(GenericItem.Category.FOOD);
        Date date = new Date();
        Date date2 = new Date();
        FoodItem Food = new FoodItem("Humus");
        FoodItem Food2 = new FoodItem("Burger", 8, Food, date, (short) 5);
        FoodItem Food1 = new FoodItem("Pizza", 654, Food, date, (short) 34);
        TechicalItem Tech1 = new TechicalItem(5, "Branch", 880, (short) 180);

        Integer intArr[] = {10, 20, 15};
        Float[] floatArr = new Float[10];
        IntStream.range(0, floatArr.length).forEachOrdered(i -> {
            floatArr[i] = ((float) (Math.random() * 100) - 10);
            System.out.println(floatArr[i]);
        });

        var insWorkArrayInt = new U0901WorkArray(intArr);
        var insWorkArrayFloat = new U0901WorkArray(floatArr);
        System.out.printf("Int sum is: %s \n", insWorkArrayInt.sum());
        System.out.printf("Double sum is: %s \n", insWorkArrayFloat.sum());

        String line = "Конфеты ’Маска’;45;120";
        Splitter Split = new Splitter(line);
        try {
            var FoodTest = new FoodItem();
            FoodTest.buildItem(Split.parse());
            FoodTest.printAll();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
