package com.goodbuild.majiang.domain;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xue.l
 * @Date: 2018/10/12 14:05
 * @Description:
 * @Version: 1.0.0
 */
public class PlayInfoList {

    private static final ConcurrentHashMap<Long, PlayInfo> PLAY_INFO_CONCURRENT_HASH_MAP = new ConcurrentHashMap<>();

    public PlayInfo addPlayInfo(PlayInfo playInfo) {
        PlayInfo pi = PLAY_INFO_CONCURRENT_HASH_MAP.putIfAbsent(playInfo.getPlayId(), playInfo);
        return  pi == null ? playInfo : pi;
    }

    public PlayInfo getPlayInfo(Long playId) {
        return PLAY_INFO_CONCURRENT_HASH_MAP.get(playId);
    }
}
