package cn.guardcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class JavaUrl {

    /*
    步长是20
     */
    public String getUrl(Integer start){
        String url = "https://movie.douban.com/j/new_search_subjects?" +
                "sort=U&range=0,10&tags=电影&start=" +
                Integer.toString(start) +
                "&countries=中国大陆";
        return url;
    }

    public String getJson(String urlParam) {
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
                //System.out.println(decode);
                //System.out.println(ResponseString);
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
