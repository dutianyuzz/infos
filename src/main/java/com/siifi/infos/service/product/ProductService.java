package com.siifi.infos.service.product;

import com.siifi.infos.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProduct();
    public Product getProductById(int productId);
    public Boolean saveProduct(Product product);
    public Boolean editProduct(Product product);
    public Boolean deleteProduct(int productId);
}
