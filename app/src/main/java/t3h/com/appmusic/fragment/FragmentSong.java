package t3h.com.appmusic.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import t3h.com.appmusic.MusicData;
import t3h.com.appmusic.R;
import t3h.com.appmusic.adapter.SongAdapter;
import t3h.com.appmusic.service.MusicService;
import t3h.com.appmusic.service.MyBinder;

/**
 * Created by songsong on 5/13/2018.
 */

public class FragmentSong extends Fragment implements SongAdapter.iPlayMusic {
    private ListView lvSong;
    private SongAdapter adapter;
    private MusicService service;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_song,container,false);
        anhXa(view);
        return view;
    }

    private void anhXa(View view) {
        lvSong=view.findViewById(R.id.lv_song);
    }
    public void initAdapter()
    {
        adapter=new SongAdapter(this);
        adapter.notifyDataSetChanged();
        lvSong.setAdapter(adapter);
        Log.d("AAA","in");
    }


    @Override
    public void playMusic(int position) {

    }

    @Override
    public int getCount() {
        return service.getCount();
    }

    @Override
    public MusicData getMusicData(int position) {
        return service.getMusicData(position);
    }


}
