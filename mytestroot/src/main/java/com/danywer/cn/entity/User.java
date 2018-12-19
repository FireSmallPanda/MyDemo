package com.danywer.cn.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created By MBG-GUI-EXTENSION https://github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
@Table(name=""user"")
public class User implements Serializable {
    /**
     *
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    private Integer id;

    /**
     *
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    private String username;

    /**
     *
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    private Integer age;

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    public User withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    public User withUsername(String username) {
        this.setUsername(username);
        return this;
    }

    /**
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method returns the value of the database column user.age
     *
     * @return the value of user.age
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    public User withAge(Integer age) {
        this.setAge(age);
        return this;
    }

    /**
     * This method sets the value of the database column user.age
     *
     * @param age the value for user.age
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", age=").append(age);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()));
    }

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        return result;
    }

    /**
     *
     * @mbg.generated Mon Jun 25 00:09:06 CST 2018
     */
    public enum Column {
        id("id"),
        username("username"),
        age("age");

        /**
         *
         * @mbg.generated Mon Jun 25 00:09:06 CST 2018
         */
        private final String column;

        /**
         *
         * @mbg.generated Mon Jun 25 00:09:06 CST 2018
         */
        public String value() {
            return this.column;
        }

        /**
         *
         * @mbg.generated Mon Jun 25 00:09:06 CST 2018
         */
        public String getValue() {
            return this.column;
        }

        /**
         *
         * @mbg.generated Mon Jun 25 00:09:06 CST 2018
         */
        Column(String column) {
            this.column = column;
        }

        /**
         *
         * @mbg.generated Mon Jun 25 00:09:06 CST 2018
         */
        public String desc() {
            return this.column + " DESC";
        }

        /**
         *
         * @mbg.generated Mon Jun 25 00:09:06 CST 2018
         */
        public String asc() {
            return this.column + " ASC";
        }
    }
}