package com.lauzy.freedom.data.entity.mapper;

import com.freedom.lauzy.model.SongListBean;
import com.lauzy.freedom.data.entity.SongListEntity;
import com.lauzy.freedom.data.local.LocalUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Desc : SongListMapper 转换实体类
 * Author : Lauzy
 * Date : 2017/7/11
 * Blog : http://www.jianshu.com/u/e76853f863a9
 * Email : freedompaladin@gmail.com
 */
@Singleton
public class SongListMapper {

    @Inject
    public SongListMapper() {
    }

    /**
     * 转换 entity
     *
     * @param entity 实体对象
     * @return 转换后的实体对象
     */
    @SuppressWarnings("all")
    public SongListBean transform(SongListEntity entity) {
        SongListBean songListBean = null;
        if (entity != null) {
            songListBean = new SongListBean();
            songListBean.language = entity.language;
            songListBean.imgUrl = entity.pic_big;
            songListBean.publishTime = entity.publishtime;
            songListBean.lrcLink = entity.lrclink;
            songListBean.versions = entity.versions;
            songListBean.info = entity.info;
            songListBean.songId = entity.song_id;
            songListBean.title = entity.title;
            songListBean.tingUid = entity.ting_uid;
            songListBean.author = entity.author;
            songListBean.albumId = entity.album_id;
            songListBean.albumTitle = entity.album_title;
            songListBean.artistId = entity.artist_id;
            songListBean.artistName = entity.artist_name;
            songListBean.rank = entity.rank;
            songListBean.duration = entity.file_duration;
            songListBean.songLength = LocalUtil.formatTime(entity.file_duration);
        }
        return songListBean;
    }

    /**
     * 转换entity集合
     *
     * @param entities 集合
     * @return 转换后的集合
     */
    public List<SongListBean> transform(List<SongListEntity> entities) {
        List<SongListBean> songListBeen;
        if (entities != null && !entities.isEmpty()) {
            songListBeen = new ArrayList<>();
            for (SongListEntity entity : entities) {
                SongListBean bean = transform(entity);
                if (bean != null) {
                    songListBeen.add(bean);
                }
            }
        } else {
            songListBeen = Collections.emptyList();
        }
        return songListBeen;
    }
}
