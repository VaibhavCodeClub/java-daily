import java.util.*;
// new class above
/*class Results {
    String sn;
    Vector<String> tc;

    Results() {
        tc = new Vector<>();
    }
    }*/

public class AnjiCards {
    public Results solution(String[] cards) {
      
      
      
      
      
      // remove prev code
        Results result = new Results();
        
        if (cards.length == 0) {
            result.sn = "single card";
            return result;
        }
        
Arrays.sort(cards, (a, b) -> getRank(b.charAt(0)) - getRank(a.charAt(0)));
        
        // Check for each set type in order of strength
        if (checkTripleAndPair(cards, result)) return result;
        
        
        
        
        if (checkSuit(cards, result)) return result;
        if (checkFiveInARow(cards, result)) return result;
        
        
        if (checkTriple(cards, result)) return result;
        if (checkPair(cards, result)) return result;
        
        // If no other set is found, return the highest single card
        result.sn = "single card";
        result.tc.add(cards[0]);
        
        return result;
    }
    
    private boolean checkTripleAndPair(String[] cards, Results result) {
        Map<Character, List<String>> rankGroups = groupByRank(cards);
        
        String triple = null;
        String pair = null;
        
        for (Map.Entry<Character, List<String>> entry : rankGroups.entrySet()) {
            if (entry.getValue().size() >= 3 && triple == null) {
                triple = entry.getKey().toString();
            } else if (entry.getValue().size() >= 2 && pair == null) {
                pair = entry.getKey().toString();
            }
            
            if (triple != null && pair != null) {
                result.sn = "a triple and a pair";
               
                result.tc.addAll(rankGroups.get(triple.charAt(0)).subList(0, 3));
                
                result.tc.addAll(rankGroups.get(pair.charAt(0)).subList(0, 2));
                return true;
            }
        }
        
        return false;
    }
    
    private boolean checkSuit(String[] cards, Results result) {
      
        Map<Character, List<String>> suitGroups = groupBySuit(cards);
        
        for (List<String> suitCards : suitGroups.values()) {
            if (suitCards.size() >= 5) {
                result.sn = "suit";
                result.tc.addAll(suitCards.subList(0, 5));
                return true;
            }
        }
        
        return false;
    }
    
    private boolean checkFiveInARow(String[] cards, Results result) {
        int cc = 1;
        List<String> ccs = new ArrayList<>();
        ccs.add(cards[0]);
        
        for (int i = 1; i < cards.length && cc < 5; i++) {
            if (getRank(cards[i].charAt(0)) == getRank(cards[i-1].charAt(0)) - 1) {
                cc++;
                ccs.add(cards[i]);
            } else if (getRank(cards[i].charAt(0)) != getRank(cards[i-1].charAt(0))) {
                cc = 1;
                ccs.clear();
                ccs.add(cards[i]);
            }
        }
        
        if (cc >= 5) {
            result.sn = "five in a row";
            result.tc.addAll(ccs.subList(0, 5));
            return true;
        }
        
        return false;
    }
    
    private boolean checkTriple(String[] cards, Results result) {
        Map<Character, List<String>> rankGroups = groupByRank(cards);
        
        for (List<String> rankCards : rankGroups.values()) {
            if (rankCards.size() >= 3) {
                result.sn = "triple";
                result.tc.addAll(rankCards.subList(0, 3));
                return true;
            }
        }
        
        return false;
    }
    
    private boolean checkPair(String[] cards, Results result) {
        Map<Character, List<String>> rankGroups = groupByRank(cards);
        
        for (List<String> rankCards : rankGroups.values()) {
            if (rankCards.size() >= 2) {
                result.sn = "pair";
                result.tc.addAll(rankCards.subList(0, 2));
                return true;
            }
        }
        
        return false;
    }
    
    private Map<Character, List<String>> groupByRank(String[] cards) {
        Map<Character, List<String>> groups = new HashMap<>();
        for (String card : cards) {
            groups.computeIfAbsent(card.charAt(0), k -> new ArrayList<>()).add(card);
        }
        return groups;
    }
    
    private Map<Character, List<String>> groupBySuit(String[] cards) {
        Map<Character, List<String>> groups = new HashMap<>();
        for (String card : cards) {
            groups.computeIfAbsent(card.charAt(1), k -> new ArrayList<>()).add(card);
        }
        return groups;
    }
    
    private int getRank(char rank) {
        switch (rank) {
            case 'A': return 14;
            case 'K': return 13;
            case 'Q': return 12;
            case 'J': return 11;
            default: return rank - '0';
        }
    }

    

    
    
    
    public static void main(String[] args) {
    AnjiCards solution = new AnjiCards();

    // Test Case 1: Single Card
    String[] cards1 = {"10D", "10H", "10C", "2S", "2H", "2D","JH","JC"};
    Results result1 = solution.solution(cards1);
    System.out.println(result1.sn); // Expected: single card
    System.out.println(result1.tc); // Expected: [KS]

    // Test Case 2: Pair
    String[] cards2 = {"AS", "10H", "8H", "10S", "8D"};
    Results result2 = solution.solution(cards2);
    System.out.println(result2.sn); // Expected: pair
    System.out.println(result2.tc); // Expected: [10H, 10S]

    // Test Case 3: Triple
    String[] cards3 = {"AS", "JS", "AH", "AD", "10D", "AC"};
    Results result3 = solution.solution(cards3);
    System.out.println(result3.sn); // Expected: triple
    System.out.println(result3.tc); // Expected: [AH, AD, AC]

    // Test Case 4: Five in a Row
    String[] cards4 = {"6H", "7S", "8S", "9S", "10S", "JD", "JC", "KC", "AC"};
    Results result4 = solution.solution(cards4);
    System.out.println(result4.sn); // Expected: five in a row
    System.out.println(result4.tc); // Expected: [7S, 8S, 9S, 10S, JC]

    // Test Case 5: Suit
    String[] cards5 = {"2D", "4D", "6D", "8D", "9D", "AC", "KC", "QC", "JC", "7C"};
    Results result5 = solution.solution(cards5);
    System.out.println(result5.sn); // Expected: suit
    System.out.println(result5.tc); // Expected: [2D, 4D, 6D, 8D, 9D]

    // Test Case 6: Triple and a Pair
    String[] cards6 = {"10H", "10D", "10C", "2S", "2H", "2D", "JH", "JC"};
    Results result6 = solution.solution(cards6);
    System.out.println(result6.sn); // Expected: a triple and a pair
    System.out.println(result6.tc); // Expected: [10H, 10D, 10C, 2S, 2H]

    // Test Case 7: No valid sets
    String[] cards7 = {"2H"};
    Results result7 = solution.solution(cards7);
    System.out.println(result7.sn); // Expected: single card
    System.out.println(result7.tc); // Expected: [2H]
}

}
