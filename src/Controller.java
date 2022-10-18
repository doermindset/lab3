import java.util.ArrayList;
import java.util.Comparator;

public class Controller {

    private ArrayList<Product> products;

    public Controller(ArrayList<Product> products) {
        this.products = products;
    }

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

    public void printStatus(int status, String productName){
        if(status == 1) {
            System.out.println("For " + productName + " demand is decreasing");
        }
        else {
            if (status == 2) {
                System.out.println("For " + productName +" demand is rising");
            }
            else {
                if (status == 3) {
                    System.out.println("For " + productName +" demand is the same");
                }
                else {
                    System.out.println("Error");
                }

            }
        }
    }
    public float averageDemand(Product product) {
        float sumDemand = product.getDemand(product.getSoldThisYear(), product.getProducedThisYear()) + product.getDemand(product.getSoldLastYear(), product.getProducedLastYear());
        return sumDemand / 2;
    }


    public void sortByDemand() {
        products.sort(Comparator.comparing(this::averageDemand));
    }

    public void printProductsSpecs() {
        for(Product product : products){
            System.out.println(product.getName());
            System.out.println("This year demand: "+ product.getDemand(product.getSoldThisYear(), product.getProducedThisYear()) + "%");
            System.out.println("Last year demand: "+ product.getDemand(product.getSoldLastYear(), product.getProducedLastYear()) + "%");
            System.out.println("Average demand: " + averageDemand(product) + "%");
        }
    }

    public void printProducts() {
        for(Product product : products){
            System.out.println(product.getName());
        }
    }

    public void checkDemand() {
        for(Product product : products){
            int status = getStatus(product);
            printStatus(status, product.getName());
        }
    }

    public void getOptimalProduction(){
        for(Product product : products){
            int status = getStatus(product);
            int optimalNumber = optimalProduction(status, product);
            printOptimalProduction(optimalNumber, product);
        }
    }

    public int optimalProduction(int status, Product product) {
        if(status == 1)
            return  (int) (product.getSoldLastYear() * 1.5);
        if (status == 2)
            return  (int) (product.getSoldLastYear() * 0.9);
        return (int)(product.getSoldLastYear() * 1.1);
    }

    public void printOptimalProduction(int num, Product product){
        System.out.println("For "+ product.getName() + " the optimal number of products for the next year is: " + num);
    }



}
