package t3h.com.appmusic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import t3h.com.appmusic.R;

/**
 * Created by songsong on 5/13/2018.
 */

public class FragmentAlbum extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_album,container,false);
        return view;
    }
}
