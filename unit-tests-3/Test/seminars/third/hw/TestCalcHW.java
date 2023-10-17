package seminars.third.hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seminars.third.hw.CalcHW.evenOddNumber;
import static seminars.third.hw.CalcHW.numberInInterval;

public class TestCalcHW {


    @ParameterizedTest
    @ValueSource(ints = {-3, -2, -1, 0, 1, 2, 3})
    void testEvenOddNumber(int i) {
        assertEquals(evenOddNumber(i), ((i % 2) == 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, 0, 10, 24, 25, 50, 99, 100, 120})
    void testNumberInInterval(int i) {
        assertEquals(numberInInterval(i), (25 < i && i < 100));
    }


}
