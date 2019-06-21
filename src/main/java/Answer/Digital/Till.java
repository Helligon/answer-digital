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
        basket.add(store.findItem(productCode));
    }

    public List<Sku> getReceipt() {
        return basket;
    }
}
