package learn.orientedObject;

/**
 * Created by shifeixuan on 2019/4/1.
 */
public class OutterNoStatic {
    private static String name = "外部类静态属性";
    private int age;
    private String sex;

    public OutterNoStatic(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {
        OutterNoStatic.Inner inner = new OutterNoStatic(18, "外部类普通属性").new Inner("内部类普通属性");
        //访问内部类的方法
        inner.innerMethod();
        //访问内部类的属性
        System.out.println(inner.getSexInner());
    }

    private void outterMethod1() {

        System.out.println("外部类方法");
    }

    private static void outterMethod2() {

        System.out.println("静态外部类方法");
    }

    public class Inner {

        private String sexInner;

        /*成员内部类 不可以创建静态成员*/
        /*    private static  String sexInner;*/
        public Inner(String sexInner) {
            this.sexInner = sexInner;
        }

        private void innerMethod() {
            //访问外部类的方法
            outterMethod1();
            //访问外部类的静态方法
            outterMethod2();
            System.out.println(sex + age);
            //访问外部类的静态属性
            System.out.println("外部类的静态属性：" + name);
            System.out.println("内部类的普通方法");

        }

        public String getSexInner() {
            return sexInner;
        }

        public void setSexInner(String sexInner) {
            this.sexInner = sexInner;
        }
    }
}
