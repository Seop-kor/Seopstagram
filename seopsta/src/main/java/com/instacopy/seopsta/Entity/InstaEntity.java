package com.instacopy.seopsta.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Document(collection = "instadb")
@EntityListeners(AuditingEntityListener.class)
public class InstaEntity implements Serializable {
    @Id
    private String id;
    private String userid;
    private String userpass;
    private String usernick;
    private String userprofileimg;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime initdate;
    @LastModifiedDate
    private LocalDateTime updatedate;
    private Object boards;
    private Object followers;
    private Object followings;

    @Builder
    public InstaEntity(String id, String userid, String userpass, String usernick, String userprofileimg, BoardEntity boards, FollowerEntity followers, FollowingEntity followings){
        this.id = id;
        this.userid = userid;
        this.userpass = userpass;
        this.usernick = usernick;
        this.userprofileimg = "C:\\Image\\ProfileImage\\" + userprofileimg;
        this.boards = boards;
        this.followers = followers;
        this.followings = followings;
    }

    public InstaEntity(String id, String userid, String userpass, String usernick, String userprofileimg, List<BoardEntity> boards, List<FollowerEntity> followers, List<FollowingEntity> followings){
        this.id = id;
        this.userid = userid;
        this.userpass = userpass;
        this.usernick = usernick;
        this.userprofileimg = userprofileimg;
        this.boards = boards;
        this.followers = followers;
        this.followings = followings;
    }

    public int boardsize(){
        if(boards != null){
            List<BoardEntity> list = (List<BoardEntity>)boards;
            return list.size();
        }
        return 0;
    }

    public int followersize(){
        if(followers != null){
            List<FollowerEntity> list = (List<FollowerEntity>)followers;
            return list.size();
        }
        return 0;
    }

    public int followingsize(){
        if(followers != null){
            List<FollowingEntity> list = (List<FollowingEntity>)followings;
            return list.size();
        }
        return 0;
    }
}
