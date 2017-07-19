package com.codeshnippet.buysellstock.calculators;

import com.codeshnippet.buysellstock.MaxProfitCalculator;

public class LinearCalculator implements MaxProfitCalculator {

    public double calculateProfit(double[] prices) {
        // Covering null input edge-case
        if (prices == null) {
            return 0.0;
        }

        double maxProfit = 0.0, minPrice = Double.MAX_VALUE;

        // Iterating through prices searching for maximum profit possible at given day
        for (double price : prices) {
            maxProfit = price - minPrice > maxProfit ? price - minPrice : maxProfit;
            minPrice = price < minPrice ? price : minPrice;
        }

        return maxProfit;
    }
}
