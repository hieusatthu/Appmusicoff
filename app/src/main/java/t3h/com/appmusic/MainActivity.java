package t3h.com.appmusic;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import t3h.com.appmusic.adapter.FragmentAdapter;
import t3h.com.appmusic.adapter.SongAdapter;
import t3h.com.appmusic.fragment.FragmentAlbum;
import t3h.com.appmusic.fragment.FragmentSinger;
import t3h.com.appmusic.fragment.FragmentSong;
import t3h.com.appmusic.service.MusicService;
import t3h.com.appmusic.service.MyBinder;

public class MainActivity extends AppCompatActivity implements SongAdapter.iPlayMusic{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private FragmentAdapter adapter;
    private ServiceConnection connection;

    FragmentTransaction transaction;

    private MusicService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initFragments();
        initViewPager();
        initTablayOut();
        connectMusicService();


    }

    private void anhXa() {
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        tabLayout = (TabLayout) findViewById(R.id.my_tablayout);
        viewPager = (ViewPager) findViewById(R.id.my_viewpager);
        //


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void initFragments() {

        fragments = new ArrayList<>();
        fragments.add(new FragmentSong());
        fragments.add(new FragmentSinger());
        fragments.add(new FragmentAlbum());
        //
        adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
    }

    private void initViewPager() {
        viewPager.setAdapter(adapter);
    }
    private void initTablayOut() {
        tabLayout.setupWithViewPager(viewPager);

    }

    private void connectMusicService() {
        // tạo ra cầu nối từ Activity đến service
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                // khi kết nối xong service sẽ trả về IBinder trong Ibinder của nó (sẽ là MyBinder mà ta đã tạo ra)
                // ép kiểu iBinder sang MyBinder
                MyBinder myBinder = (MyBinder) iBinder;
                service = myBinder.getService();
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onServiceDisconnected(ComponentName componentName) {
            }
        };
        Intent intent = new Intent();
        intent.setClass(this, MusicService.class);
        // xác nhận kết nối
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
        // tham số thứ 3 là cờ tạo: nghĩa là service chưa dc tạo thì sẽ tạo
        FragmentManager fm = getSupportFragmentManager();

//if you added fragment via layout xml
        FragmentSong fragmentSong= (FragmentSong) adapter.getItem(0);
        fragmentSong.initAdapter();
    }

    @Override
    public void playMusic(int position) {

    }

    @Override
    public int getCount() {
        int test=service.getCount();
        return service.getCount();
    }

    @Override
    public MusicData getMusicData(int position) {
        return service.getMusicData(position);
    }
}
