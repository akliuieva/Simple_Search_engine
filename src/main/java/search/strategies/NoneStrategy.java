package search.strategies;

import java.util.*;

/* Description: strategy NONE
 * the program should print lines that do not contain words from the query at all
 * */

public class NoneStrategy implements FindDataStrategy {
    @Override
    public void findAPerson(Map<String, ArrayList<Integer>> mapForInvertedSearch, List<String> initialData, String wordForSearch) {
        String[] listSearchItems = wordForSearch.toLowerCase().split(" ");
        Set<Integer> excludedLineNumbers = getExcludedLineNumbers(mapForInvertedSearch, listSearchItems);

        // print results
        printResults(initialData, excludedLineNumbers);
    }

    private void printResults(List<String> initialData, Set<Integer> excludedLineNumbers) {
        for (int i = 0; i < initialData.size(); i++) {
            if(excludedLineNumbers.contains(Integer.valueOf(i))){
            } else{
                System.out.println(initialData.get(i));
            }
        }
    }

    private Set<Integer> getExcludedLineNumbers(Map<String, ArrayList<Integer>> mapForInvertedSearch, String[] listSearchItems) {
        Set<Integer> excludedLineNumbers = new HashSet<>();

        for (int j = 0; j < listSearchItems.length; j++) {
            List<Integer> listOfStrings = mapForInvertedSearch.get(listSearchItems[j]);
            if (listOfStrings != null) {
                System.out.println(listOfStrings.size() + " persons found");
                for (int i = 0; i < listOfStrings.size(); i++) {
                    excludedLineNumbers.add(listOfStrings.get(i));
                }
            }
        }
        return excludedLineNumbers;
    }
}
