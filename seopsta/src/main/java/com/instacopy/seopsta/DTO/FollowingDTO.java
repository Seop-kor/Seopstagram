package com.instacopy.seopsta.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class FollowingDTO {
    private int followingnumber;
    private String followingid;
    private String followingnick;

    @Builder
    public FollowingDTO(int followingnumber, String followingid, String followingnick){
        this.followingnumber = followingnumber;
        this.followingid = followingid;
        this.followingnick = followingnick;
    }
}
