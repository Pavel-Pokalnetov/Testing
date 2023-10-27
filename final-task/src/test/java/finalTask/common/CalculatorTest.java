package finaltask.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class CalculatorTest {
    //списки для тестирования
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    List<Double> doubleList = Arrays.asList(1.4, 2.1, 3.0, 4.5, 5.6);
    List<Float> floatList = Arrays.asList(0f, 2f, 3f, 4f, 5f);
    List<Long> longList = Arrays.asList(1L, 2L, 3L, 4L, 5L);
    List<Short> shortList = Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
    List<Byte> byteList = Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
    List<Integer> emptyList = new ArrayList<>();

    @Test
    void testCalculatorConstructorNullArguments() {

        //проверка передачи null списков
        // первый список == null
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            new Calculator(null, integerList);
        });
        Assertions.assertEquals("one of the lists is null", thrown.getMessage());

        // второй список == null
        thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            new Calculator(integerList, null);
        });
        Assertions.assertEquals("one of the lists is null", thrown.getMessage());

        // оба списка == null
        thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            new Calculator(null, null);
        });
        Assertions.assertEquals("one of the lists is null", thrown.getMessage());

    }

    @Test
    void testCalculatorConstrictorEmptyListInArguments() {

        // передача пустого списка
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            new Calculator(emptyList, integerList);
        });
        Assertions.assertEquals("an empty list was received, calculations are impossible", thrown.getMessage());
        thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            new Calculator(integerList, emptyList);
        });
        Assertions.assertEquals("an empty list was received, calculations are impossible", thrown.getMessage());
        thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            new Calculator(emptyList, emptyList);
        });
        Assertions.assertEquals("an empty list was received, calculations are impossible", thrown.getMessage());
    }

    @Test
    void testCalculatorConstructorCorrectArguments() {
        // проверка передачи списков всех возможных типов данных
        List<List<? extends Number>> testList = new ArrayList<>();
        testList.add(integerList);
        testList.add(doubleList);
        testList.add(floatList);
        testList.add(longList);
        testList.add(shortList);
        testList.add(byteList);

        List<? extends Number> arg1 = null;
        List<? extends Number> arg2 = null;
        try {
            for (List<? extends Number> l : testList) {
                for (List<? extends Number> n : testList) {
                    arg1 = l;
                    arg2 = n;
                    new Calculator(arg1, arg2);
                }
            }
        } catch (Exception e) {
            fail("unexpected exception in the constructor with arguments (List<" + arg1.get(0).getClass() + "> , List<" + arg2.get(0).getClass() + ">)");
        }
    }

    @Test
    void testCompareListOutput() {
        String BIGGER = "Первый список имеет большее среднее значение";
        String SMALLER = "Второй список имеет большее среднее значение";
        String EQUAL = "Средние значения равны";

        assertEquals(EQUAL, new Calculator(Arrays.asList(1, 2, 3, 4), Arrays.asList(1, 2, 3, 4)).compareList());


        assertEquals(SMALLER, new Calculator(Arrays.asList(1, 2, 3, 0), Arrays.asList(1, 2, 3, 4)).compareList());


        assertEquals(BIGGER, new Calculator(Arrays.asList(4, 5, 6, 7, 8, 9), Arrays.asList(1, 2, 3, 4)).compareList());


    }

}