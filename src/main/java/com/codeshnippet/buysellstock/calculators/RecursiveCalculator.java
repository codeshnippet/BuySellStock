package com.codeshnippet.buysellstock.calculators;

import com.codeshnippet.buysellstock.MaxProfitCalculator;

public class RecursiveCalculator implements MaxProfitCalculator {

    public double calculateProfit(double[] prices) {
        // Covering null or empty input edge-case
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0.0;
        }

        // Calculating the maximum profit
        return findMaxProfit(prices, 0, prices.length).profit;
    }

    /**
     * Recursive function to calculate the most profitable buy - sell operation
     * in a given range of input array values.
     *
     * @param prices array of prices, each element holds price of stock.
     * @param from   the initial index of the range, inclusive.
     * @param to     the final index of the range, exclusive.
     * @return Result object containing biggest profit for the range of input array values.
     */
    private Result findMaxProfit(double[] prices, int from, int to) {
        // Length of the range
        int n = to - from;

        // ----------
        // Base case of recursion
        // ----------

        if (n == 1) {
            double singlePrice = prices[from];

            return new Result(0.0, singlePrice, singlePrice);
        }

        // ----------
        // Divide subroutine starts here:
        // ----------

        int divideIndex = from + n / 2;

        Result leftResult = findMaxProfit(prices, from, divideIndex);
        Result rightResult = findMaxProfit(prices, divideIndex, to);

        // ----------
        // Combine subroutine starts here:
        // ----------

        // Searching for the maximum profit. By default setting it to combined profit of left and right ranges.
        double maxProfit = rightResult.max > leftResult.min ? rightResult.max - leftResult.min : 0.0;
        maxProfit = maxProfit < leftResult.profit ? leftResult.profit : maxProfit;
        maxProfit = maxProfit < rightResult.profit ? rightResult.profit : maxProfit;

        // Calculating cross-range minimum and maximum
        double crossMin = Math.min(leftResult.min, rightResult.min);
        double crossMax = Math.max(leftResult.max, rightResult.max);

        return new Result(maxProfit, crossMin, crossMax);
    }

    /**
     * Helper class (POJO, structure) that will be used internally by profit calculating algorithm.
     */
    private static class Result {
        public Result(double profit, double min, double max) {
            this.profit = profit;
            this.min = min;
            this.max = max;
        }

        private final double profit;
        private final double min;
        private final double max;

    }
}
