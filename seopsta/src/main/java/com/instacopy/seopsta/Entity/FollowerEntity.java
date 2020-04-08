package com.instacopy.seopsta.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FollowerEntity {
    private int followernumber;
    private String follwerid;
    private String follwernick;

    @Builder
    public FollowerEntity(int followernumber, String follwerid, String follwernick){
        this.followernumber = followernumber;
        this.follwerid = follwerid;
        this.follwernick = follwernick;
    }
}
