package task.project.toodl.moviemodule.Utils;

public class MoviesDataModel {
    String title, description, director, producer;double resRating=0;
    int movieId,releaseDate,rtScore;
    public String getTitle() {
        return title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRtScore() {
        return rtScore;
    }

    public void setRtScore(int rtScore) {
        this.rtScore = rtScore;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getResRating() {
        return resRating;
    }

    public void setResRating(double resRating) {
        this.resRating = resRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
