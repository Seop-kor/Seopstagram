package com.instacopy.seopsta.Controller;

import com.instacopy.seopsta.Config.JwtTokenUtil;
import com.instacopy.seopsta.DTO.BoardDTO;
import com.instacopy.seopsta.DTO.FollowingDTO;
import com.instacopy.seopsta.Entity.BoardEntity;
import com.instacopy.seopsta.Entity.FollowingEntity;
import com.instacopy.seopsta.Entity.InstaEntity;
import com.instacopy.seopsta.Service.InstaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private JwtTokenUtil util;
    private InstaService service;
//    @GetMapping("/")
//    public String home(@RequestParam(name="name", required = false, defaultValue = "YuInseop")String name, Model model){
//        model.addAttribute("name", name);
//        return "index";
//    }
    @RequestMapping("/")
    public String home(HttpServletRequest req, Model model) throws Exception{
        InstaEntity instaEntity = service.boards(util.getUsernameFromToken(req.getSession().getAttribute("Authorization").toString().substring(7)));
        InstaEntity instaEntity1;
        List<BoardEntity> boards = new ArrayList<>();
        if(instaEntity.getFollowings() != null){
            for(FollowingDTO e : (List<FollowingDTO>)instaEntity.getFollowings()){
                instaEntity1 = service.boards(e.getFollowingid());
                if(instaEntity1.getBoards() != null){
                    for(BoardEntity t : (List<BoardEntity>)instaEntity1.getBoards()){
                        t.setUserprofileimg(instaEntity1.getUserprofileimg());
                        t.setUsernick(e.getFollowingnick());
                        boards.add(t);
                    }
                }
            }
        }
        model.addAttribute("boards",boards);
        return "index";
    }

//    @PostMapping("/following")
//    public @ResponseBody boolean following(FollowingDTO followingDTO ,HttpServletRequest req) throws Exception{
//        service.following(followingDTO, util.getUsernameFromToken(req.getSession().getAttribute("Authorization").toString().substring(7)));
//        return true;
//    }
}
