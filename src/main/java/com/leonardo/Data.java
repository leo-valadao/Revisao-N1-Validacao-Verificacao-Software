package com.leonardo;

public class Data {

    // Attributes
    private Integer year;
    private Integer month;
    private Integer day;

    // Constructor
    public Data(Integer day, Integer month, Integer year) {

        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }

    // Getters and Setters
    // Year
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {

        // Year Validation
        if (year != null && year >= 0 && year <= 9999) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid Year!");
        }
    }

    // Month
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {

        // Month Validation
        if (month != null && month >= 1 && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid Month!");
        }
    }

    // Day
    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {

        // Day Validation
        switch (this.month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (day != null && day >= 1 && day <= 31) {
                    this.day = day;
                } else {
                    throw new IllegalArgumentException("Invalid Day!");
                }
                break;
            case 4: case 6: case 9: case 11:
                if (day != null && day >= 1 && day <= 30) {
                    this.day = day;
                } else {
                    throw new IllegalArgumentException("Invalid Day!");
                }
                break;
            case 2:
                if (day != null && day >= 1 && day <= 28) {
                    this.day = day;
                } else {
                    throw new IllegalArgumentException("Invalid Day!");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid Day!");
        }
    }

    // To String
    @Override
    public String toString() {
        return String.format("%02d", this.day) + "/" + String.format("%02d", this.month) + "/"
                + String.format("%04d", this.year);
    }
}
