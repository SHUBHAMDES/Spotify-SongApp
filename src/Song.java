public class Song {

   private String title;
    private double duration;
    //artist
    //genere


    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Shubham you  are listning Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
