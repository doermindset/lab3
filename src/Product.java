public class Product {

    private String name;
    private int producedThisYear;
    private int producedLastYear;
    private int soldThisYear;
    private int soldLastYear;

    public Product(String name, int producedThisYear, int producedLastYear, int soldThisYear, int soldLastYear) {
        this.name = name;
        this.producedThisYear = producedThisYear;
        this.producedLastYear = producedLastYear;
        this.soldThisYear = soldThisYear;
        this.soldLastYear = soldLastYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProducedThisYear() {
        return producedThisYear;
    }

    public void setProducedThisYear(int producedThisYear) {
        this.producedThisYear = producedThisYear;
    }

    public int getProducedLastYear() {
        return producedLastYear;
    }

    public void setProducedLastYear(int producedLastYear) {
        this.producedLastYear = producedLastYear;
    }

    public int getSoldThisYear() {
        return soldThisYear;
    }

    public void setSoldThisYear(int soldThisYear) {
        this.soldThisYear = soldThisYear;
    }

    public int getSoldLastYear() {
        return soldLastYear;
    }

    public void setSoldLastYear(int soldLastYear) {
        this.soldLastYear = soldLastYear;
    }

    public float getDemand(int sold, int produced) {
        return (float) sold/produced*100;
    }

}
