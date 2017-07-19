package com.codeshnippet.buysellstock;

import com.codeshnippet.buysellstock.calculators.LinearCalculator;
import com.codeshnippet.buysellstock.calculators.NestedLoopCalculator;
import com.codeshnippet.buysellstock.calculators.RecursiveCalculator;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class MaxProfitCalculatorTest {

    @DataProvider
    public static Object[][] calculators() {
        return new Object[][]{
                new Object[]{new RecursiveCalculator()},
                new Object[]{new NestedLoopCalculator()},
                new Object[]{new LinearCalculator()}
        };
    }

    @Test
    @UseDataProvider("calculators")
    public void testNullInput(MaxProfitCalculator calculator) {
        double result = calculator.calculateProfit(null);

        assertEquals(0.0, result, 0.0);
    }

    @Test
    @UseDataProvider("calculators")
    public void testEmptyInput(MaxProfitCalculator calculator) {
        double result = calculator.calculateProfit(new double[]{});

        assertEquals(0.0, result, 0.0);
    }

    @Test
    @UseDataProvider("calculators")
    public void testSingleDay(MaxProfitCalculator calculator) {
        double result = calculator.calculateProfit(new double[]{15.0});

        assertEquals(0.0, result, 0.0);
    }

    @Test
    @UseDataProvider("calculators")
    public void testTwoDaysIncreasing(MaxProfitCalculator calculator) {
        double result = calculator.calculateProfit(new double[]{15.0, 20.0});

        assertEquals(5.0, result, 0.0);
    }

    @Test
    @UseDataProvider("calculators")
    public void testTwoDaysDecreasing(MaxProfitCalculator calculator) {
        double result = calculator.calculateProfit(new double[]{20.0, 15.0});

        assertEquals(0.0, result, 0.0);
    }

    @Test
    @UseDataProvider("calculators")
    public void testWeekOfData(MaxProfitCalculator calculator) {
        double result = calculator.calculateProfit(new double[]{62, 63, 55, 59, 52, 54, 58, 46, 51, 50});

        assertEquals(6.0, result, 0.0);
    }
}