package com.carlosli.leetcode.array;

/**
 * Created by yulongli on 2016/10/28.
 */
public class BestTimeToBuyAndSellStock121 {
    /**
     * time O(n^2)   n(n+1)/2
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int differenceValue = prices[j] - prices[i];
                    if (differenceValue > max) {
                        max = differenceValue;
                    }
                }
            }
        }
        return max;
    }

    public static int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        int[] prices2 = new int[]{6,3,5,1,2};
        System.out.println(maxProfit2(prices2));
    }
}
