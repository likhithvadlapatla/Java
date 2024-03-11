import java.util.Scanner;

public class RestaurantOrderProgram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the items list : ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] items = new String[n];
        double[] itemCosts = new double[n];

        for (int i = 0; i < items.length; i++) {
            System.out.println("Enter the items in the restaurant : ");
            items[i] = scanner.nextLine();
            System.out.println("Enter the cost of " + items[i] + ":");
            itemCosts[i] = scanner.nextDouble();
            scanner.nextLine();
        }
        System.out.println(items[0]);
        // Order details
        int tableNo, orderNo;
        String itemsOrdered = "";
        double sumOfOrderedItems = 0.0;
        double taxRate = 0.1; // 10% tax rate

        // Input
        System.out.println("Enter Table Number:");
        tableNo = scanner.nextInt();

        System.out.println("Enter Order Number:");
        orderNo = scanner.nextInt();

        System.out.println("Available Items:");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i] + " - Rs " + itemCosts[i]);
        }

        System.out.println("Enter item numbers to order (separated by commas):");
        String[] selectedItems = scanner.next().split(",");

        for (String selectedItem : selectedItems) {
            int itemIndex = Integer.parseInt(selectedItem) - 1;
            itemsOrdered += items[itemIndex] + "\tRs " + itemCosts[itemIndex] + "\n";
            sumOfOrderedItems += itemCosts[itemIndex];
        }

        double totalBill = sumOfOrderedItems + (sumOfOrderedItems * taxRate);

        System.out.println("\nOrder Details:");
        System.out.println("Table No: " + tableNo);
        System.out.println("Order No: " + orderNo);
        System.out.println("Items Ordered:");
        System.out.println("Item Name\tItem Amount");
        System.out.println(itemsOrdered);
        System.out.println("Sum of Ordered items: Rs" + sumOfOrderedItems);
        System.out.println("Tax rate: " + (taxRate * 100) + "%");
        System.out.println("Total Bill: Rs" + totalBill);

        scanner.close();
    }
}
