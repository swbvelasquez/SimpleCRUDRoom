package com.tutoriales.simplecrudroom.entities.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.tutoriales.simplecrudroom.entities.Brand;
import com.tutoriales.simplecrudroom.entities.Product;

import java.util.List;

//relacion de muchos a muchos direccion marca con producto
public class BrandWithProducts {
    @Embedded
    private Brand brand;
    @Relation(
            parentColumn = "brandId",
            entityColumn = "productId",
            associateBy = @Junction(BrandWithProductCrossRef.class)
    )
    private List<Product> productList;

    public BrandWithProducts() {
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
