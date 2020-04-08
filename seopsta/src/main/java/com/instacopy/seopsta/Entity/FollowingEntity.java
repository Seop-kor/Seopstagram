package com.instacopy.seopsta.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FollowingEntity {
    private int followingnumber;
    private String followingid;
    private String followingnick;

    @Builder
    public FollowingEntity(int followingnumber, String followingid, String followingnick){
        this.followingid = followingid;
        this.followingnumber = followingnumber;
        this.followingnick = followingnick;
    }
}
