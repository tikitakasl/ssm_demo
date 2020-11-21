package com.better.controller;

import com.better.domain.Cat;
import com.better.domain.Const;
import com.better.domain.Result;
import com.better.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/cat")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping()
    public Result findAll(){
        return catService.findAll();
    }


    @DeleteMapping("/{cat_id}")
    public Result delete(@PathVariable("cat_id") Integer cat_id){

        Cat cat = new Cat();
        cat.setCat_id(cat_id);
        catService.deleteCat(cat);

        Result result = new Result();
        result.setFlag(true);
        return result;
    }
    @PutMapping("/{cat_id}")
    public Result edit(@PathVariable("cat_id") Integer cat_id){
        Cat cat = new Cat();
        cat.setCat_id(cat_id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = dateFormat.format(new Date());
        cat.setCat_eat(now);
        catService.editCat(cat);

        Result result = new Result();
        result.setFlag(true);
        return result;
    }

    @PostMapping()
    public Result edit(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session,
                       @RequestParam(value = "file", required = true) MultipartFile file,
                       Cat cat) throws Exception{

            String path = Const.IMG_PATH;

            int a = ThreadLocalRandom.current().nextInt(100000, 999999);
            String fileName = "" + a + System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));

            File targetFile = new File(path, fileName);

            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);
            String cat_img = "/img/" + fileName;
            cat.setCat_img(cat_img);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String now = dateFormat.format(new Date());
            cat.setCat_eat(now);
            if (cat.getCat_id() == null || "".equals(cat.getCat_id())){
                catService.addCat(cat);
            }else {
                catService.editCat(cat);
            }
            Result result = new Result();
            result.setFlag(true);

        return result;
    }
}
