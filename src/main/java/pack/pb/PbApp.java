package pack.pb;

import pack.pb.entity.PhoneBook;
import pack.pb.entity.implementation.PhoneBookImpl;

import java.io.*;
import java.util.Scanner;

public class PbApp {

    public static void main( String[] args ) {
        PhoneBook pb = PhoneBookImpl.getInstance();

        Console c = System.console();
        System.out.println("Введите ФИО:");
        String fullName = c != null ? c.readLine("") :
                new Scanner(System.in, "UTF-8").nextLine();

        try{
            pb.printPhoneBookItem(fullName);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
