package com.better.dao;

import com.better.domain.Cat;

import java.util.List;

public interface CatDao {
    List<Cat> selectAll();

    void insertCat(Cat cat);

    void updateCat(Cat cat);

    void deleteCat(Cat cat);
}
