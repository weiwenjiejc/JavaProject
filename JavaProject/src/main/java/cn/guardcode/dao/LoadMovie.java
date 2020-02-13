package cn.guardcode.dao;

import cn.guardcode.Bean;
import cn.guardcode.db.MyDB;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LoadMovie {
    private QueryRunner runner = new QueryRunner();

    public void getMovie(List<Bean.Movie> movies) {
        DataSource dataSource = MyDB.getDataSource();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO r_movie(rate ,cover_x ,title ,url ,playable ,cover ,id ,cover_y ,is_new) values(?,?,?,?,?,?,?,?,?)";
        int update = 0;
        if (movies != null) {
            System.out.println("即将插入条数:"+movies.size());
            for (Bean.Movie movie : movies) {
                Object[] params = {
                        movie.getRate(),
                        movie.getCover_x(),
                        movie.getTitle(),
                        movie.getUrl(),
                        movie.getPlayable(),
                        movie.getCover(),
                        movie.getId(),
                        movie.getCover_y(),
                        movie.getIs_new()
                };
                try {
                    update = runner.update(connection, sql, params);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println(update);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("movies is null");
        }

    }
}
