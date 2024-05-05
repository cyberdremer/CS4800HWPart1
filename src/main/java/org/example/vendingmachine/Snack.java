package VendingMachine;

public class Snack {
    private String name;
    private int price;
    private int quantity;

    Snack(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return "VendingMachine.Snack{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
