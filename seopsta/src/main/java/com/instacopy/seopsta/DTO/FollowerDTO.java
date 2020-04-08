package com.instacopy.seopsta.DTO;

import com.instacopy.seopsta.Entity.FollowerEntity;
import com.instacopy.seopsta.Entity.InstaEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class FollowerDTO {
    private int followernumber;
    private String follwerid;
    private String follwernick;

    public InstaEntity toEntity(){
        FollowerEntity followerEntity = FollowerEntity.builder().followernumber(followernumber).follwerid(follwerid).follwernick(follwernick).build();
        InstaEntity instaEntity = InstaEntity.builder().followers(followerEntity).build();
        return instaEntity;
    }

    @Builder
    public FollowerDTO(int followernumber, String follwerid, String follwernick){
        this.followernumber = followernumber;
        this.follwerid = follwerid;
        this.follwernick = follwernick;
    }
}
