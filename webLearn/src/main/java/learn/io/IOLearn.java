package learn.io;

import learn.Apple;
import learn.Customer;

import java.io.*;

/**
 * Created by shifeixuan on 2019/4/1.
 */
public class IOLearn {

    //节点流和处理流

    //文件字节流
    public void test1() {
        try (InputStream is = new FileInputStream("E:\\learnDoucment/fileInputStream.txt")) {
            byte[] buff = new byte[24];
            int hasRead = 0;
            StringBuffer strBuf = new StringBuffer();
            while ((hasRead = is.read(buff)) > 0) {
                strBuf.append(new String(buff, 0, hasRead));
                for (byte b : buff) {
                    char ch = (char) b;
                    if (ch != '\r') {
                        System.out.println(ch);
                    }
                }
            }


            System.out.println(strBuf.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //文件字节流-输入输出
    public void test2() {
        try (InputStream is = new FileInputStream("E:\\learnDoucment/fileInputStream.txt");
             OutputStream os = new FileOutputStream("E:\\learnDoucment/fileOutputStream.txt")
        ) {
            byte[] buff = new byte[24];
            int hasRead = 0;
            StringBuffer strBuf = new StringBuffer();
            while ((hasRead = is.read(buff)) > 0) {
                os.write(buff, 0, hasRead);
                strBuf.append(new String(buff, 0, hasRead));

            }
            System.out.println(strBuf.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 字节流的缓冲流  使用方法------和FileInputStream的最大区别是，可以readLine！=null，就是逐行读取，可以节省效率。在缓冲方面没区别
    public void test3() throws FileNotFoundException {
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream("E:\\learnDoucment/bufferInputStream.txt"));
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("E:\\learnDoucment/bufferOutputStream.txt"));
        try {
            /*byte[] buff =new byte[24];
            int hasRead =0;
            StringBuffer strBuf =new StringBuffer();
            while ((hasRead=bi.read(buff))>0){
                bo.write(buff,0,hasRead);
                strBuf.append(new String(buff,0,hasRead));

            }
            bo.flush();
            bo.close();
            System.out.println(strBuf.toString());*/
            /*while ((bi.readLine())>0){
                bo.write(buff,0,hasRead);
                strBuf.append(new String(buff,0,hasRead));

            }*/
            bo.flush();
            bo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //字符流
    //输出流 read(buff)是循环读取的,最后一个读取的数组也是24字符，导致会有重复，所以writer方法要设置长度，
    // 否则会错误
    public void test4() {
        try (FileReader fr = new FileReader("E:\\learnDoucment/fileReader.txt");
             FileWriter fw = new FileWriter("E:\\learnDoucment/fileWriter.txt")
        ) {
            char[] buff = new char[24];
            int hasRead = 0;
            StringBuffer strBuf = new StringBuffer();
            while ((hasRead = fr.read(buff)) > 0) {
                fw.write(buff, 0, hasRead);
                strBuf.append(new String(buff, 0, hasRead));

            }
            System.out.println(strBuf.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test5() {
        Apple apple = new Apple();
        Apple apple1 = new Apple();
        apple1.setColor(apple.getColor());
        System.out.println(apple1.getColor());
        System.out.println(apple.getColor());

    }

    //如果文件已存在，则输出流内容覆盖此文件，如果不存在，则自动创建。 但是输入流必须存在文件，否则会报错
    public void test6() {
        File file = new File("E:\\learnDoucment\\FileTest");
        //需要处理异常原因是learnDoucment这个文件夹不存在呢
        boolean isNewFile = false;
        try {
            isNewFile = file.createNewFile();
            if (isNewFile) {
                System.out.println("创建完成");
            } else {
                System.out.println("创建失败，已存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void test7() {
        File file = new File("E:\\learnDoucment1\\mkdirTest");
        //mkDir 不会创建父目录，而且也不会报错，父目录不存在的话，仅仅会创建失败，不会报异常
        boolean isNewDir = false;
        /*  try {*/
        isNewDir = file.mkdir();
        if (isNewDir) {
            System.out.println("创建完成");
        } else {
            System.out.println("创建失败");
        }
        /*}catch (IOException e){
            e.printStackTrace();
        }*/

    }

    public void test8() {
        File file = new File("E:\\learnDoucment1\\mkdirsTest");
        //mkDirs 会创建父路径。 迭代mkDir方法
        boolean isNewDir = false;
        /*  try {*/
        isNewDir = file.mkdirs();
        if (isNewDir) {
            System.out.println("创建完成");
        } else {
            System.out.println("创建失败");
        }
        /*}catch (IOException e){
            e.printStackTrace();
        }*/

    }

    //文件打印流，华友printStream，构造器传入outStream。printWriter可以传入字节流和字符流。
    //response获取的writer是输出到响应

    public void test14(){
       try( PrintWriter pw =new PrintWriter(new FileWriter("E:\\learnDoucment\\printWriterTestFile"))){
           pw.println("輸出到指定的輸出流文件中-println");
           pw.write("输出到制定的writer中-writer\n");

       } catch (IOException e) {
           e.printStackTrace();
       }

    }


    /**
     *
     * RandomAccessFile强大的随机读取文件对象
     * seek() 指针跳转的单位是字节byte
     * utf-8中文字符，一般是三个字节
     */
    public void test9() {
        File file = new File("E:\\learnDoucment\\randomAccessTestFile");
        try (RandomAccessFile raf = new RandomAccessFile(file,"rw")) {
            long point =raf.getFilePointer();
            raf.seek(12);
            point =raf.getFilePointer();
            raf.write("追加的内容，测试内容".getBytes());

        raf.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 序列化
     * 序列化 (Serialization)是将对象的状态信息转换为可以存储或传输的形式的过程
     *java.io.Serializable
     *
     * java.io.Externalizable
     *
     * ObjectOutput
     *
     * ObjectInput
     *
     * ObjectOutputStream
     *
     * ObjectInputStream
     */
    public void test10() {
        Apple apple =new Apple();
        apple.setColor("红色");
        apple.setSize(12);
        File file = new File("E:\\learnDoucment\\ObjectInputFile.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(apple);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 反序列化 得到java对象  如果加了SerialVersionUID，那么对类添加属性和方法，反序列化也不会出错
     * 不加的话，回出错
     * @param
     * @return void
     */

    public void test11() {
        File file = new File("E:\\learnDoucment\\ObjectInputFile.txt");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Apple apple =(Apple) ois.readObject();
            System.out.println("苹果的尺寸："+apple.getSize()+";苹果的颜色:"+apple.getColor());
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 对象克隆
     * @param
     * @return void
     */
    public void test12() throws CloneNotSupportedException {
        Customer customer = new Customer("石飞旋","男");
        Apple a1 =new Apple("青色",12,"优",customer);
        System.out.println(a1);
        Apple a2 =(Apple)a1.clone();
        System.out.println(a2.getColor()+a2.getSize()+":"+a2.getQuality());
    }

    /**
     * 对象克隆
     * @param
     * @return void
     */
    public void test13() throws CloneNotSupportedException {
        Customer customer = new Customer("石飞旋","男");
        Apple a1 =new Apple("青色",12,"优",customer);
        System.out.println(a1);
        Apple a2 =(Apple)a1.clone();
        a2.getCustomer().setName("陈姝");
        a2.getCustomer().setSex("女");
        System.out.println(a1.getCustomer().getName()+"---"+a2.getCustomer().getName());
    }


}
