package com.company.dp.factory;

import java.util.HashMap;
import java.util.Map;

class ProductFactory {
    private static final Map<String, Product> prMap = new HashMap<>();
    public static synchronized Product createProduct(String type) throws Exception {
        Product product = null;
        if (prMap.containsKey(type)) {
            product = prMap.get(type);
        } else {
            if (type.equals("Product1")) {
                product = new P1();
            } else {
                product = new P2();
            }
            prMap.put(type, product);
        }
        return product;
    }
}


public class DP_LasyFactory {
}
