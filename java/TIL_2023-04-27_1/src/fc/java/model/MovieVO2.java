package fc.java.model;

public class MovieVO2 {
    private String title;
    private String date;
    private String mainActor;
    private String genre;
    private int runningTime;
    private String rating;

    public MovieVO2() {
    }

    public MovieVO2(String title, String date, String mainActor, String genre, int runningTime, String rating) {
        this.title = title;
        this.date = date;
        this.mainActor = mainActor;
        this.genre = genre;
        this.runningTime = runningTime;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getMainActor() {
        return mainActor;
    }

    public String getGenre() {
        return genre;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public String getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MovieVO2{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", mainActor='" + mainActor + '\'' +
                ", genre='" + genre + '\'' +
                ", runningTime=" + runningTime +
                ", rating='" + rating + '\'' +
                '}';
    }
}
