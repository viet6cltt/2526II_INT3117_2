package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountServiceTest {
    DiscountService service = new DiscountService();

    @ParameterizedTest
    @CsvSource({
            "500000, -1, false, INVALID",
            "500000, 0, false, 0%",
            "500000, 1, false, 0%",
            "500000, 999, false, 10%",
            "500000, 1000, false, 15%",
            "500000, 1001, false, INVALID",
            "-1, 500, false, INVALID",
            "0, 500, false, 5%",
            "1, 500, false, 5%"
    })
    void testBVA(double totalAmount, int score, boolean isHoliday, String expected) {
        assertEquals(expected, service.getDiscount(totalAmount, score, isHoliday));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 500, false, INVALID",

            "1000000, 1000, false, 20%",
            "500000, 1000, false, 15%",
            "100000, 1000, false, 10%",

            "1000000, 700, false, 15%",
            "500000, 700, false, 10%",
            "100000, 700, false, 5%",

            "1000000, 100, true, 10%",
            "1000000, 100, false, 5%",

            "500000, 100, true, 5%",
            "500000, 100, false, 0%",

            "100000, 100, false, 0%"
    })
    void testDecisionTable(double totalAmount, int score, boolean isHoliday, String expected) {
        assertEquals(expected, service.getDiscount(totalAmount, score, isHoliday));
    }
}
