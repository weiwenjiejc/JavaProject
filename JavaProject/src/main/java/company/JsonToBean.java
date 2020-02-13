package company;

import cn.guardcode.Bean;
import com.google.gson.Gson;

import java.util.List;

public class JsonToBean {
    public List<Bean.Movie> fun(String jsonString){
        //JsonObject jsonObject = new JsonObject();
        Gson gson = new Gson();
        Bean bean = gson.fromJson(jsonString, Bean.class);
        List<Bean.Movie> subjects = null;
        if (bean!=null){
            subjects = bean.getSubjects();
            for(Bean.Movie movie:subjects){

                System.out.println(movie.getTitle());
            }
        }
        return subjects;
    }

}
