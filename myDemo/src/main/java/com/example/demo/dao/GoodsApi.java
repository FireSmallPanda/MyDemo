package com.example.demo.dao;

import com.example.demo.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsApi extends JpaRepository<Goods, Integer> {
    // 通过年龄来查询
    public List<Goods> findByFlag(String Flag);
}
