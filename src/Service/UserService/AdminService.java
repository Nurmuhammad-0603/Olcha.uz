package Service.UserService;
import Service.Service;
import db.ProductDb;
import db.UserDb;
import enums.Role;
import model.Product;
import model.User;

import java.time.LocalDate;
import java.util.Scanner;



public class AdminService implements Service {
    static Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        System.out.println("1.Product qoshish");
        System.out.println("2.Product ochirish");
        System.out.println("3.Product ozgartirish");
        System.out.println("4.Product royxati");
        System.out.println("5.Productlarga chegirma");
        System.out.println("6.User royxati");
        System.out.println("7.Admin royxati");
        System.out.println("8.Admin qoshish");
        System.out.println("9.Admin ochirish");
        System.out.println("Tanlang:");
        int i = scanner.nextInt();
        switch (i){
            case 1 ->addProduct();
            case 2 ->deleteProduct();
            case 3 ->editProduct();
            case 4 ->royxatProduct();
            case 5 ->chegirma();
            case 6 ->royxatUser();
            case 7 ->royxatAdmin();
            case 8 ->addAdmin();
            case 9 ->deleteAdmin();
        }
    }

    private void deleteAdmin() {
        royxatAdmin();
        System.out.println("Qaysi indexdagi Admini ochirmoqchisiz?");
        int i = scanner.nextInt();
        ProductDb.deleteProduct(i);
    }

    private void addAdmin() {
        System.out.println("Ism kiriting:");
        String name = scanner.next();
        System.out.println("Familiya kiriting:");
        String familya = scanner.next();
        System.out.println("Telefon raqam kiriting:");
        String  nomer = scanner.next();
        System.out.println("Parol kiriting:");
        String parol = scanner.next();
        if (parol.length() < 8){
            System.out.println("Parol 8dan katta va 16dan kichik bolish kerak");
        }
        User user = new User(name,familya,parol,nomer,Role.ADMIN);
        User[] users = UserDb.getUsers().toArray(new User[0]);
        for (int i = 0; i < users.length; i++) {
            if (users[i]==null){
                users[i] = user;
                System.out.println("Admin qoshildi !!!");
                run();
                return;
            }
        }
        System.out.println("Admin qoshilmadi");
        addAdmin();
    }

    private void royxatAdmin() {
        UserDb.getAdmin();
    }

    private void royxatUser() {
        UserDb.getUsers();
    }

    private void chegirma() {
        for (Product product : ProductDb.getProducts()) {
            if (product.isChegirma()==true){
                System.out.println(product.getName()+" "+product.getPrise()+" "+product.getChegira_prise());
            }
        }

    }

    private void royxatProduct() {
        ProductDb.getProducts();
    }

    private void editProduct() {
        ProductDb.getProducts();
        System.out.println("Qaysi index?");
        int index = scanner.nextInt();
        System.out.println("Nimani ozgartirmoqchisan(1.Name 2.Time)?");
        int edit = scanner.nextInt();
          if (edit == 1){
              System.out.println("Nameni kirit:");
              String name = scanner.next();
              ProductDb.getProducts().get(index-1).setName(name);
          }else {
              System.out.println("Yilni kirit:");
              int year = scanner.nextInt();
              System.out.println("Oyni kirit:");
              int month = scanner.nextInt();
              System.out.println("Kuni kirit:");
              int day = scanner.nextInt();
              LocalDate date = LocalDate.of(year,month,day);
              ProductDb.getProducts().get(index-1).setDate(date);
          }
    }

    private void deleteProduct() {
        royxatProduct();
        System.out.println("Qaysi index?");
        int i = scanner.nextInt();
        ProductDb.deleteProduct(i-1);
    }

    private void addProduct() {
        System.out.println("Product nomi:");
        String name = scanner.next();
        System.out.println("Yilni kirit:");
        int year = scanner.nextInt();
        System.out.println("Oyni kirit:");
        int month = scanner.nextInt();
        System.out.println("Kuni kirit:");
        int day = scanner.nextInt();
        LocalDate date = LocalDate.of(year,month,day);
        System.out.println("Narxini kirit:");
        double prise = scanner.nextInt();
        System.out.println("Chegirmadami?");
        boolean ischeg = scanner.hasNext();
        System.out.println("Chegirma narxi:");
        double cher_prise =scanner.nextInt();
        Product product = new Product(name,date,prise,ischeg,cher_prise);

    }
}
