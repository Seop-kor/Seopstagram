package com.instacopy.seopsta.DTO;

import com.instacopy.seopsta.Entity.CommentEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
+----------+------+------+-----+---------+----------------+
| Field    | Type | Null | Key | Default | Extra          |
+----------+------+------+-----+---------+----------------+
| no       | int  | NO   | PRI | NULL    | auto_increment |
| number   | int  | NO   | MUL | NULL    |                |
| memberid | int  | NO   | MUL | NULL    |                |
| content  | text | NO   |     | NULL    |                |
| thislike | int  | NO   |     | NULL    |                |
+----------+------+------+-----+---------+----------------+
 */
@Data
@NoArgsConstructor
@ToString
public class CommentDTO {
    private int commentid;
    private String content;
    private int thislike;

    public CommentEntity toEntity(){
        CommentEntity commentEntity = CommentEntity.builder().commentid(commentid).content(content).thislike(thislike).build();
        return commentEntity;
    }

    @Builder
    public CommentDTO(int commentid, String content, int thislike){
        this.commentid=commentid;
        this.content = content;
        this.thislike = thislike;
    }
}
