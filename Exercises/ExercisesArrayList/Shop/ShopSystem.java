package ExercisesArrayList.Shop;

import java.util.ArrayList;

public class ShopSystem {
    ArrayList<Products> products = new ArrayList<>();

    private Products findProductByName(String name){
        for (Products product: products){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public void addProduct(String name, double price, int stock) {
        if (price > 0 && stock >= 0 && !name.isBlank()) {
            Products product = findProductByName(name);
            if (product==null) {
                products.add(new Products(name, price, stock));
                System.out.println("Successfully added! ");
            } else {
                System.out.println("Theres already a product registered with same name");
            }
        } else {
            throw new IllegalArgumentException("Be sure to fulfill each blank properly");
        }
    }

    public void updatePrice(String name,double price){
        if (price>0 && !name.isBlank()) {
            Products product = findProductByName(name);
            if (product == null) {
                System.out.println("Unfortunately we couldnt find a product that matches this name");
            } else {
                product.setPrice(price);
                System.out.println("Successfully increased! New "+product.getName()+" price is "+product.getPrice());

            }
        }else {
        throw new IllegalArgumentException("Be sure to fulfill each blank properly");
        }

    }

    public void increaseStockBy(String name, int increase){
        if (!name.isBlank() && increase>0){
            Products product = findProductByName(name);
            if (product == null) {
                System.out.println("Unfortunately we coudlnt find a product that matches this name");
            } else {
                product.increaseStock(increase);
                System.out.println("Successfully increased, current amount of "+product.getName()+" is "+product.getStock());
            }
        }else {
            throw new IllegalArgumentException("Be sure to fulfill each blank properly");
        }
    }

    public void decreaseStockBy(String name, int decrease){
        if (!name.isBlank() && decrease>0){
            Products product = findProductByName(name);
            if (product == null){
                System.out.println("Unfortunately we coudlnt find a product that matches this name");
                return;
            }
            product.decreaseStock(decrease);
            System.out.println("Successfully decreased, current amount of "+product.getName()+" is "+product.getStock());
        }else {
            throw new IllegalArgumentException("Be sure to fulfill each blank properly");
        }

        }


    public void printAllProducts(){
        System.out.println("Currently we have the following active products on our store: ");
        for (Products product: products){
            if (product.isActive())
                System.out.println("product name: "+product.getName()+", price: "+product.getPrice()+", amount on stock: "+ product.getStock());
        }
    }

    public void deactivateProduct(String name){
        if (!name.isBlank()){
            Products product = findProductByName(name);
            if (product == null){
                System.out.println("Unfortunately we coudlnt find a product that matches this name");
                return;
            }
            product.deactivate();
            System.out.println(product.getName()+" successfully deactivated");
        }else {
            throw new IllegalArgumentException("Be sure to fulfill each blank properly");
        }
    }

    public void activateProduct(String name){
        if (!name.isBlank()){
            Products product = findProductByName(name);
            if (product==null){
                System.out.println("Unfortunately we coudlnt find a product that matches this name");
                return;
            }
            product.activate();
            System.out.println(product.getName()+" successfully activated");
        }else {
            throw new IllegalArgumentException("Be sure to fulfill each blank properly");
        }
    }
}