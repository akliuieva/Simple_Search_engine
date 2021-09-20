package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> inputLines = new ArrayList<>();
        Map<String, ArrayList<Integer>> mapForInvertedSearch = new HashMap<String, ArrayList<Integer>>();
        String fileName = args[1];
        String pathToFile = "src/main/resources/";
        File file = new File(pathToFile + fileName);
        try (Scanner scanner = new Scanner(file)) {
            int currentLineNumber = 0;
            while (scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                addLineToList(inputLines, currentLine);
                putStringToMap(mapForInvertedSearch, currentLine, currentLineNumber);
                currentLineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + fileName);
        }

        MenuLogic menu = new MenuLogic();
        menu.start(mapForInvertedSearch, inputLines);
    }

    private static void addLineToList(List<String> inputLines, String currentLine) {
        inputLines.add(currentLine);
    }

    private static void putStringToMap(Map<String, ArrayList<Integer>> mapForInvertedSearch, String currentLine, int currentLineNumber) {
        String[] arrayPersonData = currentLine.toLowerCase().split(" ");
        for (int i = 0; i < arrayPersonData.length; i++) {
            if (mapForInvertedSearch.get(arrayPersonData[i]) == null) {
                mapForInvertedSearch.put(arrayPersonData[i], new ArrayList<>(Arrays.asList(currentLineNumber)));
            } else {
                ArrayList<Integer> entry = mapForInvertedSearch.get(arrayPersonData[i]);
                entry.add(currentLineNumber);
            }
        }
    }

    public static String getEnteredData() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

