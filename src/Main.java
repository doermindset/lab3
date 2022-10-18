import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product(10, 20, 5, 5);
        Product product2 = new Product(10, 10, 10, 10);
        Product product3 = new Product(40, 20, 30, 20);

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Controller controller = new Controller(products);

        controller.printProducts();
        controller.sortByDemand();
        System.out.println("Sorted by demand: ");
        controller.printProducts();
        controller.checkDemand();


    }
}