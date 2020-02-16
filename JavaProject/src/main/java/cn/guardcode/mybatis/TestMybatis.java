package cn.guardcode.mybatis;

//import org.apache.ibatis.io.Resources;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

public class TestMybatis {
    public static void main(String[] args) {
//        String path = "cn/guardcode/mybatis/mybatis-config.xml";
        String path = "D:\\Project\\cn\\guardcode\\mybatis\\mybatis-config.xml";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        InputStream inputStream1 = null;
        try {
            inputStream1 = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(absolutePath);
        String resource = "D:\\Project\\JavaProject\\src\\main\\java\\cn\\guardcode\\mybatis\\mybatis-config.xml";
        InputStream inputStream = null;
        /*try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        SqlSessionFactory sqlSessionFactory
        = new SqlSessionFactoryBuilder().build(inputStream1);
    }
}
