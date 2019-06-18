package Answer.Digital;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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

    public static Sku lineParse(String inputText) {
        String[] skuParts = inputText.split("\t");
        return new Sku(skuParts[0], skuParts[1], new BigDecimal(skuParts[2]).setScale(2, RoundingMode.HALF_UP));
    }

//    public static ArrayList fileParse(String inputFile) throws IOException {
//            List<Sku> skuList = new ArrayList<>();
//        List<String> list = Files.readAllLines(Paths.get(inputFile), StandardCharsets.UTF_8);
//        list.remove(0);
//        for (int i = 0; i <= list.size(); i++) {
//            skuList.add(lineParse(list.get(i)));
//        }
//        return skuList;
//    }

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
