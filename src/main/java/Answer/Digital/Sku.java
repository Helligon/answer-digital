package Answer.Digital;

import java.math.BigDecimal;
import java.util.Objects;

public class Sku {
    private String productCode;
    private String description;
    private BigDecimal price;

    public Sku(String productCode, String description, BigDecimal price) {
        this.productCode = productCode;
        this.description = description;
        this.price = price;
    }

    public static Sku lineParser(String inputText) {
        String[] skuParts = inputText.split("\t");
        return new Sku(skuParts[0], skuParts[1], new BigDecimal(skuParts[2]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sku sku = (Sku) o;
        return Objects.equals(productCode, sku.productCode) &&
                Objects.equals(description, sku.description) &&
                Objects.equals(price, sku.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, description, price);
    }

    @Override
    public String toString() {
        return "Sku{" +
                "productCode='" + productCode + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
