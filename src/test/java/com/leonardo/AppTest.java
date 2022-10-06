package com.leonardo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {

    private Data data;
    private Integer[] monthsWith31Days = { 1, 3, 5, 7, 8, 10, 12 };
    private Integer[] monthsWith30Days = { 4, 6, 9, 11 };

    @BeforeEach
    public void createData() {
        this.data = new Data(1, 1, 2022);
    }

    // Year
    @Test
    @DisplayName("Year - 0 to 9999")
    public void year0to9999() {

        for (int i = 0; i <= 9999; i++) {
            data.setYear(i);
            assertEquals(Integer.valueOf(i), data.getYear());
        }
    }

    @Test
    @DisplayName("Year - Below 0")
    public void yearBelow0() {
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setYear(-1));
    }

    @Test
    @DisplayName("Year - Above 9999")
    public void yearAbove9999() {
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setYear(10000));
    }

    @Test
    @DisplayName("Year - Not Integer")
    public void yearNotInt() {
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setYear(10 / -3));
    }

    // Month
    @Test
    @DisplayName("Month - 1 to 12")
    public void month1To12() {
        for (int i = 0; i <= 12; i++) {
            data.setYear(i);
            assertEquals(Integer.valueOf(i), data.getYear());
        }
    }

    @Test
    @DisplayName("Month - Below 1")
    public void monthBelow1() {
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setMonth(0));
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setMonth(-1));
    }

    @Test
    @DisplayName("Month - Above 12")
    public void monthAbove12() {
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setMonth(13));
    }

    @Test
    @DisplayName("Month - Not Integer")
    public void monthNotInt() {
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setMonth(10 / -3));
    }

    // Day
    @Test
    @DisplayName("Day - Below 1")
    public void dayBelow1() {
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setDay(0));
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setDay(-1));
    }

    @Test
    @DisplayName("Day - Above 31")
    public void dayAbove31() {
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setDay(32));
    }

    @Test
    @DisplayName("Day - Not Integer")
    public void dayNotInt() {
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setDay(10 / -3));
    }

    @Test
    @DisplayName("Day - 31 on Month of 30 Days")
    public void Day31OnMonthsOf30Days() {

        for (Integer month : monthsWith30Days) {
            data.setMonth(month);
            assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setDay(31));
        }
    }

    @Test
    @DisplayName("Day - 29 to 31 on Month of 28 Days")
    public void Day29to31() {

        data.setMonth(2);
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setDay(29));
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setDay(30));
        assertThrowsExactly(IllegalArgumentException.class, () -> this.data.setDay(31));
    }

    // 31 Days on Month of 31 Days (1, 3, 5, 7, 8, 10, 12)
    @Test
    @DisplayName("Day - 31 Days on Month of 31 Days")
    public void daysFromMonthsWith31Days() {

        for (Integer month : monthsWith31Days) {
            data.setMonth(month);

            for (int day = 1; day <= 31; day++) {
                data.setDay(day);
                assertEquals(day, data.getDay());
            }
        }
    }

    // 30 Days on Month of 30 Days (4, 6, 9, 11)
    @Test
    @DisplayName("Day - 30 Days on Month of 30 Days")
    public void daysFromMonthsWith30Days() {

        for (Integer month : monthsWith30Days) {
            data.setMonth(month);

            for (int day = 1; day <= 30; day++) {
                data.setDay(day);
                assertEquals(day, data.getDay());
                System.out.println(data.toString());
            }
        }
    }

    // 28 Days on Month of 28 Days (2)
    @Test
    @DisplayName("Day - 28 Days on Month of 28 Days")
    public void daysFromMonthsWith28Days() {

        data.setMonth(2);

        for (int day = 1; day <= 28; day++) {
            data.setDay(day);
            assertEquals(day, data.getDay());
        }
    }

    @Test
    @DisplayName("Valid Datas")
    public void validDatas() {
        data = new Data(1, 3, 2021);
        assertEquals("01/03/2021", data.toString());

        data = new Data(31, 3, 2021);
        assertEquals("31/03/2021", data.toString());

        data = new Data(30, 4, 2021);
        assertEquals("30/04/2021", data.toString());

        data = new Data(28, 2, 2021);
        assertEquals("28/02/2021", data.toString());
    }

    @Test
    @DisplayName("Invalid Datas")
    public void invalidDatas() {
        assertThrowsExactly(IllegalArgumentException.class, () -> data = new Data(0, 2, 1980));
        assertThrowsExactly(IllegalArgumentException.class, () -> data = new Data(32, 2, 1966));
        assertThrowsExactly(IllegalArgumentException.class, () -> data = new Data(1, 0, 2000));
        assertThrowsExactly(IllegalArgumentException.class, () -> data = new Data(2, 13, 1800));
        assertThrowsExactly(IllegalArgumentException.class, () -> data = new Data(3, 10 / -3, 1900));
    }
}
