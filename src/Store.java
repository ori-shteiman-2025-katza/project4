public class Store {
    private String storeName;
    private Product[] products;
    private int[] soldCount;
    private int productCount;

    public Store(String storeName, int capacity) {
        this.storeName = storeName;
        this.products = new Product[capacity];
        this.soldCount = new int[capacity];
        this.productCount = 0;
    }

    public boolean addProduct(Product product) {
        if (product == null) {
            return false;
        }
        if (productCount == products.length) {
            return false;
        }
        if (findProductIndex(product.getId()) != -1) {
            return false;
        }

        products[productCount] = product;
        soldCount[productCount] = 0;
        productCount++;
        return true;
    }

    public int findProductIndex(int id) {
        int i = 0;
        int foundIndex = -1;
        while (i < productCount) {
            if (products[i].getId() == id) {
                foundIndex = i;
                break;
            }
            i++;
        }
        return foundIndex;
    }

    public boolean sellProduct(int id, int quantity) {
        int index = findProductIndex(id);
        if (index != -1) {
            boolean success = products[index].sell(quantity);
            if (success) {
                soldCount[index] = soldCount[index] + quantity;
                return true;
            }
        }
        return false;
    }

    public void printAvailableProducts() {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getStock() == 0) {
                continue;
            }
            System.out.println(products[i].getInfo());
        }
    }

    public void printSalesReport() {
        System.out.println("Store: " + storeName);
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getName() + ": " + soldCount[i]);
        }
    }

    public int getTotalUnitsSold() {
        int sum = 0;
        for (int i = 0; i < productCount; i++) {
            sum = sum + soldCount[i];
        }
        return sum;
    }
}