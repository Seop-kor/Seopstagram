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
    private String id;
    private String follwerid;
    private String follwernick;

    public InstaEntity toEntity(){
        FollowerEntity followerEntity = FollowerEntity.builder().id(id).follwerid(follwerid).follwernick(follwernick).build();
        InstaEntity instaEntity = InstaEntity.builder().follwers(followerEntity).build();
        return instaEntity;
    }

    @Builder
    public FollowerDTO(String id, String follwerid, String follwernick){
        this.id = id;
        this.follwerid = follwerid;
        this.follwernick = follwernick;
    }
}
