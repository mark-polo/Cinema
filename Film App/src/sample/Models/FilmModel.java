package sample.Models;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class FilmModel {

    private String search;
    private String title;
    private String poster;
    private String director;
    private String genre;
    private String year;
    private String time;
    private String country;
    private String rating;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    public void film() throws IOException {
        URL url = new URL("http://www.omdbapi.com/?t=" + getSearch() + "&apikey=64295b79");

        Scanner in = new Scanner((InputStream) url.getContent());

        StringBuilder result = new StringBuilder();

        while (in.hasNext()) {
            result.append(in.nextLine());
        }

        JSONObject object = new JSONObject(result.toString());
        setTitle(getSearch());
        setGenre(object.getString("Genre"));
        setDirector(object.getString("Director"));
        setTime(object.getString("Runtime"));
        setYear(object.getString("Year"));
        setCountry(object.getString("Country"));
        setRating(object.getString("imdbRating"));
        setPoster(object.getString("Poster"));
    }
}
