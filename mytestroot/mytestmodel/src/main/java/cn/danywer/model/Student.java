package cn.danywer.model;

public class Student {
    private Integer id;
    private String name;//姓名
    private String sex;// 性别
    private String address;//地址
    @Override
    public String toString() { return "Student : id:"+this.id+" name:"+this.name+" sex:"+this.sex+" address:"+this.address; }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
