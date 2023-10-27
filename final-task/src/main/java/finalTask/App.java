package finaltask;

import finaltask.common.Calculator;

import java.util.Arrays;
import java.util.List;


public class App {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> integerList1 = Arrays.asList(0, 3, 3, 4, 5, 6);
        List<Float> floatList = Arrays.asList(12.3f, -4.1f, 0.0f, 7.0f, 2.3f, -8.7f);
        delim();
        printList(integerList);
        printList(floatList);
        System.out.println(new Calculator(integerList, floatList).compareList());
        delim();
        printList(floatList);
        printList(integerList);
        System.out.println(new Calculator(floatList, integerList).compareList());
        delim();
        printList(integerList);
        printList(integerList1);
        System.out.println(new Calculator(integerList, integerList1).compareList());
        delim();

    }

    private static void delim() {
        System.out.println("---------------------------------------");
    }


    static void printList(List<? extends Number> list){
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            if(i<list.size()-1) System.out.print(list.get(i)+", ");
        }
        System.out.println("}");
    }
}
