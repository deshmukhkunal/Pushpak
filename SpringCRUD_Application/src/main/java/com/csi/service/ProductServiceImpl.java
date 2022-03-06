package com.csi.service;

import com.csi.dao.ProductDao;
import com.csi.dao.ProductDaoImpl;
import com.csi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDao productDaoImpl;
    @Override
    public void saveData(Product product) {
        productDaoImpl.saveData(product);
    }

    @Override
    public List<Product> getAllData() {
        return productDaoImpl.getAllData();
    }

    @Override
    public void updateData(int productId, Product product) {
        productDaoImpl.updateData(productId,product);
    }

    @Override
    public void deleteData(int productId) {
        productDaoImpl.deleteData(productId);
    }
}
