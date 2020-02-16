package cn.guardcode.bean;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {
    private List<String> directors;
    private String rate;
    private String cover_y;
    private String cover_x;
    private String cover;
    private String star;
    private List<String> casts;
    private String id;
    private String title;
    private String url;

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCover_y() {
        return cover_y;
    }

    public void setCover_y(String cover_y) {
        this.cover_y = cover_y;
    }

    public String getCover_x() {
        return cover_x;
    }

    public void setCover_x(String cover_x) {
        this.cover_x = cover_x;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public List<String> getCasts() {
        return casts;
    }

    public void setCasts(List<String> casts) {
        this.casts = casts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Movie{" +
                "directors=" + directors +
                ", rate='" + rate + '\'' +
                ", cover_y='" + cover_y + '\'' +
                ", cover_x='" + cover_x + '\'' +
                ", cover='" + cover + '\'' +
                ", star='" + star + '\'' +
                ", casts=" + casts +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
