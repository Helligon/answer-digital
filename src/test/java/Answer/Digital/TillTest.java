package Answer.Digital;

import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class TillTest {

    @Test
    public void scanItemForKnownItem() throws IOException {
        Store store = new Store();
        store.fileParse("sku-list-happy-test.txt");
        Till till = store.createTill();

        till.scanItem("T1");

        Sku testSku = new Sku("T1", "Test item 1", new BigDecimal(1.23).setScale(2, RoundingMode.HALF_UP));

        assertTrue(till.getReceipt().contains(testSku));
    }

    @Test
    public void scanItemForUnknownItem() throws IOException {
        Store store = new Store();
        store.fileParse("sku-list-happy-test.txt");
        Till till = store.createTill();

        till.scanItem("T0");

        assertTrue(till.getReceipt().isEmpty());
    }

    //new till has empty basket
    @Test
    public void getReceiptForNewTillHasEmptyBasket() throws IOException {
        Store store = new Store();
        store.fileParse("sku-list-happy-test.txt");
        Till till = store.createTill();

        assertTrue(till.getReceipt().isEmpty());
    }
}