package ExercisesArrayList.Shop;

public class Products{
    private String name;
    private double price;
    private int stock;
    private boolean active;

    public Products(String name, double price, int stock) {

        if(price <= 0 || stock < 0 || name.isBlank()) {
            throw new IllegalArgumentException("Invalid product");
        }

        this.name = name;
        this.price = price;
        this.stock = stock;
        this.active = true;
    }

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public boolean isActive(){
        return active;
    }

    public void setName(String name){
        if (name.isBlank()){
            throw new IllegalArgumentException("Be sure to enter a name");
        }else {
            this.name = name;
        }
    }
    public void setPrice(double price){
        if (price<=0){
            throw new IllegalArgumentException("Be sure to put an positive amount");
        }else {
            this.price= price;
        }
    }
    public void activate(){
        if (this.active){
            throw new IllegalArgumentException("Product already activate");
        }else {
            active = true;
        }
    }
    public void deactivate(){
        if (this.active) {
            active = false;
        } else{
            throw new IllegalArgumentException("Product already deactivate");
        }
    }

    public void increaseStock(int amount){

        if(amount <= 0){
            throw new IllegalArgumentException("Invalid amount");
        }

        this.stock += amount;
    }

    public void decreaseStock(int amount){
        if (amount<= 0){
            throw new IllegalArgumentException("Invalid amount");
        }

        if (amount>this.stock){
            throw new IllegalArgumentException("Invalid amount");
        }
        this.stock -= amount;
    }

}