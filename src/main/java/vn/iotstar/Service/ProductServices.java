package vn.iotstar.Service;

import java.util.List;

import vn.iotstar.Entity.Product;

public interface ProductServices {
    void delete(Long id);
    Product get(Long id);
    Product save(Product product);
    List<Product> listAll();
}

