package com.concepts;

import java.math.BigDecimal;

public class ProjectedExpenseCalculator {

    public static void main(String[] args) {
        BigDecimal initialYearlyExpense = new BigDecimal(500000);
        int yearsFromNow = 25;
        double inflationRate = 6;
        int durationYears = 20;
        BigDecimal inflationRatio = new BigDecimal((100 + inflationRate) / 100);
        BigDecimal yearlyExpenseInflationAdjusted = initialYearlyExpense
                .multiply(inflationRatio.pow(yearsFromNow)).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(yearlyExpenseInflationAdjusted);
        BigDecimal totalExpenseForDuration = yearlyExpenseInflationAdjusted
                .multiply(BigDecimal.ONE.subtract(inflationRatio.pow(durationYears))
                        .divide(BigDecimal.ONE.subtract(inflationRatio)))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(totalExpenseForDuration);
    }
}
