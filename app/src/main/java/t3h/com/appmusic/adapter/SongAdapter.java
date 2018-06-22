package t3h.com.appmusic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import t3h.com.appmusic.MusicData;
import t3h.com.appmusic.R;

/**
 * Created by songsong on 5/13/2018.
 */

public class SongAdapter extends BaseAdapter {

    private iPlayMusic iPlayMusic;

    public SongAdapter(SongAdapter.iPlayMusic iPlayMusic) {
        this.iPlayMusic = iPlayMusic;

    }
    @Override
    public int getCount() {
        return iPlayMusic.getCount();
    }

    @Override
    public Object getItem(int position) {
        return iPlayMusic.getMusicData(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view==null)
        {
            LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
            view=inflater.inflate(R.layout.item_song,viewGroup,false);
        }
        TextView txtNameSong=view.findViewById(R.id.txt_name_song);
        TextView txtSinger=view.findViewById(R.id.txt_singer);

        ImageView imgMore=view.findViewById(R.id.img_more);
        ImageView imgLogo=view.findViewById(R.id.img_logo_music);

        MusicData musicData=iPlayMusic.getMusicData(position);
        txtNameSong.setText(musicData.getTitle());
        txtSinger.setText(musicData.getSingger());

        return view;
    }

    public interface iPlayMusic
    {
        void playMusic(int position);
        int getCount();
        MusicData getMusicData(int position);
    }

}
