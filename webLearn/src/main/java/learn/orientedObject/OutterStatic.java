package learn.orientedObject;

/**
 * Created by shifeixuan on 2019/4/1.
 */
public class OutterStatic {
    private static String staticParam;
    private  String param;

    private void outMethod(){

    }

    private static  void outMethod2(){

    }

    public static void main(String[] args) {
        StaticInner staticInner =new StaticInner();

        /*不能通过实例化内部类，访问静态成员变量*/
        System.out.println(staticInner.inParam);
        staticInner.innerMethod();
    }

    /**
     * 静态内部类的定义
     */
    static class StaticInner{
        private static  String inStaticParam;
        private String inParam;
        private static void staticInnerMethod(){
            System.out.println("静态内部方法");
            /*静态内部类 只可以访问外部类的静态成员  外部类的静态成员param和outMethod2都报错*/
            outMethod2();
        }
        private void innerMethod(){
            System.out.println("静态内部方法");

        }

    }
}
