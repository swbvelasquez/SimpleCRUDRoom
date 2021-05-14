package com.tutoriales.simplecrudroom.interfaces.repositories;

import androidx.room.Insert;
import androidx.room.Query;

import com.tutoriales.simplecrudroom.entities.relations.BrandWithProductCrossRef;

import java.util.List;

public interface IBrandWithProductCrossRefRepository {
    long insert(BrandWithProductCrossRef crossRef);
    List<BrandWithProductCrossRef> getAllCrossRef();
}
