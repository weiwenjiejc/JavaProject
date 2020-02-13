package cn.guardcode;

import java.util.List;

public class Bean {
    private List<Movie> subjects;

    public List<Movie> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Movie> subjects) {
        this.subjects = subjects;
    }

    public class Movie {
        private String rate;
        private String cover_x;
        private String title;
        private String url;
        private String playable;
        private String cover;
        private Integer id;
        private String cover_y;
        private String is_new;

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getCover_x() {
            return cover_x;
        }

        public void setCover_x(String cover_x) {
            this.cover_x = cover_x;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String isPlayable() {
            return playable;
        }

        public void setPlayable(String playable) {
            this.playable = playable;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCover_y() {
            return cover_y;
        }

        public void setCover_y(String cover_y) {
            this.cover_y = cover_y;
        }

        public String isIs_new() {
            return is_new;
        }

        public void setIs_new(String is_new) {
            this.is_new = is_new;
        }
    }
}
