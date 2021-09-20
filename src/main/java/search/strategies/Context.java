package search.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Context {
    private FindDataStrategy strategy;

    public Context(FindDataStrategy strategy) {
        this.strategy = strategy;
    }

    public void findAPerson(Map<String, ArrayList<Integer>> mapForInvertedSearch, List<String> initialData, String wordForSearch){
        strategy.findAPerson(mapForInvertedSearch, initialData, wordForSearch);
    }
}
