package com.aspsine.mobi.androidbaselib.iview;

import com.aspsine.mobi.androidbaselib.entity.GankM;
import com.aspsine.mobi.androidbaselib.entity.SearchM;
import com.aspsine.mobi.basekit.base.iview.IBaseView;

import java.util.List;

/**
 * Created by hzf 2017/3/8 0008 on 下午 6:58.
 * description :
 */

public interface GankSearchIView extends IBaseView {

    void showList(List<GankM> gankMs);

    void lodinHistory(List<SearchM> mList);
}
