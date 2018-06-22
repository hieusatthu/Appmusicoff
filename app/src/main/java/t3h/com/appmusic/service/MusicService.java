package t3h.com.appmusic.service;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import t3h.com.appmusic.MusicData;

/**
 * Created by songsong on 5/13/2018.
 */

public class MusicService extends Service {
    private List<MusicData> musicDatas;

    @Override
    public void onCreate() {
        super.onCreate();
        musicDatas=new ArrayList<>();
        initData();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder(this);
    }
    private void initData() {

        // lấy hết file audio trong điện thoại
        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null);

        if (cursor != null) {
            // lấy chỉ số cột get đường dẫn
            int indexData = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);
            int indexNameSong = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int indexDuration = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
            // lấy chỉ số cột ca sỹ
            int indexSinger = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String nameSong = cursor.getString(indexNameSong);
                String path = cursor.getString(indexData);
                String singer = cursor.getString(indexSinger);
                long duration = cursor.getLong(indexDuration);
                String album = cursor.getString(indexAlbum);
                musicDatas.add(new MusicData(path, singer, duration, nameSong, album));
                cursor.moveToNext();
                Log.d("AAA", nameSong);
            }
            cursor.close();
        }
    }


    public int getCount() {
        return musicDatas.size();
    }

    public MusicData getMusicData(int position) {
        return musicDatas.get(position);
    }
}
