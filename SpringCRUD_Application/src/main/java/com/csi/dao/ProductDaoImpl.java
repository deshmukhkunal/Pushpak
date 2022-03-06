package com.csi.dao;

import com.csi.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductDaoImpl implements ProductDao {
    private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    @Override
    public void saveData(Product product) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
    }

    @Override
    public List<Product> getAllData() {
        Session session = factory.openSession();
        List<Product>productList = session.createQuery("from Product").list();
        return productList;
    }

    @Override
    public void updateData(int productId, Product product) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product1 = (Product) session.get(Product.class,productId);
        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setProductLaunchDate(product.getProductLaunchDate());

        session.save(product1);
        transaction.commit();
    }

    @Override
    public void deleteData(int productId) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product1 = (Product) session.get(Product.class,productId);
        session.delete(product1);
        transaction.commit();
    }
}
