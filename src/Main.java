import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String query;
        boolean YorN = false;
        ArrayList<String> userIn = new ArrayList<>();
        
        do {
            display(userIn);
            query = SafeInput.getRegExString(in, "Enter what you would like to do: ", "AaDdPpQq");

            if(query.equals("A") || query.equals("a") || query.equals("P") || query.equals("p") || query.equals("D") || query.equals("d") || query.equals("Q") || query.equals("q")) {
                if(query.equals("A") || query.equals("a")) {
                    addToArray(userIn, SafeInput.getNonZeroLenString(in, "What would you like to add?"));
                } else if (query.equals("D") || query.equals("d")) {
                    displayNum(userIn);
                    deleteFromArray(userIn, (SafeInput.getRangedInt(in, "Which part of the array would you like to remove?", 1, userIn.size())) - 1);
                } else if (query.equals("P") || query.equals("p")) {
                    display(userIn);
                } else if (query.equals("Q") || query.equals("q")) {
                    quitArray(userIn, YorN, in, "Are you sure you would like to quit?");
                }
            } else{
                System.out.println("Invalid entry. Try again.");
            }
        }while(!YorN);
    }

    private static void addToArray(ArrayList<String> array, String prompt) {
        array.add(prompt);
    }

    private static void deleteFromArray(ArrayList<String> array, int i) {
        displayNum(array);
        array.remove(i);
    }

    private static boolean quitArray(ArrayList<String> array, boolean quit, Scanner pipe, String prompt) {
        quit = SafeInput.getYNConfirm(pipe, prompt);
        if(quit) {
            return true;
        } else {
            return false;
        }
    }

    private static String display(ArrayList<String> array) {
        System.out.println("If you would like to make changes to the array, enter these options [A, D, P, Q]");
        System.out.println("A will add to the array; D will delete from the array; P will print the array; Q will quit the array");
        System.out.println(array);
        return null;
    }

    private static String displayNum(ArrayList<String> array) {
        display(array);
        System.out.println("This is the numbered version of the array");
        for(int i = 0; i < array.size(); i++) {
            System.out.print((i + 1) + " ");
        }
        return null;
    }
}
