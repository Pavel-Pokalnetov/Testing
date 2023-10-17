package seminars.first.Tests;

import org.junit.jupiter.api.Test;
import seminars.first.Shop.Product;
import seminars.first.Shop.Shop;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    @Test
    void testGetMostExpensiveProduct() {
        List<Product> products = getProducts();
        Shop shop = getShop(products);
        assertTrue(shop.getMostExpensiveProduct().getCost()==500);

    }

    @Test
    void testSortProductsByPrice() {
        List<Product> products = getProducts();
        Shop shop = getShop(products);
        List<Product> products1 = shop.sortProductsByPrice();
        assertEquals(products1.size(), 10);
        assertTrue(products1.get(0).getCost() == 50);
        assertTrue(products1.get(3).getCost() == 200);
        assertTrue(products1.get(6).getCost() == 350);
        assertTrue(products1.get(9).getCost() == 500);


    }


    private static Shop getShop(List<Product> products) {
        Shop shop = new Shop();
        shop.setProducts(products);
        return shop;
    }

    private static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            Product p1 = new Product(String.format("Product %s", i), 100 * i / 2);
            products.add(p1);
        }
        return products;
    }
}