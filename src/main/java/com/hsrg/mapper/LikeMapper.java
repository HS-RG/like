package com.hsrg.mapper;

import com.hsrg.pojo.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface LikeMapper {

    @Insert("insert into `like` (like_id, user_id, target_id, target_type, update_time, create_time)" +
     "values (#{likeId}, #{userId}, #{targetId}, #{targetType}, #{updateTime}, #{createTime})")
    Long createLike(Like like);

    @Select("select count(*) from `like`  where target_id = #{targetId} and target_type = #{targetType}")
    Integer countLikeByTarget(Like like);

    @Delete("delete from `like` where user_id = #{userId} and target_id = #{targetId} and target_type = #{targetType}")
    void deleteLike(Like like);

    @Select("select * from `like` where user_id =#{userId} and target_id=#{targetId} and target_type =#{targetType}")
    Boolean selectByUserIdAndFileId(Long userId, Long targetId,Integer targetType);
}
