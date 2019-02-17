package pack.pb;

import pack.pb.entity.PhoneBook;
import pack.pb.entity.implementation.PhoneBookImpl;

import java.util.Scanner;

public class PbApp {

    public static void main( String[] args ) {
        System.out.println( System.getProperty("file.encoding"));
        PhoneBook pb = PhoneBookImpl.getInstance();

        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Введите ФИО: ");
        String fullName = scanner.nextLine();


        try{
            pb.printPhoneBookItem(fullName);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
