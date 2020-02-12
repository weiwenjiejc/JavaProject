import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PaChong {

    public static void main(String[] args) {
        PaChong paChong = new PaChong();
        paChong.getJson("https://douban.uieee.com/v2/movie/in_theaters");
    }

    void getJson(String urlParam){
        URL url = null;
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
        try {
            if (httpURLConnection.getResponseCode() == 200){
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] buffer = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int length = 0;
                while((length = inputStream.read(buffer))!= -1){
                    byteArrayOutputStream.write(buffer,0,length);
                }
                byte[] ResponseBytes = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                System.out.println(ResponseBytes.toString());
                String ResponseString = new String(ResponseBytes,"utf-8");
                System.out.println(ResponseString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
