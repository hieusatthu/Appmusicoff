package t3h.com.appmusic;

/**
 * Created by songsong on 5/13/2018.
 */

public class MusicData {
    private String path;
    private String singger;
    private long duration;
    private String title;
    private String album;

    public MusicData() {
    }

    public String getPath() {

        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSingger() {
        return singger;
    }

    public void setSingger(String singger) {
        this.singger = singger;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public MusicData(String path, String singger, long duration, String title, String album) {
        this.path = path;
        this.singger = singger;
        this.duration = duration;
        this.title = title;
        this.album = album;
    }
}
