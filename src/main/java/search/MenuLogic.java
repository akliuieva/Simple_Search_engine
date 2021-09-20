package search;

import search.strategies.AllStrategy;
import search.strategies.AnyStrategy;
import search.strategies.Context;
import search.strategies.NoneStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static search.Main.getEnteredData;

public class MenuLogic {

    private void printAllPeople(List<String> listOfPersons) {
        System.out.println("=== List of people ===");
        listOfPersons.stream().forEach(System.out::println);
    }

    public void printInstruction() {
        System.out.println("=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");
    }

    private static int getMenuOption() {
        while (true) {
            try {
                return Integer.valueOf(getEnteredData());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number of search queries:");
            }
        }
    }

    public void start(Map<String, ArrayList<Integer>> mapForInvertedSearch, List<String> initialLines) {
        while (true) {
            printInstruction();
            int enteredNumber = getMenuOption();
            if (enteredNumber == Menu.FIND_A_PERSON.getNumberOfOperation()) {
                String strategyType = getStrategyType();
                String dataForSearch = getDataForSearch();
                Context context = setStrategy(strategyType);
                context.findAPerson(mapForInvertedSearch, initialLines, dataForSearch);
            } else if (enteredNumber == Menu.PRINT_ALL_PEOPLE.getNumberOfOperation()) {
                printAllPeople(initialLines);
            } else if (enteredNumber == Menu.EXIT.getNumberOfOperation()) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Incorrect option! Try again.");
            }
        }
    }

    private Context setStrategy(String strategyType) {
        if (strategyType.equals("ALL")) {
            return new Context(new AllStrategy());
        } else if (strategyType.equals("ANY")) {
            return new Context(new AnyStrategy());
        } else if(strategyType.equals("NONE")) {
            return new Context(new NoneStrategy());
        } else{
            throw new RuntimeException("Invalid strategy type!");
        }
    }

    private String getDataForSearch() {
        System.out.println("Enter a name or email to search all suitable people.");
        while (true) {
            String stringForSearch = getEnteredData();
            if (stringForSearch != null) {
                return stringForSearch;
            }
        }
    }

    private String getStrategyType() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        return getStrategyName();
    }

    private String getStrategyName() {
        while (true) {
            String strategyName = getEnteredData();
            if (strategyName.equals("ANY") || strategyName.equals("NONE") || strategyName.equals("ALL")) {
                return strategyName;
            } else {
                System.out.println("Enter valid strategy name");
            }
        }
    }
}
