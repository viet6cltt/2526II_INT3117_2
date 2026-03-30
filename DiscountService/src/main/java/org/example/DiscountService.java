package org.example;

public class DiscountService {
    public String getDiscount(double totalAmount, int score, boolean isHoliday) {

        if (score < 0 || score > 1000 || totalAmount < 0) {
            return DiscountType.INVALID.toString();
        }

        if (score == 1000) { // top VIP
            if (totalAmount >= 1000000) {
                return DiscountType.TWENTY.toString();
            } else if (totalAmount >= 500000) {
                return DiscountType.FIFTEEN.toString();
            } else {
                return DiscountType.TEN.toString();
            }
        }

        if (score >= 500) { // VIP
            if (totalAmount >= 1000000) {
                return DiscountType.FIFTEEN.toString();
            } else if (totalAmount >= 500000) {
                return DiscountType.TEN.toString();
            } else {
                return DiscountType.FIVE.toString();
            }
        }

        // normal customer
        if (totalAmount >= 1000000) {
            return isHoliday ? DiscountType.TEN.toString() : DiscountType.FIVE.toString();
        }

        if (totalAmount >= 500000) {
            return isHoliday ? DiscountType.FIVE.toString() : DiscountType.ZERO.toString();
        }

        return DiscountType.ZERO.toString();
    }

}
