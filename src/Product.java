public class Product {
    private static int nextId = 1;
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.id = nextId;
        nextId++;

        if (name == null || name.trim().equals("")) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }

        if (price <= 0) {
            this.price = 1.0;
        } else {
            this.price = price;
        }

        if (stock < 0) {
            this.stock = 0;
        } else {
            this.stock = stock;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean setName(String name) {
        if (name != null && !name.trim().equals("")) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    public boolean setPrice(double price) {
        if (price > 0) {
            this.price = price;
            return true;
        } else {
            return false;
        }
    }

    public boolean setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
            return true;
        } else {
            return false;
        }
    }

    public boolean sell(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock = stock - quantity;
            return true;
        } else {
            return false;
        }
    }

    public String getInfo() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price + ", Stock: " + stock;
    }

    public static int getNextId() {
        return nextId;
    }
}