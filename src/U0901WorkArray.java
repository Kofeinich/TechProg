import java.util.Arrays;

public final class U0901WorkArray <T extends Number> {

    private T[] arrNums;

    public T[] getArrNums() {
        return arrNums;
    }

    public U0901WorkArray(T[] numP){
        this.arrNums = numP;
    }

    /*
    public double sum(){
        return Arrays.stream(arrNums).mapToDouble(arrNum -> Double.valueOf(arrNum)).sum();
    }
    */
    public double sum(){
        double doubleWork = 0;
        for (T arrNum : getArrNums()) {
            String arNum = arrNum.toString();
            doubleWork = doubleWork + Double.valueOf(arNum);
        }
        return doubleWork;
    }
}

