package learn;


import java.io.Serializable;

/**
 *
 * @author shifeixuan
 * @date 2019/4/9
 */
public class Apple implements Serializable,Cloneable  {

    private static final long serialVersionUID = -6457053263608688779L;
    private String color;
    private Integer size;
    private String quality;
    private Customer customer;

    public Apple(String color, Integer size, String quality, Customer customer) {
        this.color = color;
        this.size = size;
        this.quality = quality;
        this.customer = customer;
    }

    public Apple() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //内部属性可以直接点出来。。。 apple.customer=
        Apple apple =(Apple)super.clone();
        apple.customer=(Customer) apple.getCustomer().clone();
        return apple;
    }
}
