package common;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int compare(List<? extends Number> listA,List<? extends Number> listB) throws RuntimeException{
        if (listA==null||listB==null) throw new RuntimeException()
        double avrA = avr(listA);
        double avrB = avr(listB);
        if (avrA>avrB){
            return 1;
        } else if (avrA<avrB) {
            return -1;
        }
        return 0;
    }

    private double avr(List<? extends Number> lst){
        if (lst.isEmpty()) throw new RuntimeException("получен пустой список, вычисления невозможны");
        return lst.stream().mapToDouble(number -> (double) number).sum()/ lst.size();
    }


}
