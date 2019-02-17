package pack.pb.entity.implementation;

import pack.pb.entity.PhoneBook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pack.pb.utils.ErrorMessages.*;

public class PhoneBookImpl implements PhoneBook {
    private Map<String, List<String>> book;

    private static PhoneBookImpl phoneBookImpl = new PhoneBookImpl();

    private PhoneBookImpl() {
        book = new HashMap<>();
        book.put("Иванов И.И.", Arrays.asList("+8 800 2000 500", "+8 800 200 600"));
        book.put("Петров П.П.", Arrays.asList("+8 800 2000 700"));
        book.put("Сидоров С.С.", Arrays.asList("+8 800 2000 800", "+8 800 2000 900", "+8 800 2000 000"));
    }

    public static PhoneBookImpl getInstance() {
        return phoneBookImpl;
    }

    StringBuilder pnoneBookItemToStringBuilder(String fullName){
        if (book.containsKey(fullName)) {
            int[] idx = { 0 };
            StringBuilder str = new StringBuilder();
            book.get(fullName).stream().forEachOrdered(item -> str.append(++idx[0]).append(". ").append(item).append("\n"));
            return str;
        }
        else throw new IllegalArgumentException(ITEM_NOT_FOUND);
    }

    @Override
    public void printPhoneBookItem(String fullName) {
        System.out.println(pnoneBookItemToStringBuilder(fullName));
    }
}
