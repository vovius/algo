package com.training.algo;

public class BudgetProblem {

    int result = 0;

    public int process(int[] prices, int[] amounts, int budget) {
        if (budget <= 0) {
            return 0;
        }

        int maxAmount = 0;
        for (int i=0; i < prices.length; i++) {
            if (budget >= prices[i]) {
                int amount = amounts[i] + process(prices, amounts, budget - prices[i]);
                maxAmount = Math.max(maxAmount, amount);
            }
        }

        result = Math.max(result, maxAmount);

        return maxAmount;
    }

    public static void main(String[] args) throws InterruptedException {
        BudgetProblem budgetProblem = new BudgetProblem();

        long time = System.currentTimeMillis();
        budgetProblem.result = 0;
        budgetProblem.process(new int[]{24, 20}, new int[]{20, 19}, 50);
        System.out.println(budgetProblem.result + ", time=" + (System.currentTimeMillis()-time));

        time = System.currentTimeMillis();
        budgetProblem.result = 0;
        budgetProblem.process(new int[]{2}, new int[]{10}, 4);
        System.out.println(budgetProblem.result + ", time=" + (System.currentTimeMillis()-time));


    }
}
