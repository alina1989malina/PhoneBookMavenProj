package pack.pb.entity.implementation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pack.pb.utils.ErrorMessages.ITEM_NOT_FOUND;
import org.junit.jupiter.api.Test;


public class PhoneBookImplTest {
    private PhoneBookImpl pb = PhoneBookImpl.getInstance();

    @Test
    public void testItem1() {
        String item = "1. +8 800 2000 500\n2. +8 800 200 600\n";
        assertTrue(pb.pnoneBookItemToStringBuilder("Иванов И.И.").toString().equals(item));
    }

    @Test
    public void testItem2() {
        String item = "1. +8 800 2000 700\n";
        assertTrue(pb.pnoneBookItemToStringBuilder("Петров П.П.").toString().equals(item));
    }

    @Test
    public void testItem3() {
        String item = "1. +8 800 2000 800\n2. +8 800 2000 900\n3. +8 800 2000 000\n";
        assertTrue(pb.pnoneBookItemToStringBuilder("Сидоров С.С.").toString().equals(item));
    }

    @Test
    public void testItemAbsence() {
        assertThrows(IllegalArgumentException.class, () -> pb.pnoneBookItemToStringBuilder(null), ITEM_NOT_FOUND);
        assertThrows(IllegalArgumentException.class, () -> pb.pnoneBookItemToStringBuilder(""), ITEM_NOT_FOUND);
        assertThrows(IllegalArgumentException.class, () -> pb.pnoneBookItemToStringBuilder("Петро П.П."), ITEM_NOT_FOUND);
    }
}
