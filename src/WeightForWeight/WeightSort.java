package WeightForWeight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WeightSort {

    public static void main(String[] args){
        WeightSort sorter = new WeightSort();
        sorter.orderWeight("2000 103 123 4444 99");
    }

    public static String orderWeight(String s) {
        String ans = buildWeightedString(getSubStrings(s));
        System.out.println(ans);
        return s;
    }

    public static String[] getSubStrings(String string) {
        String[] subStrings = string.split(" ");
        return subStrings;
    }

    public static String buildWeightedString(String[] weightsAsStrings) {
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < weightsAsStrings.length; i++) {
            strings.add(weightsAsStrings[i]);
        }

        Collections.sort(strings);
        Collections.sort(strings, new Comparator<String>() {
            public int compare(String s1, String s2) {
                Integer rank1 = String.valueOf(s1).chars().map(Character::getNumericValue).sum();
                Integer rank2 = String.valueOf(s2).chars().map(Character::getNumericValue).sum();
                if (rank1 > rank2) {
                    return 1;
                } else if (rank1 == rank2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        String ans = "";
        for (String s : strings) {
            ans += s + " ";
            //sb.append(s + " ");
        }

        return ans; //sb.toString().stripTrailing();
    }
}


    /* // implementation using Pair (not supported by codeWars web IDE
import java.util.Comparator;
import java.util.stream.*;
import java.util.ArrayList;
import javafx.util.Pair;
import java.util.*;

public class WeightSort {

    public static String orderWeight(String string){
        String s = buildWeightedString(getSubStrings(string));
        System.out.println(s);
        return s;
    }

    public static String[] getSubStrings(String string){
        String[] subStrings = string.split(" ");
        return subStrings;
    }

    public static String buildWeightedString(String[] weightsAsStrings){
        ArrayList<Pair> weightsWithWeights = new ArrayList<Pair>();
        for (String string : weightsAsStrings) {
            Integer weightAsSum = 0;
            for(int i = 0; i < string.length(); i++){
                weightAsSum += Integer.parseInt(String.valueOf(Character.getNumericValue(string.charAt(i))));
            }
            Pair<String, Integer> weightWithWeight = new Pair<>(string, weightAsSum);
            weightsWithWeights.add(weightWithWeight);
        }
        weightsWithWeights.sort(pairComparator);
        String answer = new String();
        for(Pair p : weightsWithWeights){
            answer += " " + (String)p.getKey();
        }
        return answer;
    }

    public static Comparator<Pair> pairComparator = new Comparator<Pair>(){
        public int compare(Pair p1, Pair p2){
           return ((Integer)p1.getValue()).compareTo((Integer)p2.getValue());
                   }
                   };
                   }

*/
