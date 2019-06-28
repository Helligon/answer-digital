package Answer.Digital;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class SkuTest {

    @Test
    public void hashCodeCreatesEqualHashesForSameObject() {
        Sku sku1 = new Sku("H67", "beans", new BigDecimal(0.55));
        Sku sku2 = new Sku("H67", "beans", new BigDecimal(0.55));

        assertEquals(sku1.hashCode(), sku2.hashCode());
    }

    @Test
    public void hashCodeCreatesDifferentHashesForDifferentObjects() {
        Sku sku1 = new Sku("H67", "beans", new BigDecimal(0.55));
        Sku sku2 = new Sku("J660", "bread", new BigDecimal(1.10));

        assertNotEquals(sku1.hashCode(), sku2.hashCode());
    }

    @Test
    public void equalsMatchesObjectsWithEqualValues() {
        Sku sku1 = new Sku("H67", "beans", new BigDecimal(0.55));
        Sku sku2 = new Sku("H67", "beans", new BigDecimal(0.55));

        assertTrue(sku1.equals(sku2));
    }

    @Test
    public void equalsDoesNotMatchObjectsWithDifferentValues() {
        Sku sku1 = new Sku("H67", "beans", new BigDecimal(0.55));
        Sku sku2 = new Sku("J660", "bread", new BigDecimal(1.10));

        assertFalse(sku1.equals(sku2));
    }

    @Test
    public void toStringUsesAllMembers() {
        Sku sku = new Sku("H67",
                "beans", new BigDecimal(0.55).setScale(2, RoundingMode.HALF_UP));

        assertEquals(sku.toString(), "\nSku{productCode='H67', description='beans', price=0.55}");
    }

    @Test
    public void parsesLineCorrectly() {
        Sku sku1 = new Sku("H67",
                "beans", new BigDecimal(0.55).setScale(2, RoundingMode.HALF_UP));

        Sku sku2 = Sku.lineParse("H67\tbeans\t0.55");

        assertEquals(sku1, sku2);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void incompleteInput() {
        Sku.lineParse("H67\tbeans");
    }

    @Test (expected = NumberFormatException.class)
    public void invalidPriceForBigDecimal() {
        Sku.lineParse("H67\tbeans\t55p");
    }
}