package search.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* Description: strategy ANY
* the program should print the lines containing at least one word from the query.
* */

public class AnyStrategy implements FindDataStrategy{
    @Override
    public void findAPerson(Map<String, ArrayList<Integer>> mapForInvertedSearch, List<String> initialData, String wordForSearch) {
        //divide word for search into parts
        String[] listSearchItems = wordForSearch.toLowerCase().split(" ");

        for (int j = 0; j < listSearchItems.length; j++) {
            List<Integer> listOfStrings = mapForInvertedSearch.get(listSearchItems[j]);
            printResults(initialData, listOfStrings);
        }
    }

    private void printResults(List<String> initialData, List<Integer> listOfStrings) {
        if (listOfStrings != null) {
            System.out.println(listOfStrings.size() + " persons found");
            for (int i = 0; i < listOfStrings.size(); i++) {
                int numberOfString = listOfStrings.get(i);
                System.out.println(initialData.get(numberOfString));
            }
        }
    }
}
