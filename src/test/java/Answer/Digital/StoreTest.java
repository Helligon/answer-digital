package Answer.Digital;

import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StoreTest {

    private Store store = new Store();

    @Test
    public void fileParseWorksWithACorrectTestFile() throws IOException {
        store.fileParse("sku-list-happy-test.txt");

        List<Sku> skuTest = new ArrayList<>();
        skuTest.add(Sku.lineParse("T1\tTest item 1\t1.23"));
        skuTest.add(Sku.lineParse("T2\tTest item 2\t4.56"));
        skuTest.add(Sku.lineParse("T3\tTest item 3\t7.89"));

        assertEquals(skuTest, store.getSkuList());
    }

    @Test (expected = IndexOutOfBoundsException.class) //because it cant create an ArrayList of size 0
    public void fileParsesThrowsErrorForEmptyFile() throws IOException {
        store.fileParse("empty.txt");
    }

    @Test
    public void findItemGetsCorrectItem() throws IOException {
        store.fileParse("sku-list-happy-test.txt");

        Sku testSku = new Sku("T1", "Test item 1", new BigDecimal(1.23).setScale(2, RoundingMode.HALF_UP));

        assertEquals(store.findItem("T1"), testSku);
    }

    @Test
    public void findItemReturnsNullIfItemNotFound() throws IOException {
        store.fileParse("sku-list-happy-test.txt");

        assertNull(store.findItem("item that isn't in list"));
    }
}