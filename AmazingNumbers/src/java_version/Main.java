package java_version;

public class Main {
    public static void main(String[] args) throws NumberException {
        UserInteraction userInteraction = new UserInteraction();
        try {
            userInteraction.menu();
            userInteraction.startProgram();
        } catch (NumberException e) {
            System.out.println(e.getMessage());
            userInteraction.startProgram();
        }
    }
}