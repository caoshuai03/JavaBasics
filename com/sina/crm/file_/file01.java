package com.sina.crm.file_;

import java.io.*;
import java.util.Properties;

/**
 * @author caoshuai
 * @version 1.0
 */
public class file01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        String path = "e://t1.txt";
//        //创建输出流对象，写入数据
//        FileOutputStream fileOutputStream = new FileOutputStream(path);
//        String out = "hello.world!";//写入字符串
//        //字符串要转成byte数组传入,而且最好用数组长度来写入
//        fileOutputStream.write(out.getBytes(), 0, out.length());
//        fileOutputStream.close();//最后关闭流
//
//        //创建输入流对象,并读取数据
//        FileInputStream fileInputStream = new FileInputStream(path);
//        byte[] bytes = new byte[8];//定义byte数组，第一次读入到数组中
//        int len = 0;
//        //-1是没有数据,每次读入八个字节到byte数组中
//        while ((len = fileInputStream.read(bytes)) != -1) {
//            //输出数据，要转成字符串输出
//            System.out.print(new String(bytes, 0, len));
//        }
//        //最后关闭流
//        fileInputStream.close();

//        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
//
//        bufferedWriter.write("你好，这是写入的字符串。");
//        bufferedWriter.close();
//
//
//        String s = " ";
//        while ((s = bufferedReader.readLine()) != null) {
//            System.out.println(s);
//        }
//        bufferedReader.close();

//        String sourcePath = "e://test.jpg";
//        String destPath = "e://test01.jpg";

//        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourcePath));
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPath));
//        byte[] bytes = new byte[1024];
//        int len = 0;
//
//        while ((len = bufferedInputStream.read(bytes)) != -1) {
//            bufferedOutputStream.write(bytes, 0, len);
//        }
//        bufferedInputStream.close();
//        bufferedOutputStream.close();
//        String path = "e://dog.dat";
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
//
//        objectOutputStream.writeInt(109);
//        objectOutputStream.writeUTF("student");
//        objectOutputStream.writeObject(new Dog("小白",2));
//
//        objectOutputStream.close();
//        System.out.println("数据保存完毕");
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
//
//        System.out.println(objectInputStream.readInt()+"\n"+
//                objectInputStream.readUTF());
//        System.out.println(objectInputStream.readObject());
//        objectInputStream.close();

//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path), "utf-8");
//        osw.write("你好，世界！");
//        osw.close();
        //创建和写入配置信息
        Properties properties = new Properties();
        properties.setProperty("jack", "123");
        properties.setProperty("user", "汤姆");
        properties.setProperty("pass", "345");
        //第二个是注释
        properties.store(new FileOutputStream("e://mysql.properties"), null);

        //获取配置信息
        Properties properties1 = new Properties();
        properties1.load(new FileReader(path));
        String user = properties.getProperty("user");
        System.out.println(user);


    }


}

class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}


