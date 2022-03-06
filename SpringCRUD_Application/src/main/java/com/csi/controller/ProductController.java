package com.csi.controller;

import com.csi.model.Product;
import com.csi.service.ProductService;
import com.csi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productServiceImpl;

    @GetMapping("/getdata")
    public List<Product>getAllData(){
        return productServiceImpl.getAllData();
    }

    @PostMapping("/savedata")
    public String saveData (@RequestBody Product product)
    {
        productServiceImpl.saveData(product);
        return "Product Data save Successfully";
    }

    @PutMapping("/updatedata/{productId}")
    public String updateData (@PathVariable int productId,@RequestBody Product product)
    {
        productServiceImpl.updateData(productId,product);
        return "product updated successfully";
    }

    @DeleteMapping("/deletedata/{productId}")
    public String deleteData(@PathVariable int productId)
    {
        productServiceImpl.deleteData(productId);
        return "Data delete successfully";
    }


}
