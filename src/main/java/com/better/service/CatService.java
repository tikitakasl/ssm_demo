package com.better.service;

import com.better.domain.Cat;
import com.better.domain.Result;

public interface CatService {
    Result findAll();

    void addCat(Cat cat);

    void editCat(Cat cat);

    void deleteCat(Cat cat);
}
