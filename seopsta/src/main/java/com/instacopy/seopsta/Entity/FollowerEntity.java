package com.instacopy.seopsta.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FollowerEntity {
    private String id;
    private String follwerid;
    private String follwernick;

    @Builder
    public FollowerEntity(String id, String follwerid, String follwernick){
        this.id = id;
        this.follwerid = follwerid;
        this.follwernick = follwernick;
    }
}
