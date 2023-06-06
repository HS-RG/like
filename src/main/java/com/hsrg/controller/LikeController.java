package com.hsrg.controller;

import com.hsrg.pojo.Like;
import com.hsrg.pojo.Result;
import com.hsrg.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/like/createLike")
    public Result createLike(@RequestBody Like like){
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
}
