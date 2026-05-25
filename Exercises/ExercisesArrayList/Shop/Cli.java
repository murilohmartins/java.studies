package ExercisesArrayList.Shop;
import java.util.Scanner;

public class Cli {

    private static void menuChoices() {
        System.out.println("1- Add a product to the shop ");
        System.out.println("2- Increase stock ");
        System.out.println("3- Decrease stock ");
        System.out.println("4- Update a price ");
        System.out.println("5- Deactivate a product ");
        System.out.println("6- Activate a product ");
        System.out.println("7- See all products available ");
    }

    private static void errorInfo(){
        System.out.println("Be sure to fulfill each blank properly");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShopSystem system = new ShopSystem();

        System.out.println("----Welcome to our shop----");
        menuChoices();

        while (true) {
            System.out.println("0- See again all options");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    try {
                        System.out.print("What the name of the product you want to add? ");
                        String name = scanner.nextLine().trim();
                        System.out.print("What will be it price? ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("How much of it will be on stock? ");
                        int stock = Integer.parseInt(scanner.nextLine());
                        if (!name.isBlank() && price > 0 && stock >= 0) {
                            system.addProduct(name, price, stock);
                        } else {
                            errorInfo();
                    } }catch (NumberFormatException e){
                        System.out.println("Invalid number");
                    }
                    break;
                case "2":
                    try{
                        System.out.print("What the name of the product you want to increase? ");
                        String increaseStockname = scanner.nextLine().trim();
                        System.out.print("What will be the increase? ");
                        int increaseStockInt = Integer.parseInt(scanner.nextLine());
                        if (!increaseStockname.isBlank() && increaseStockInt>0){
                            system.increaseStockBy(increaseStockname,increaseStockInt);
                        }else {
                            errorInfo();
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Invalid number");
                    }
                    break;
                case "3":
                    try {
                        System.out.print("What the name of the product you want to decrease? ");
                        String decreaseStockName = scanner.nextLine().trim();
                        System.out.print("What will be the decrease? ");
                        int decreaseStockInt = Integer.parseInt(scanner.nextLine());
                        if (!decreaseStockName.isBlank() && decreaseStockInt>0){
                            try {
                                system.decreaseStockBy(decreaseStockName,decreaseStockInt);
                            } catch (IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }
                        }else {
                            errorInfo();
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Invalid number");
                    }
                    break;
                case "4":
                    try{
                        System.out.print("What is the name of the product you want to change its price? ");
                        String changeName = scanner.nextLine().trim();
                        System.out.print("What will be the new price of this product? ");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        if (!changeName.isBlank() && newPrice>0){
                            system.updatePrice(changeName,newPrice);
                        }else {
                            errorInfo();
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Invalid number");
                    }
                    break;
                case "5":
                    System.out.print("What is the name of the product you want to deactivate? ");
                    String deactivateName = scanner.nextLine();
                    if (!deactivateName.isBlank()) {
                        system.deactivateProduct(deactivateName);
                    }else {
                        errorInfo();
                    }
                    break;
                case "6":
                    System.out.print("What is the name of the product you want to activate? ");
                    String activateName = scanner.nextLine();
                    if (!activateName.isBlank()) {
                        system.activateProduct(activateName);
                    }else {
                        errorInfo();
                    }
                    break;
                case "7":
                    system.printAllProducts();
                    break;
                case "0":
                    menuChoices();
                    break;
                default:
                    System.out.print("Seeya");
                    return;
            }
        }
    }
}