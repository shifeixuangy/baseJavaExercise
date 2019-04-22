package learn;

/**
 * @program: baseJavaExercise
 * @Description:
 * @author:sfx
 * @Date:2019/4/19
 * @Time:11:26
 */
public class Customer implements Cloneable {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public Customer(String name, String sex) {
        this.name = name;
        this.sex = sex;
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
