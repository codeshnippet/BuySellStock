package com.codeshnippet.buysellstock.calculators;

import com.codeshnippet.buysellstock.MaxProfitCalculator;

public class LinearCalculator implements MaxProfitCalculator {

    public double calculateProfit(double[] prices) {
        // Covering null or empty input edge-case
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0.0;
        }

        double currMin = prices[0];
        double currMaxProfit = 0.0;

        // Iterating through prices searching for maximum profit possible at given day
        for (double price : prices) {
            currMaxProfit = price - currMin > currMaxProfit ? price - currMin : currMaxProfit;
            currMin = price < currMin ? price : currMin;
        }

        return currMaxProfit;
    }
}
