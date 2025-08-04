import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            displayList();
            menuDisplay();
            String choice = SafeInput.getRegExString(in, "Enter your choice [AaDdIiPpQq]: ", "[AaDdIiPpQq]");

            if (choice.equalsIgnoreCase("A")) {
                addItem(in);
            }
            else if (choice.equalsIgnoreCase("D")) {
                deleteItem(in);
            }
            else if (choice.equalsIgnoreCase("I")) {
                insertItem(in);
            }
            else if (choice.equalsIgnoreCase("P")) {
                displayList();
            }
            else if (choice.equalsIgnoreCase("Q")) {
                if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?")) {
                    done = true;
                }
            }
        }

        System.out.println("Thanks for using my ListMaker.");
    }

    private static void addItem(Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter an item to add to the list:");
        list.add(item);
    }

    private static void deleteItem(Scanner in) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        int location = SafeInput.getRangedInt(in, "Enter the number of the item to delete: ", 1, list.size());
        list.remove(location - 1);
    }

    private static void insertItem(Scanner in) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Adding item to position 1.");
            addItem(in);
            return;
        }

        int location = SafeInput.getRangedInt(in, "Enter the position you wish to insert the item (1 to " + (list.size() + 1) + "): ", 1, list.size() + 1);
        String input = SafeInput.getNonZeroLenString(in, "Enter the item to insert:");
        list.add(location - 1, input);
    }
    private static void menuDisplay () {
        System.out.println("\nMenu Options:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("I – Insert an item into the list");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit the program");
    }

    private static void displayList() {
        System.out.println("Current List:");
        for (String item : list) {
            System.out.println("* " + item);
        }
        System.out.println();
    }

    private static void displayNumberedList() {
        System.out.println("\nNumbered List:");
        for (int x = 0; x < list.size(); x++) {
            System.out.println((x + 1) + ": " + list.get(x));
        }
        System.out.println();
    }
}
