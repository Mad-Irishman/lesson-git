import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(600);

        Product laptop = new Electronics("Laptop", 2.5);
        Product chair = new Furniture("Chair", 5.2);
        Product apple = new Food("Apple", 0.2);
        Product jeans = new Clothing("Jeans", 1.0);
        Product closet = new Furniture("Closet", 124.6);
        Product fridge = new Electronics("Fridge", 452.8);

        warehouse.addProduct(laptop);
        warehouse.addProduct(chair);
        warehouse.addProduct(apple);
        warehouse.addProduct(jeans);
        warehouse.addProduct(closet);
        warehouse.addProduct(fridge);

        warehouse.showWarehouse();
    }
}


abstract class Product {
    private String name;
    private double weight;

    public Product(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}


class Food extends Product {
    public Food(String name, double weight) {
        super(name, weight);
    }
}

class Electronics extends Product {
    public Electronics(String name, double weight) {
        super(name, weight);
    }
}

class Furniture extends Product {
    public Furniture(String name, double weight) {
        super(name, weight);
    }
}

class Clothing extends Product {
    public Clothing(String name, double weight) {
        super(name, weight);
    }
}

class Warehouse {
    private List<Product> products;
    private double capacity;
    private double currentWeight;

    public Warehouse(double capacity) {
        this.capacity = capacity;
        this.products = new ArrayList<>();
        this.currentWeight = 0.0;
    }

    public boolean addProduct(Product product) {
        if (currentWeight + product.getWeight() <= capacity) {
            products.add(product);
            currentWeight += product.getWeight();
            return true;
        } else {
            System.out.println("Cannot add product");
            return false;
        }
    }

    public double sumtotalWeight() {
        return currentWeight;
    }

    public void showWarehouse() {
        for (Product product : products) {
            System.out.println(product.getName() + ": " + product.getWeight());
        }
        System.out.println("Total weight:" + sumtotalWeight());
        System.out.println("Capacity:" + capacity);
    }
}