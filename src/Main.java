import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Product1", 10, 20, 5, 5);
        Product product2 = new Product("Product2", 10, 10, 10, 10);
        Product product3 = new Product("Product3",40, 20, 30, 20);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Controller controller = new Controller(products);

        controller.printProductsSpecs();
        controller.sortByDemand();
        System.out.println("Sorted by demand: ");
        controller.printProducts();
        controller.checkDemand();
        controller.getOptimalProduction();


    }
}