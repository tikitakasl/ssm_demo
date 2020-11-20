package com.better.service.impl;

import com.better.dao.CatDao;
import com.better.domain.Cat;
import com.better.domain.Result;
import com.better.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatDao catDao;

    @Override
    public Result findAll() {
        Result result = new Result();
        try{
            List<Cat> catList = catDao.selectAll();
            result.setData(catList);
            result.setFlag(true);
        }catch (Exception e){
            result.setFlag(false);
            result.setMessage(e.getMessage());
        }

        return result;
    }

    @Override
    public void addCat(Cat cat) {
        catDao.insertCat(cat);
    }

    @Override
    public void editCat(Cat cat) {
        catDao.updateCat(cat);
    }

    @Override
    public void deleteCat(Cat cat) {
        catDao.deleteCat(cat);
    }
}
