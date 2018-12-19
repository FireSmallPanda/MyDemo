package com.danywer.cn.dao;

import com.danywer.cn.entity.User;
import com.danywer.cn.entity.UserExample;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.NotEmpty;

@Mapper
public interface UserMapper {
    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    long countByExample(UserExample example);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    int deleteByExample(UserExample example);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    int insert(User record);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    List<User> selectByExample(UserExample example);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    User selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    int updateByPrimaryKey(User record);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    int batchInsert(@Param("list") List<User> list);

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    int batchInsertSelective(@Param("list") List<User> list, @Param("selective") User.Column ... selective);
}