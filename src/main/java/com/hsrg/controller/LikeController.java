package com.hsrg.controller;

import com.hsrg.pojo.Like;
import com.hsrg.pojo.Result;
import com.hsrg.service.LikeService;
import com.hsrg.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/like/createLike")
    public Result createLike(@RequestBody Like like){
        return Result.success(likeService.createLike(like));
    }

    @PostMapping("/like/createMyLike")
    public Result createMyLike(@RequestBody Like like,@RequestHeader("Authorization") String jwt) {
        Claims claims = JwtUtils.parseJWT(jwt);
        Long userId = (Long) claims.get("userId");
        like.setUserId(userId);
        return Result.success(likeService.createLike(like));
    }

    @PostMapping("/like/deleteSelfLike")
    public Result deleteLike(@RequestBody Like like,@RequestHeader("Authorization") String jwt){
        likeService.deleteLike(like, jwt);
        return Result.success();
    }

    @PostMapping("/like/countLikeByTarget")
    public Result countLikeByTarget(@RequestBody Like like){
        return Result.success(likeService.countLikeByTarget(like));
    }

    @PostMapping("/like/determineIsLiked")
    public Result determineIsLiked(@RequestHeader("Authorization")String jwt, @RequestBody Like like){
        Claims claims=JwtUtils.parseJWT(jwt);
        Long userId = (Long) claims.get("userId");
        if(likeService.determineIsLiked(userId,like)!=null){
            return Result.success(true);
        }
        return Result.success(false);
    }
}
