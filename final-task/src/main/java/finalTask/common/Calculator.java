package finaltask.common;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Calculator {
    private static final String BIGGER = "Первый список имеет большее среднее значение";
    private static final String SMALLER = "Второй список имеет большее среднее значение";
    private static final String EQUAL = "Средние значения равны";
    private final List<? extends Number> listA;
    private final List<? extends Number> listB;

    public Calculator(List<? extends Number> listA, List<? extends Number> listB) throws RuntimeException  {
        if (listA == null || listB == null) throw new RuntimeException("one of the lists is null");
        if (listA.isEmpty()||listB.isEmpty()) throw new RuntimeException("an empty list was received, calculations are impossible");
        this.listA = listA;
        this.listB = listB;
    }

    public String compareList() {
        switch (compare0(listA, listB)) {
            case 1 -> {
                return(BIGGER);
            }
            case -1 -> {
                return(SMALLER);
            }
            default -> {
                return(EQUAL);
            }
        }

    }

    private int compare0(List<? extends Number> listA, List<? extends Number> listB){
        double avrA = avr(listA);
        double avrB = avr(listB);
        if (avrA > avrB) {
            return 1;
        } else if (avrA < avrB) {
            return -1;
        }
        return 0;
    }

    private static double avr(@NotNull List<? extends Number> lst) throws RuntimeException {
        double summ = 0.0;
        for (Number n : lst) {
            summ = summ + n.doubleValue();
        }
        return summ / lst.size();
    }
}
