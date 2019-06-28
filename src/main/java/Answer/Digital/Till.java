package Answer.Digital;

import java.util.ArrayList;
import java.util.List;

public class Till {
    private Store store;
    private List<Sku> basket = new ArrayList<>();

    public Till(Store store) {
        this.store = store;
    }

    void scanItem(String productCode) {
        Sku item = store.findItem(productCode);
        if (item != null) {
            basket.add(item);
        }else {
            System.out.println("Item not found.");
        }
    }

    public List<Sku> getReceipt() {
        return basket;
    }
}
