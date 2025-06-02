package model;

public class SelectedMovie {
    private static String idMovie;
    private static String title;
    private static String genre;
    private static String rating;
    private static String date;
    private static String showtime;

    public static void setSelectedMovie(String id, String t, String g, String r, String d, String s) {
        idMovie = id;
        title = t;
        genre = g;
        rating = r;
        date = d;
        showtime = s;
    }

    public static String getIdMovie() { return idMovie; }
    public static String getTitle() { return title; }
    public static String getGenre() { return genre; }
    public static String getRating() { return rating; }
    public static String getDate() { return date; }
    public static String getShowtime() { return showtime; }
}