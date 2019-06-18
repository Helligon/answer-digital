package Answer.Digital;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static Answer.Digital.Sku.lineParse;

public class Store {
    private List<Sku> skuList = new ArrayList<>();


    public void fileParse(String inputFile) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(inputFile), StandardCharsets.UTF_8);
        list.remove(0);

        for (int i = 0; i <= (list.size() - 1); i++) {
            skuList.add(lineParse(list.get(i)));
        }
    }

    public List<Sku> getSkuList() {
        return skuList;
    }
}
