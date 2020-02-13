package company;

import cn.guardcode.Bean;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.List;

public class JsonToBean {
    public void fun(String jsonString){
        JsonObject jsonObject = new JsonObject();
        Gson gson = new Gson();
        Bean bean = gson.fromJson(jsonString, Bean.class);
        if (bean!=null){
            List<Bean.Movie> subjects = bean.getSubjects();
            for(Bean.Movie movie:subjects){
                System.out.println(movie.getTitle());
            }
        }
    }

}
