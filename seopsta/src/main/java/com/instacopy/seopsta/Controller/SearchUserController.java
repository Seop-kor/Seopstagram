package com.instacopy.seopsta.Controller;

import com.instacopy.seopsta.Config.JwtTokenUtil;
import com.instacopy.seopsta.DTO.FollowingDTO;
import com.instacopy.seopsta.Entity.BoardEntity;
import com.instacopy.seopsta.Entity.InstaEntity;
import com.instacopy.seopsta.Service.InstaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class SearchUserController {
    private InstaService service;
    private JwtTokenUtil util;

    @GetMapping("/find")
    public String find(@RequestParam(value = "usernick")String nick, Model model) throws Exception{
        InstaEntity entity = service.userfind(nick);
        model.addAttribute("userprofileimg",entity.getUserprofileimg());
        model.addAttribute("usernick",entity.getUsernick());
        model.addAttribute("userid",entity.getUserid());
        model.addAttribute("board_count",entity.boardsize());
        model.addAttribute("follower_count",entity.followersize());
        model.addAttribute("following_count",entity.followingsize());
        model.addAttribute("boards",(List<BoardEntity>) entity.getBoards());
        return "searchuser"; //여기 프로필 화면으로 바꿔야함
    }

    @PostMapping("/follow")
    public @ResponseBody
    boolean follow(FollowingDTO followingDTO , HttpServletRequest req) throws Exception{
        service.following(followingDTO, util.getUsernameFromToken(req.getSession().getAttribute("Authorization").toString().substring(7)));
        return true;
    }

    @PostMapping("/unfollow")
    public @ResponseBody boolean unfollow(FollowingDTO followingDTO, HttpServletRequest req){
        return true;
    }
}
