package com.tutoriales.simplecrudroom.entities.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.tutoriales.simplecrudroom.entities.Brand;
import com.tutoriales.simplecrudroom.entities.Product;

import java.util.List;

//relacion muchos a muchos producto con marcas
public class ProductWithBrands {
    @Embedded
    private Product product;
    @Relation(
            parentColumn = "productId",
            entityColumn = "brandId",
            associateBy = @Junction(BrandWithProductCrossRef.class)
    )
    private List<Brand> brandList;

    public ProductWithBrands() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }
}
