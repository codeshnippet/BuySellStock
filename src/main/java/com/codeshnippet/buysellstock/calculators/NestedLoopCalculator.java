package com.codeshnippet.buysellstock.calculators;

import com.codeshnippet.buysellstock.MaxProfitCalculator;

public class NestedLoopCalculator implements MaxProfitCalculator {

    public double calculateProfit(double[] prices) {
        // Covering edge-cases
        if (prices == null || prices.length < 2) {
            return 0.0;
        }

        // Searching for max profit by checking all possible pairs
        double max = 0.0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                double profit = prices[j] - prices[i];
                max = max < profit ? profit : max;
            }
        }

        return max;
    }
}
