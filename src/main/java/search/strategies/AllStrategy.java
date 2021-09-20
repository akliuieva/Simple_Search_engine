package search.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* Description: strategy ALL
 * the program should print the lines containing all words from the query.
 * */

public class AllStrategy implements FindDataStrategy {
    @Override
    public void findAPerson(Map<String, ArrayList<Integer>> mapForInvertedSearch, List<String> initialData, String wordForSearch) {
        //divide word  for search into parts
        String[] listSearchItems = wordForSearch.toLowerCase().split(" ");

        List<Integer> listOfStrings = findLineNumbers(mapForInvertedSearch, listSearchItems);

        printResults(initialData, listSearchItems, listOfStrings);
    }

    private List<Integer> findLineNumbers(Map<String, ArrayList<Integer>> mapForInvertedSearch, String[] listSearchItems) {
        List<Integer> listOfStrings = null;
        if (listSearchItems.length == 1) {
            listOfStrings = mapForInvertedSearch.get(listSearchItems[0]);
        } else {
            for (int i = 1; i < listSearchItems.length; i++) {
                if (mapForInvertedSearch.get(listSearchItems[0]) != null &&
                        mapForInvertedSearch.get(listSearchItems[0])
                                .equals(mapForInvertedSearch.get(listSearchItems[i]))) {
                    listOfStrings = mapForInvertedSearch.get(listSearchItems[0]);
                }
            }
        }
        return listOfStrings;
    }

    private void printResults(List<String> initialData, String[] listSearchItems, List<Integer> listOfStrings) {
        for (int j = 0; j < listSearchItems.length; j++) {
            if (listOfStrings != null) {
                System.out.println(listOfStrings.size() + " persons found");
                for (int i = 0; i < listOfStrings.size(); i++) {
                    int numberOfString = listOfStrings.get(i);
                    System.out.println(initialData.get(numberOfString));
                }
            }
        }
    }
}
