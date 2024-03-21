package Service.UserService;

import Service.Service;
import db.ProductDb;
import model.Product;

import java.util.Scanner;

public class UserService implements Service {
    public static Scanner scanner = new Scanner(System.in);
    @Override
    public  void run() {
        System.out.println("1.Productlarni royxati");
        System.out.println("2.Product savatga qoshish");
        System.out.println("3.Product sotib olish");
        System.out.println("4.Savatni tozalash");
        System.out.println("Tanlang:");
        int i = scanner.nextInt();
        switch (i){
            case 1 ->productDb();
            case 2 ->addProduct();
            case 3 ->buyProduct();
            case 4 ->removeProduct();
            default -> System.out.println("Noto'ri tanlov");
        }
    }

    private void buyProduct() {

    }

    private void removeProduct() {
        System.out.println("Nechinchi indexdagini ochirmoqchisiz:");
        int i = scanner.nextInt();
        ProductDb.deleteProduct(i);
    }

    private void addProduct() {
//      productDb();
//        System.out.println("Qaysi productni savatga qoshmoqchisiz:");
//        String i= scanner.next();
//          ProductDb.getProducts().add(i);
//        ProductDb.addProducts();
    }

    private void productDb() {
        ProductDb.getProducts();
    }
}
