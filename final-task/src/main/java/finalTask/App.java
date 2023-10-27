package finalTask;

import finalTask.common.Calculator;

import java.util.Arrays;
import java.util.List;


public class App {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> integerList1 = Arrays.asList(0, 3, 3, 4, 5, 6);
        List<Float> floatList = Arrays.asList(12.3f, -4.1f, 0.0f, 7.0f, 2.3f, -8.7f);
        System.out.println("---------------------------------------");
        printList(integerList);
        printList(floatList);
        new Calculator(integerList,floatList).compareList();
        System.out.println("---------------------------------------");
        printList(floatList);
        printList(integerList);
        new Calculator(floatList,integerList).compareList();
        System.out.println("---------------------------------------");
        printList(integerList);
        printList(integerList1);
        new Calculator(integerList,integerList1).compareList();
        System.out.println("---------------------------------------");

    }


    private static void printList(List<? extends Number> list){
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            if(i<list.size()-1) System.out.print(list.get(i)+", ");
        }
        System.out.println("}");
    }
}
