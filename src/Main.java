import Service.UserService.AdminService;
import db.UserDb;
import enums.Role;
import model.User;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static final String args[] = {"string","Strings"};
    static final Scanner scanner = new Scanner(System.in);
   static final UserDb admin = new UserDb();
   static {
       final User Admin = new User("Admin","Adminov","07110711","998",Role.ADMIN);
   }
    public static void main(String[] args) {
            try{
                System.out.println("Olcha.uzga hush kelibsiz");
                System.out.println("1.Login");
                System.out.println("2.Register");
                System.out.println("3.Exit");
                System.out.println("Tanlang:");
                int i = scanner.nextInt();
                switch (i){
                    case 1->login();
                    case 2->register();
                    case 3-> {
                        return;
                    }
                    default -> System.out.println("Noto'ri tanlov");
            }
        } catch (Exception e) {
                e.getMessage();
            }
    }

    private static void register() {
        System.out.println("Ismingizni kiriting:");
        String name = scanner.next();
        System.out.println("Familiyangizni kiriting:");
        String familya = scanner.next();
        System.out.println("Telefon raqamingizni kiriting:");
        String  nomer = scanner.next();
        System.out.println("Parol kiriting:");
        String parol = scanner.next();
        System.out.println("Admin yoki user");
        Role role = Role.valueOf(scanner.next());
        if (parol.length() < 8){
            System.out.println("Parol 8dan katta va 16dan kichik bolish kerak");
        }
        User user = new User(name,familya,parol,nomer,role);
        User[] users = UserDb.getUsers().toArray(new User[0]);
        for (int i = 0; i < users.length; i++) {
            if (users[i]==null){
                users[i] = user;
                System.out.println("Ro'yxatdan o'tdingiz !");
                main(args);
                return;
            }
        }
        System.out.println("Bazi sabablarga ko'ra qo'shilmadi");
        register();
    }

    private static void login() {
        System.out.print("Nomer kirit :");
        String nomers = scanner.next();
        System.out.print("password kirit :");
        String passwords = scanner.next();
        User[] users = UserDb.getUsers().toArray(new User[0]);
        for (User user : users) {
            if (UserDb.getUsers() != null && User.getNomer().equals(nomers) &&
                    User.getPswd().equals(passwords)){
                return;

            }
        }
        System.out.println("Bunaqa foydalnauvchi topilmadi");
    }


}


//olcha.uz
//
//model.User role (admin,user)
//
//Admin
//* product qoshish, ochirish,edit qilish va list
//* user va adminlarni list
//* mahsulotlarga chegirma qoyish,edit,ochirish,list
//* admin qoshih,edit,ochirish,list
//
//model.User
//* liked product list
//* productlarni list
//* productlarni sotib olishi (savatga qoshihs
//* savatni boshatish yani sotib olish, savatni tozalash
//
//Product
//name
//chiqqan vaqt
//-
//-
//-
//-
//
//
//Ishlatish kerak
//Shart: Encapsulation, object, class, togri class va methodlarga ajratgan holda yozish, Enum, Collection (hohlagan turi), Git, Time classlari, Exception
//
//Hohishiy, Inhertance, Abstraction va polymorephism