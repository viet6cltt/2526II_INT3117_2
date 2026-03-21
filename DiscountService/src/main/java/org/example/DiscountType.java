package org.example;

public enum DiscountType {
    ZERO("0%"),
    FIVE("5%"),
    TEN("10%"),
    FIFTEEN("15%"),
    TWENTY("20%"),
    INVALID("INVALID");

    private final String value;

    DiscountType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
