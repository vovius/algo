package com.training.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckStringConsistsFromDictStrings {

    public boolean check(String str, Set<String> dict) {

        if (str.isEmpty()) {
            return true;
        }

        boolean result = false;
        for (int i=1; i <= str.length(); i++) {
            String curStr = str.substring(0, i);
            if (dict.contains(curStr)) {
                result = check(str.substring(i), dict);
            }

            if (result) {
                break;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        CheckStringConsistsFromDictStrings checkStringConsistsFromDictStrings = new CheckStringConsistsFromDictStrings();
        System.out.println(checkStringConsistsFromDictStrings.check("goodbyem", new HashSet<>(Arrays.asList("good", "bye", "goodb", "yem"))));
    }

}
