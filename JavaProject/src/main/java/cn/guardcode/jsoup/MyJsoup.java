package cn.guardcode.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyJsoup {

    public static void main(String[] args) {
        Connection connect = Jsoup.connect("https://movie.douban.com/subject/30252495/");
        Connection connection = connect.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.106 Safari/537.36 Edg/80.0.361.54");
        Connection.Response execute = null;
        try {
            execute = connection.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String charset = execute.charset();
        String body = execute.body();
        System.out.println(charset);
        //System.out.println(body);
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*Elements script = document.select("script");
        for(Element element:script){
            System.out.println(element.text());
        }*/
        Elements select = document.select("div.recommendations-bd");
        for(int i = 0; i < select.size();i++){

        }
        System.out.println(select.size());
        for(Element element:select){
            int childNodeSize = element.childNodeSize();
            System.out.println("childNodeSize: "+childNodeSize);
            System.out.println("sss");
            Elements a = element.select("dd > a");
            System.out.println("相似电影：");
            int i = 0;
            for (Element element1:a){
                String href = element1.attr("href");
                String name = element1.text();
                String replace = href.replace("/?from=subject-page","");
                System.out.println(replace);
                System.out.println(name);
                System.out.println(href);
            }
            //System.out.println(element.html());
           // String href = element.select("a").attr("href");
            //String alt = element.select("a").attr("alt");
        }
        //System.out.println(select.text());
        //使用正则表达式
        //String regex = "<script type=\"application/ld+json\">(.*?)</script>";
        /*String regex = "<script(.*?)>(.*?)</script>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(body);
        int count = matcher.groupCount();
        System.out.println(count);
        System.out.println(body);*/
        //System.out.println(matcher.group());
        /*for(int i = 1; i <= count;i++){
            System.out.println("group "+i);
            String group = matcher.group(i);
            System.out.println(group);
        }*/
    }
}
