package com.hsrg.service.impl;

import com.hsrg.mapper.LikeMapper;
import com.hsrg.pojo.Like;
import com.hsrg.service.LikeService;
import com.hsrg.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiki.xsx.core.snowflake.config.Snowflake;

import java.time.LocalDateTime;


@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;
    @Autowired
    private Snowflake snowflake;

    @Override
    public Long createLike(Like like) {
        like.setLikeId(snowflake.nextId());
        like.setUpdateTime(LocalDateTime.now());
        like.setCreateTime(LocalDateTime.now());
        return likeMapper.createLike(like);
    }

    @Override
    public Integer countLikeByTarget(Like like) {
        return likeMapper.countLikeByTarget(like);
    }

    @Override
    public void deleteLike(Like like, String jwt) {

        Claims claims = JwtUtils.parseJWT(jwt);
        Long userId = (Long) claims.get("userId");
        like.setUserId(userId);
        likeMapper.deleteLike(like);
    }
}
