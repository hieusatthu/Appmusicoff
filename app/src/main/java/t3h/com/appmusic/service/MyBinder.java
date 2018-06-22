package t3h.com.appmusic.service;

import android.os.Binder;

/**
 * Created by songsong on 5/13/2018.
 */

public class MyBinder extends Binder {
    private MusicService service;

    public MyBinder(MusicService service) {

        this.service = service;
    }
    public MusicService getService()
    {
        return service;
    }
}
