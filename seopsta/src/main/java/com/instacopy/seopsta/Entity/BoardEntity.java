package com.instacopy.seopsta.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.EntityListeners;
import javax.xml.stream.events.Comment;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class BoardEntity implements Serializable {
    private int boardid;
    private String boardimg;
    private String content;
    private int thislike;
    @CreatedDate
    private LocalDateTime writedate;
    private String[] hashtag;
    private Object comments;

    @Builder
    public BoardEntity(int boardid, String boardimg, String content, int thislike, String[] hashtag, CommentEntity comment){
        this.boardid = boardid;
        this.boardimg = boardimg;
        this.content = content;
        this.thislike = thislike;
        this.hashtag = hashtag;
        this.comments = comment;
    }

    public BoardEntity(int boardid, String boardimg, String content, int thislike, String[] hashtag, List<CommentEntity> comment){
        this.boardid = boardid;
        this.boardimg = boardimg;
        this.content = content;
        this.thislike = thislike;
        this.hashtag = hashtag;
        this.comments = comment;
    }

    public int commentsize(){
        return ((List<CommentEntity>)comments).size();
    }
}
