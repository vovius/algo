package com.training.algo;

import java.util.HashMap;
import java.util.Map;

public class BudgetShopping {
    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
        return budgetShopping(n, bundleQuantities, bundleCosts, new HashMap<>());
    }

    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts, Map<Integer, Integer> memo) {
        if (n <= 0) {
            return 0;
        }

        if (!memo.containsKey(n)) {
            int max = 0;
            for (int i = 0; i < bundleQuantities.length; i++) {
                if (n >= bundleCosts[i]) {
                    max = Math.max(max, bundleQuantities[i] + budgetShopping(n - bundleCosts[i], bundleQuantities, bundleCosts, memo));
                }
            }
            memo.put(n, max);
        }

        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(budgetShopping(50, new int[]{20, 19}, new int[]{24, 20})); // 40
        System.out.println(budgetShopping(60, new int[]{20, 19}, new int[]{24, 20})); // 57
        System.out.println(budgetShopping(4, new int[]{10}, new int[]{2})); // 20
    }
}
