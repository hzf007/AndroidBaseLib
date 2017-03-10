package com.aspsine.mobi.androidbaselib.model;

import android.database.sqlite.SQLiteDatabase;

import com.aspsine.mobi.androidbaselib.MyApp;
import com.aspsine.mobi.androidbaselib.entity.DaoMaster;
import com.aspsine.mobi.androidbaselib.entity.DaoSession;
import com.aspsine.mobi.androidbaselib.entity.SearchM;
import com.aspsine.mobi.androidbaselib.entity.SearchMDao;

import java.util.List;

/**
 * Created by hzf 2017/3/8 0008 on 下午 6:40.
 * description :
 */

public class DBhelper {
    private final SearchMDao searchMDao;
    public DBhelper() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(), "simple-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        searchMDao = daoSession.getSearchMDao();
    }

    /**
     * 存历史搜索记录
     *
     * @param mSearchM
     */
    public void saveHistoryKey(SearchM mSearchM) {
        List<SearchM> list = searchMDao.queryBuilder()
                .where(SearchMDao.Properties.KeyName.eq(mSearchM.getKeyName()))
                .list();
        if (list == null || list.size() == 0) {
            searchMDao.insert(mSearchM);
        }
    }


    /**
     * 读取前N条历史搜索
     */

    public List<SearchM> selectHistoryKey(int rank) {
        List<SearchM> searchMs = searchMDao.queryBuilder().orderDesc(SearchMDao.Properties.Id).list();
        if (searchMs.size() > rank) {
            return searchMs.subList(0, rank);
        } else {
            return searchMs;
        }
    }

    /**
     * 根据内容查询
     */

    public List<SearchM> selectHistoryKey(String key) {
        List<SearchM> searchMs = searchMDao.queryBuilder().where(SearchMDao.Properties.KeyName.like("%" + key + "%")).orderDesc(SearchMDao.Properties.Id).list();
        return searchMs;
    }
}
