import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();

        bouquet.addFlower(new Rose());
        bouquet.addFlower(new Tulip());
        bouquet.addFlower(new Lily());
        bouquet.addFlower(new Peonies());
        bouquet.addFlower(new Lily());
        bouquet.addFlower(new Peonies());
        bouquet.addFlower(new Rose());

        bouquet.showBouquet();
    }
}


abstract class Flower {
    private String name;
    private int price;

    public Flower(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Rose extends Flower {
    public Rose() {
        super("Rose", 150);
    }
}

class Tulip extends Flower {
    public Tulip() {
        super("Tulip", 200);
    }
}

class Lily extends Flower {
    public Lily() {
        super("Lily", 100);
    }
}

class Peonies extends Flower {
    public Peonies() {
        super("Peonies", 400);
    }
}

class Bouquet {
    private List<Flower> flowers;

    public Bouquet() {
        this.flowers = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public int sumTotalBouquet() {
        int sum = 0;
        for (Flower flower : flowers) {
            sum += flower.getPrice();
        }
        return sum;
    }

    public void showBouquet() {
        for (Flower flower : flowers) {
            System.out.println("Flower name - " + flower.getName() + ": $ " + flower.getPrice());
        }
        System.out.println("Sum bouquet: " + sumTotalBouquet());
    }
}