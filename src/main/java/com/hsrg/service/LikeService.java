package com.hsrg.service;

import com.hsrg.pojo.Like;

public interface LikeService {
    Long createLike(Like like);

    Integer countLikeByTarget(Like like);

    void deleteLike(Like like, String jwt);
}
