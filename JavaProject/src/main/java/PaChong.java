

import cn.guardcode.Bean;
import cn.guardcode.dao.LoadMovie;
import company.JsonToBean;

import java.io.*;
import java.net.*;
import java.util.List;

public class PaChong {

    void initTag() {
        //按热度排序,按时间排序,按评价排序
        String[] sort={"recommend","time","rank"};

        String[] tags = {"热门", "最新", "经典", "可播放", "豆瓣高分", "冷门佳片", "华语", "欧美", "韩国", "日本", "动作", "喜剧", "爱情", "科幻", "悬疑", "恐怖", "动画"};
        System.out.println(tags[6]);
    }
    /*
    工厂方法
    可以用来代替默认参数
     */
    public class MovieBuilder{

    }
    String searchMovie(String url, String type, String tag, String sort, String page_limit,String page_start){
        if(type==null){
            type="movie";
        }
        if (tag==null){
            tag="华语";
        }
        if (sort==null){
            sort="recommend";
        }
        if (page_limit==null){
            page_limit="20";
        }
        if (url==null){
            url = "https://movie.douban.com/j/search_subjects?" +
                    "type="+type+
                    "&tag="+tag+
                    "&sort="+sort+
                    "&page_limit="+page_limit+
                    "&page_start="+page_start;
        }
        System.out.println(url);
        return url;
    }
    /*
    public static void main(String[] args) {
        searchMovie(null,null,null,null,"100","0");
    }*/
    ///*
    public static void main(String[] args) {
        PaChong paChong = new PaChong();

        //每次获得记录条数
        String page_limit = "300";
        //paChong.getJson("https://douban.uieee.com/v2/movie/in_theaters");
        //paChong.getJson("https://douban.uieee.com/v2/movie/search");
        //String json = paChong.getJson("https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=20");
        boolean flag = true;
        int index = 0;
        while (flag){
            String url = paChong.searchMovie(null,null,null,null,page_limit,Integer.toString(index));

            String jsonString = paChong.getJson(url);
            if (jsonString==null)
                break;
            JsonToBean jsonToBean = new JsonToBean();
            List<Bean.Movie> fun = jsonToBean.fun(jsonString);

            if (fun == null)
                break;
            LoadMovie loadMovie = new LoadMovie();
            loadMovie.getMovie(fun);
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (fun.size()<Integer.parseInt(page_limit)){
                break;
            }
            index+=Integer.parseInt(page_limit);
            System.out.println("当前索引值:"+index);
            //测试用
            /*if (index>0)
                break;*/
        }

    }
    //*/

    String getJson(String urlParam) {
        URL url = null;
        String ResponseString = null;
        try {
            url = new URL(urlParam);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection urlConnection = null;
        try {
            urlConnection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        //httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        try {
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                //byte[] buffer = new byte[1024];
                //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                //int length = 0;


                /*是字节流与字符流之间的桥梁，
                能将字节流输出为字符流，
                并且能为字节流指定字符集，可输出一个个的字符
                 */
                /*字节流转为字符流

                 */
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                while((length = inputStream.read(buffer))!= -1){
//                    byteArrayOutputStream.write(buffer,0,length);
//                    System.out.println(new String(buffer,"UTF-8"));
//                }
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                }
                inputStream.close();
                inputStreamReader.close();
                bufferedReader.close();
                ResponseString = stringBuffer.toString();
                //byte[] ResponseBytes = byteArrayOutputStream.toByteArray();
                //byteArrayOutputStream.close();
//                System.out.println(ResponseBytes.toString());
                //String ResponseString = new String(ResponseBytes,"utf-8");
                String decode = URLDecoder.decode(ResponseString, "utf-8");
                System.out.println(decode);
                System.out.println(ResponseString);
            } else {
                System.out.println(httpURLConnection.getResponseCode());
                System.out.println(httpURLConnection.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseString;
    }
}
