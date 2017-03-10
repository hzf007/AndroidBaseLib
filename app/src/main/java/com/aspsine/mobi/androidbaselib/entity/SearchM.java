package com.aspsine.mobi.androidbaselib.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by hzf 2017/3/8 0008 on 下午 6:42.
 * description :
 */
@Entity
public class SearchM {
    @Id(autoincrement = true)
    private Long id;
    private String keyName;

    @Generated(hash = 1894705078)
    public SearchM(Long id, String keyName) {
        this.id = id;
        this.keyName = keyName;
    }

    @Generated(hash = 351106736)
    public SearchM() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}
