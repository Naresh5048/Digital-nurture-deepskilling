package com.cts.structures.exercise07;

class ForecastEngine {
    public double calculateFutureValue(double basePresentValue, double annualGrowthRate, int targetYears) {
        // Base Case: Current value is reached when years count hits 0 [cite: 94]
        if (targetYears == 0) {
            return basePresentValue;
        }
        // Recursive Case: Compute previous years value then apply growth rate [cite: 98]
        double previousYearValue = calculateFutureValue(basePresentValue, annualGrowthRate, targetYears - 1);
        return previousYearValue * (1.0 + annualGrowthRate);
    }
}

public class FinancialForecasting {
    public static void main(String[] args) {
        System.out.println("Financial Compound Growth Calculator\n");
        ForecastEngine engine = new ForecastEngine();
        double presentValue = 1500000.00; 
        double rate = 0.08;
        int years = 5; 
        double futureValue = engine.calculateFutureValue(presentValue, rate, years);
        System.out.println("Initial Investment Capital Asset Baseline Value: ₹" + presentValue);
        System.out.println("Target Evaluation Growth Metric Matrix       : " + (rate * 100) + "%");
        System.out.println("Projected Asset Valuation at Year " + years + "          : " + String.format("%.2f", futureValue));
    }
}