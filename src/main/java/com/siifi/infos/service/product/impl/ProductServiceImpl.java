package com.siifi.infos.service.product.impl;

import com.siifi.infos.entity.Product;
import com.siifi.infos.mapper.ProductMapper;
import com.siifi.infos.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    public List<Product> getProduct(){
        return productMapper.listAll();
    }
    public Product getProductById(int productId){
        return productMapper.findById(productId);
    }
    public Boolean saveProduct(Product product){
        return productMapper.save(product);
    }
    public Boolean editProduct(Product product){
        return productMapper.edit(product);
    }
    public Boolean deleteProduct(int productId){
        return productMapper.delete(productId);
    }
}
