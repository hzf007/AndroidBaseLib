package com.aspsine.mobi.androidbaselib.model;

import android.content.Context;

import com.aspsine.mobi.androidbaselib.MyApp;
import com.aspsine.mobi.androidbaselib.entity.GankM;
import com.aspsine.mobi.androidbaselib.entity.SearchM;
import com.aspsine.mobi.basekit.base.model.BaseModel;
import com.aspsine.mobi.common.net.api.ApiService;
import com.aspsine.mobi.common.net.api.ViseApi;
import com.aspsine.mobi.common.utils.JLog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by hzf 2017/3/8 0008 on 下午 6:40.
 * description :
 */

public class GankSearchMode extends BaseModel {
    private DBhelper dBhelper;



    public GankSearchMode(Context context) {
        super(context);
        dBhelper = new DBhelper();
    }

    /**
     * 根据内容查询
     *
     * @param content
     * @param mObservable
     */
    public void findContentForGank(final String content, Observer<List<GankM>> mObservable) {
//        Map<String, String> map=new HashMap<String,String>();
//        map.put("q",content);
//        Observable<List<GankM>> responseBodyObservable1 = MyApp.getMyApp().getViseApi()
//                .apiGet("search",map,GankM.class)
//                .map(new Func1<GankM, List<GankM>>() {
//                    @Override
//                    public List<GankM> call(GankM gankM) {
//                        JLog.e(gankM.getUrl());
//                        List<GankM> list = new ArrayList<GankM>();
//                        if (gankM != null){
//                            list.add(gankM);
//                        }
//                        return list;
//                    }
//                });

        GankApi gankApi = MyApp.getMyApp().getRetrofit().create(GankApi.class);
        Observable<List<GankM>> responseBodyObservable = gankApi.Search(content).map(new Func1<ResponseBody, List<GankM>>() {
            @Override
            public List<GankM> call(ResponseBody responseBody) {
                ArrayList<GankM> listGankM = new ArrayList<>();
                try {
                    Document doc = Jsoup.parse(responseBody.string());
                    Elements total = doc.getElementsByTag("ol");
                    Elements items = total.select("li");
                    for (Element element : items) {
                        String title, type, source, url;
                        Elements a = element.getElementsByTag("a");
                        title = a.text();
                        url = a.attr("href");
                        type = element.getElementsByTag("small").text();
                        source = element.getElementsByClass("u-pull-right").text();
                        GankM item = new GankM(title, type, source, url);
                        listGankM.add(item);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return listGankM;
            }
        });

        subscribe(responseBodyObservable, mObservable);
    }

    /**
     * 存历史搜索记录
     *
     * @param mSearchM
     */
    public void saveHistoryKey(final SearchM mSearchM) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dBhelper.saveHistoryKey(mSearchM);
            }
        }).start();

    }


    /**
     * 读取前N条历史搜索
     *
     * @param mObservable
     */
    public void selectHistoryKey(final int rank, Observer<List<SearchM>> mObservable) {
        Observable<List<SearchM>> listObservable = Observable.create(new Observable.OnSubscribe<List<SearchM>>() {
            @Override
            public void call(Subscriber<? super List<SearchM>> subscriber) {
                List<SearchM> searchMs = dBhelper.selectHistoryKey(rank);
                subscriber.onNext(searchMs);
            }
        });
        subscribe(listObservable, mObservable);

    }
    /**
     * 根据那内容查询
     *
     * @param mObservable
     */
    public void selectHistoryKey(final String key, Observer<List<SearchM>> mObservable) {
        Observable<List<SearchM>> listObservable = Observable.create(new Observable.OnSubscribe<List<SearchM>>() {
            @Override
            public void call(Subscriber<? super List<SearchM>> subscriber) {
                List<SearchM> searchMs = dBhelper.selectHistoryKey(key);
                subscriber.onNext(searchMs);
            }
        });
        subscribe(listObservable, mObservable);

    }
}
