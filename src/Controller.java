import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {

    public Controller(ArrayList<Product> products) {
        this.products = products;
    }

    private ArrayList<Product> products = new ArrayList<Product>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getStatus(Product product){
        if(product.getDemand(product.getSoldLastYear(), product.getProducedLastYear()) > product.getDemand(product.getSoldThisYear(), product.getProducedThisYear()))
            return 1;
        if (product.getDemand(product.getSoldLastYear(), product.getProducedLastYear()) < product.getDemand(product.getSoldThisYear(), product.getProducedThisYear()))
            return 2;
        return 3;
    }

    public void printStatus(int status){
        if(status == 1) {
            System.out.println("Demand is decreasing");
        }
        else {
            if (status == 2) {
                System.out.println("Demand is rising");
            }
            else {
                if (status == 3) {
                    System.out.println("Demand is the same");
                }
                else {
                    System.out.println("Error");
                }

            }
        }
    }
    public float averageDemand(Product product) {
        float sumDemand1 = product.getDemand(product.getSoldThisYear(), product.getProducedThisYear()) + product.getDemand(product.getSoldLastYear(), product.getProducedLastYear());
        return sumDemand1 / 2;
    }


    public void sortByDemand() {
        products.sort(Comparator.comparing(this::averageDemand));
    }

    public void printProducts() {
        for(Product product : products){
            System.out.println(product);
        }
    }

    public void checkDemand() {
        for(Product product : products){
            int status = getStatus(product);
            printStatus(status);
        }
    }

    public void optimalProduction(int status, Product product) {
        int produceNext;
        if(status == 1) {
            produceNext = (int) (product.getSoldLastYear() * 1.5);
        } else if (status == 3) {
            produceNext = (int) (product.getSoldLastYear() * 1.1);
        }
        else {
            produceNext = (int) (product.getSoldLastYear() * 0.9);
        }
    }



}
