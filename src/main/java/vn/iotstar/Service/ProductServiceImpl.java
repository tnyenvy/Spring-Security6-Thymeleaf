package vn.iotstar.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Product;
import vn.iotstar.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductServices {

    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> listAll() {
        return repo.findAll();
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public Product get(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

