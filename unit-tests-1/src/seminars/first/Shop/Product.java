package seminars.first.Shop;


public class Product implements Comparable<Product> {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title +
                "\', cost=" + cost +
                '}';
    }

    public Product(String title, Integer cost) {
        this.title = title;
        this.cost = cost;
    }


    // Геттеры, сеттеры:

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int compareTo(Product o) {
        if (o == this) return 0;
        if (o.getCost() < this.cost) return 1;
        if (o.getCost() > this.cost) return -1;
        return 0;
    }

    @Override
    public Product clone() {
        return new Product(this.title, this.cost);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass().isInstance(this)) {
            Product p = (Product) obj;
            return p.getCost() == cost && (p.getTitle()).equals(title);
        }
        return false;
    }


}