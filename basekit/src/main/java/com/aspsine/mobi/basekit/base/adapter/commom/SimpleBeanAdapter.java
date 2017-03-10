package com.aspsine.mobi.basekit.base.adapter.commom;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.List;

/**
 * Created by hzf on 2017/3/7 0007.
 */

public abstract class SimpleBeanAdapter<T> extends BaseAdapter {
    public Activity activity;
    public Fragment fragment;
    public List<? extends T>  data;
    public Resources resources;
    public LayoutInflater inflater;

    public SimpleBeanAdapter(Activity activity) {
        this.activity = activity;
        this.resources = activity.getResources();
        inflater = LayoutInflater.from(activity);
    }
    public SimpleBeanAdapter(Activity activity, List<? extends T> data) {
        this(activity);//调用了上面的构造方法
        this.data = data;
    }

    public SimpleBeanAdapter(Fragment fragment) {
        this(fragment.getActivity());
        this.fragment = fragment;
    }

    public SimpleBeanAdapter(Fragment fragment, List<? extends T> data) {
        this(fragment);
        this.data = data;
    }
    @Override
    public int getCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData(List<? extends T> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

    public T getItemEntity(int position){
        return data.get(position);
    }


    public List<? extends T> getData() {
        return data;
    }

    public void refreshDatas(List<? extends T> data) {
        this.data = data;
        this.notifyDataSetInvalidated();
    }

    public void clear() {
        if (data != null) {
            data.clear();
            this.notifyDataSetChanged();
        }
    }

    public RequestManager getGlide() {
        if (fragment == null) {
            return Glide.with(activity);
        } else {
            return Glide.with(fragment);
        }
    }

    public void startActivity(Intent intent) {
        if (fragment != null) {
            fragment.startActivity(intent);
        } else {
            activity.startActivity(intent);
        }
    }

    public void startActivity(Intent intent, int requestCode) {
        if (fragment != null) {
            fragment.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }
}
