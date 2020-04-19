package com.instacopy.seopsta.DTO;

import com.instacopy.seopsta.Entity.BoardEntity;
import com.instacopy.seopsta.Entity.InstaEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
number   | int         | NO   | PRI | NULL    | auto_increment |
| usernick | varchar(15) | NO   | MUL | NULL    |                |
| boardimg | text        | NO   |     | NULL    |                |
| content  | text        | YES  |     | NULL    |                |
| thislike | int         | NO   |     | NULL    |                |
| hashtag  | text        | YES  |     | NULL    |
 */

@Data
@NoArgsConstructor
@ToString
public class BoardDTO {
    private String usernick;
    private String userid;
    private int boardid;
    private String boardimg;
    private String content;
    private int thislike;
    private String[] hashtag;

    public InstaEntity toEntity(){
        BoardEntity boardEntity = BoardEntity.builder().boardid(boardid).boardimg(boardimg).content(content).thislike(thislike).hashtag(hashtag).build();
        InstaEntity instaEntity = InstaEntity.builder().userid(userid).boards(boardEntity).build();
        return instaEntity;
    }
}
