package com.tutoriales.simplecrudroom.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Brand")
public class Brand {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true)
    private int brandId;
    private String name;

    public Brand() {
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
