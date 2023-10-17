package seminars.first.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminars.first.Shop.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {

    @Test
    public void testCompareTo() {
        Product product1 = new Product("Название", 100);
        Product product2 = new Product("Название", 200);
        Product product3 = new Product("Название", 300);
        Product product4 = new Product("Название", 200);


        assertEquals(-1,product1.compareTo(product2));
        assertEquals(1,product3.compareTo(product2));
        assertEquals(0,product2.compareTo(product2));
    }

    @Test
    public void testClone(){
        Product product1 = new Product("Название", 100);
        Product product2 = product1.clone();
        assertTrue(product1.equals(product2));
    };

@Test
    public void testEquals(){
    Product product1 = new Product("Название", 100);
    Product product2 = new Product("Название", 100);

    assertTrue(product1.equals(product2));

    product2 = new Product("Название1", 100);
    assertTrue(!product1.equals(product2));

    product2 = new Product("Название", 200);
    assertTrue(!product1.equals(product2));
}


}
