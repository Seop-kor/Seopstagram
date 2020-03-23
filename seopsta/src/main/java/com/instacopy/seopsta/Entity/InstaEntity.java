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
import java.util.ArrayList;
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
    private Object follwers;

    @Builder
    public InstaEntity(String id, String userid, String userpass, String usernick, String userprofileimg, BoardEntity boards, FollowerEntity follwers){
        this.id = id;
        this.userid = userid;
        this.userpass = userpass;
        this.usernick = usernick;
        this.userprofileimg = userprofileimg;
        this.boards = boards;
        this.follwers = follwers;
    }

    public InstaEntity(String id, String userid, String userpass, String usernick, String userprofileimg, List<BoardEntity> boards, List<FollowerEntity> follwers){
        this.id = id;
        this.userid = userid;
        this.userpass = userpass;
        this.usernick = usernick;
        this.userprofileimg = userprofileimg;
        this.boards = boards;
        this.follwers = follwers;
    }

    public int boardsize(){
        List<BoardEntity> list = (List<BoardEntity>)boards;
        return list.size();
    }
}
