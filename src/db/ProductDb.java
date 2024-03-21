package db;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDb {
    private static List<Product> products = new ArrayList<>();

    public static List<Product> getProducts() {
        return products;
    }
    public static void  addProducts(Product product){
        products.add(product);
    }
    public static void deleteProduct(int i){
        if (i < 0 || i >= products.size()){
            System.out.println("Chegaradan oship keti");
            return;
        }
        products.remove(i);
    }

}
