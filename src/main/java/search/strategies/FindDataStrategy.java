package search.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FindDataStrategy {
    void findAPerson(Map<String, ArrayList<Integer>> mapForInvertedSearch, List<String> initialData, String wordForSearch);
}
