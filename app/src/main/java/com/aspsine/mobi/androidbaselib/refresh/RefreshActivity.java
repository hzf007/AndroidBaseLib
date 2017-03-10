package com.aspsine.mobi.androidbaselib.refresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aspsine.mobi.androidbaselib.R;
import com.aspsine.mobi.common.refresh.OnLoadMoreListener;
import com.aspsine.mobi.common.refresh.OnRefreshListener;
import com.aspsine.mobi.common.refresh.SwipeToLoadLayout;

public class RefreshActivity extends AppCompatActivity implements OnRefreshListener,OnLoadMoreListener{
    public  static  final  String TAG = RefreshActivity.class.getSimpleName();
    private SwipeToLoadLayout swipeToLoadLayout;
    private ListView listView;
    private ArrayAdapter<String> mAdapter;
    private int mRefreshNum;
    private int mLoadMoreNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
        listView = (ListView)findViewById(R.id.swipe_target);
        mAdapter = new ArrayAdapter<String>(RefreshActivity.this, android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdapter);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
        swipeToLoadLayout.setSwipeStyle(SwipeToLoadLayout.STYLE.ABOVE);
    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                mAdapter.add("Load More" + mLoadMoreNum);
                mLoadMoreNum++;
            }
        }, 3000);
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
                mAdapter.insert("Refresh" + mRefreshNum, 0);
                mRefreshNum++;
            }
        }, 3000);
    }
}
