package seminars.first.Shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
       List<Product> productList = new ArrayList<>();//новый пустой список
        for (Product p: products             ) {
            productList.add(p.clone());//создаем копию элементов списка через clone()
        }
        Collections.sort(productList); //сортируем коллекцию
        return productList;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        if(products.isEmpty())return null;
        Product bigCostProduct = products.get(0);
        for (Product p:products            ) {
            if(p.compareTo(bigCostProduct)>0)bigCostProduct=p;
        }
        return bigCostProduct;
    }

}