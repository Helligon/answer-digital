/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Answer.Digital;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        boolean continueAskingForInput = true;
        Store store = new Store();
        Till till = store.createTill();
        Scanner scanner = new Scanner(System.in);
        store.fileParse("sku-list.txt");

        System.out.println("Enter a list of product codes to store in the basket. " +
                "Enter the codes separated by a new line and finish the list with an asterisk.");

        while(continueAskingForInput) {
            String cmdInput = scanner.next();

            if (cmdInput.equals("*")) {
                scanner.close();
                System.out.println("Thank you. Your receipt is as follows:\n");
                System.out.println(till.getReceipt());
                continueAskingForInput = false;
            } else {
                till.scanItem(cmdInput);
            }
        }
    }
}