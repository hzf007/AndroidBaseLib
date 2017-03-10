package com.aspsine.mobi.androidbaselib.adapter;

import android.view.View;

import com.aspsine.mobi.androidbaselib.R;
import com.aspsine.mobi.androidbaselib.entity.SearchM;
import com.aspsine.mobi.androidbaselib.presenter.GankSearchPresenter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by hzf 2017/3/8 0008 on 下午 7:02.
 * description :
 */

public class HistoryAdaper extends BaseQuickAdapter<SearchM, BaseViewHolder> {
    private final GankSearchPresenter mgankSearchPresenter1;

    public HistoryAdaper(List<SearchM> items, GankSearchPresenter mgankSearchPresenter) {
        super(R.layout.history_item, items);
        mgankSearchPresenter1 = mgankSearchPresenter;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final SearchM item) {
        viewHolder.setText(R.id.title, item.getKeyName());
        viewHolder.getView(R.id.title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mgankSearchPresenter1.findContentForGank(item.getKeyName());
            }
        });
    }
}
