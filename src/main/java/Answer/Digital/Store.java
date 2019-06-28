package Answer.Digital;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static Answer.Digital.Sku.lineParse;

public class Store {
    private List<Sku> skuList = new ArrayList<>();

    public void fileParse(String filename) throws IOException {
        File file = new File(
                Objects.requireNonNull(getClass().getClassLoader().getResource(filename)).getFile()
        );
        List<String> listOfLines = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        listOfLines.remove(0);

        for (String line : listOfLines) {
            skuList.add(lineParse(line));
        }
    }

    public List<Sku> getSkuList() {
        return skuList;
    }


    public Sku findItem(String productCode) {
        for (Sku sku : skuList) {
            if (sku.getProductCode().equals(productCode)) {
                return sku;
            }
        }
        return null;
    }

    public Till createTill() {
        return new Till(this);
    }
}
