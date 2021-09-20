package search;

public enum Menu {
    FIND_A_PERSON(1),
    PRINT_ALL_PEOPLE(2),
    EXIT(0);

    private int numberOfOperation;

    Menu(int numberOfOperation) {
        this.numberOfOperation = numberOfOperation;
    }

    public int getNumberOfOperation() {
        return numberOfOperation;
    }

    public void setNumberOfOperation(int numberOfOperation) {
        this.numberOfOperation = numberOfOperation;
    }
}
