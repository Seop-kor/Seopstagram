package com.instacopy.seopsta.DTO;

import com.instacopy.seopsta.Entity.InstaEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MemberDTO {
    private String id;
    private String userid;
    private String userpass;
    private String usernick;
    private String userprofileimg;

    public InstaEntity toEntity(){
        InstaEntity instaEntity = InstaEntity.builder().userid(userid).userpass(userpass).usernick(usernick).userprofileimg(userprofileimg)
                .id(id).build();
        return instaEntity;
    }

    @Builder
    public MemberDTO(String id, String userid, String userpass, String usernick, String userprofileimg){
        this.id = id;
        this.userid = userid;
        this.userpass = userpass;
        this.usernick = usernick;
        this.userprofileimg = "C:\\Image\\ProfileImage\\" + userprofileimg;
    }
}
