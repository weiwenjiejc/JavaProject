

import company.JsonToBean;

import java.io.*;
import java.net.*;

public class PaChong {

    public static void main(String[] args) {
        PaChong paChong = new PaChong();
        //paChong.getJson("https://douban.uieee.com/v2/movie/in_theaters");
        //paChong.getJson("https://douban.uieee.com/v2/movie/search");
        String json = paChong.getJson("https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=20");
        JsonToBean jsonToBean = new JsonToBean();
        jsonToBean.fun(json);
    }

    String getJson(String urlParam){
        URL url = null;
        String ResponseString= null;
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
        httpURLConnection.setRequestProperty("Connection","Keep-Alive");
        httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        httpURLConnection.setRequestProperty("Accept","*/*");
        httpURLConnection.setRequestProperty("Charset","UTF-8");
        //httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        try {
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
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
                while ((line = bufferedReader.readLine())!=null){
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
            }else {
                System.out.println(httpURLConnection.getResponseCode());
                System.out.println(httpURLConnection.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseString;
    }
}
