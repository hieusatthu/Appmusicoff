package t3h.com.appmusic.music;

import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by songsong on 5/13/2018.
 */

public class MusicManager {
    public MediaPlayer mediaPlayer;

    public MusicManager() {

    }

    public void initData(String path) throws IOException {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(path);
    }

    public void start() {

        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }


        mediaPlayer.start();
    }

    public void paue() {
        mediaPlayer.pause();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void release() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

//    public boolean isMusicPlaying() {
////        if (mediaPlayer.isPlaying()==true) {
////            return true;
////        } else {
////            return false;
////        }
//    }
}