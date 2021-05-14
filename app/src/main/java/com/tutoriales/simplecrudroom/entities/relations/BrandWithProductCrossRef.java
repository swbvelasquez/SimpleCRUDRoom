package com.tutoriales.simplecrudroom.entities.relations;

import androidx.room.Entity;

@Entity(primaryKeys = {"brandId","productId"})
public class BrandWithProductCrossRef {
    private int brandId;
    private int productId;

    public BrandWithProductCrossRef() {
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
