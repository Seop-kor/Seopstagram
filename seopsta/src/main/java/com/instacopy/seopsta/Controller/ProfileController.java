package com.instacopy.seopsta.Controller;

import com.instacopy.seopsta.Config.JwtTokenUtil;
import com.instacopy.seopsta.DTO.MemberDTO;
import com.instacopy.seopsta.Entity.BoardEntity;
import com.instacopy.seopsta.Entity.InstaEntity;
import com.instacopy.seopsta.Service.InstaService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProfileController {
    private InstaService instaService;
    private JwtTokenUtil util;

    @RequestMapping("/profile")
    public String profile(HttpServletRequest req ,Model model) throws Exception{
        InstaEntity instaEntity = instaService.eqaulUserid(util.getUsernameFromToken(req.getSession().getAttribute("Authorization").toString().substring(7)));
        model.addAttribute("profileimg",instaEntity.getUserprofileimg());
        model.addAttribute("usernick",instaEntity.getUsernick());
        model.addAttribute("board_count",instaEntity.boardsize());
        model.addAttribute("follower_count",instaEntity.followersize());
        model.addAttribute("following_count",instaEntity.followingsize());
        model.addAttribute("boards",(List<BoardEntity>) instaEntity.getBoards());
        return "profile";
    }

    @GetMapping("/logoutgg")
    public String logout(HttpServletRequest req) throws Exception{
        HttpSession session = req.getSession();
        session.removeAttribute("Authorization");
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/profile_change")
    public String change(){
        return "profile_change";
    }

    @PostMapping("/profile_change.action")
    public String profile_change(MemberDTO memberDTO, HttpServletRequest req) throws Exception{
        instaService.memberchange(memberDTO, util.getUsernameFromToken(req.getSession().getAttribute("Authorization").toString().substring(7)));
        return "forward:/profile";
    }

    @PostMapping("/profileimg.action")
    public @ResponseBody boolean imgaction(@RequestParam(value = "file") MultipartFile file) throws Exception{
        BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream("C:/Image/ProfileImage/"
                + file.getOriginalFilename()));
        bs.write(file.getBytes());
        bs.close();
        return true;
    }

}