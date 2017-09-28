package com.example.demo.controller;

import com.example.demo.dao.GoodsApi;
import com.example.demo.entity.Result;
import com.example.demo.service.GoodsService;
import com.example.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsApi goodsApi;

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询物品列表
     *
     * @return
     */
    @RequestMapping(value = "/goodsList")
    @ResponseBody
    public List<Goods> goodsList() {
        return goodsApi.findAll();
    }

    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    @RequestMapping(value = "/addGoods")
    @ResponseBody
    public Result addGoods(@Valid Goods goods, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            System.out.println("-----------------"+bindingResult.getFieldError().getDefaultMessage()+"-----------------------");

            return new Result("0001");
        }
       Goods goods1 =  goodsApi.save(goods);

        return  new Result("0000",goods1.getId());
    }

    /**
     * 根据id得到一个
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getOneGoodsById")
    @ResponseBody
    public Goods getOneGoodsById(Integer id) {
        return goodsApi.findOne(id);
    }

    /**
     * 更新商品
     *
     * @param goods
     */
    @RequestMapping(value = "/updateGoods")
    @ResponseBody
    public Goods updateGoods(Goods goods) {
        return goodsApi.save(goods);
    }

    /**
     * 删除商品
     * @param id
     */
    @RequestMapping(value = "/deleteGoods")
    @ResponseBody
    public void deleteGoods(Integer id) {
        goodsApi.delete(id);
    }

    /**
     * 根据flag查询商品
     * @param flag
     * @return
     */
    @RequestMapping(value = "/findGoodsByFlag")
    @ResponseBody
    public  List<Goods> findGoodsByFlag(String flag){
        return  goodsApi.findByFlag(flag);
    }

    /**
     * 插入这条数据
     */
    @RequestMapping(value = "/addTowGoods")
    @ResponseBody
    public void addTowGoods(){

        goodsService.addTwoGoods();
    }
}
