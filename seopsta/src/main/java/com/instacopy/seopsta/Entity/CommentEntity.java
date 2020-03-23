package com.instacopy.seopsta.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class CommentEntity implements Serializable {
    @Indexed
    private int commentid;
    private String content;
    private int thislike;
    @CreatedDate
    private LocalDateTime commentwritetime;

    @Builder
    public CommentEntity(int commentid, String content, int thislike){
        this.commentid = commentid;
        this.content = content;
        this.thislike = thislike;
    }
}
