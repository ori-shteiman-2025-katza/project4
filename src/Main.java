public class Main {
    public static void main(String[] args) {
        Store store = new Store("My Store", 3);

        Product p1 = new Product("Notebook", 12.5, 3);
        Product p2 = new Product("Pen", 4.0, 2);
        Product p3 = new Product("Bottle", 30.0, 0);

        boolean added1 = store.addProduct(p1);
        boolean added2 = store.addProduct(p2);
        boolean added3 = store.addProduct(p3);
        System.out.println("Added 3 products: " + added1 + ", " + added2 + ", " + added3);

        Product p4 = new Product("Eraser", 2.5, 10);
        boolean added4 = store.addProduct(p4);
        System.out.println("Added 4th product (should be false): " + added4);

        boolean sell1 = store.sellProduct(p1.getId(), 2);
        System.out.println("Sold 2 Notebooks: " + sell1);

        boolean sell2 = store.sellProduct(p2.getId(), 3);
        System.out.println("Sold 3 Pens (should be false): " + sell2);

        boolean sell3 = store.sellProduct(p2.getId(), 2);
        System.out.println("Sold 2 Pens: " + sell3);

        boolean priceChanged = p1.setPrice(-5);
        System.out.println("Changed price to -5: " + priceChanged + ", current price: " + p1.getPrice());

        System.out.println("\nAvailable products:");
        store.printAvailableProducts();

        System.out.println("\nSales report:");
        store.printSalesReport();
        System.out.println("Total units sold: " + store.getTotalUnitsSold());

        System.out.println("\nProduct IDs:");
        System.out.println(p1.getName() + " ID: " + p1.getId());
        System.out.println(p2.getName() + " ID: " + p2.getId());
        System.out.println(p3.getName() + " ID: " + p3.getId());
        System.out.println(p4.getName() + " ID: " + p4.getId());
        System.out.println("Next ID: " + Product.getNextId());
    }
}