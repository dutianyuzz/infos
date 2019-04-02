package com.siifi.infos.mapper;

import com.siifi.infos.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("SELECT PRODUCT_ID,PRODUCT_NAME,UTTER,SHOU,DATE,IMAGEPATH FROM sys_product")
    public List<Product> listAll();
    public Product findById(int productId);
    public boolean save(Product product);
    public boolean edit(Product product);
    public boolean delete(int productId);
}
