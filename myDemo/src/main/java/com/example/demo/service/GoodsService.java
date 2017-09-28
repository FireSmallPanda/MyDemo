package com.example.demo.service;

import com.example.demo.dao.GoodsApi;
import com.example.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsService {
    @Autowired
    private GoodsApi goodsApi;
    /**
     * 添加两个商品（事物）
     * @return
     */
    @Transactional
    public  void addTwoGoods(){
        Goods goods1 = new Goods();
        goods1.setFlag("2");
        goods1.setName("李四");
        goodsApi.save(goods1);
        Goods goods2 = new Goods();
        goods2.setFlag("2");
        goods2.setName("小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听小德的名字很长很伤很好听");
        goodsApi.save(goods2);
    }
}
