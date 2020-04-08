package com.instacopy.seopsta.Controller;

import com.instacopy.seopsta.Config.JwtTokenUtil;
import com.instacopy.seopsta.DTO.BoardDTO;
import com.instacopy.seopsta.Service.InstaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;


@Controller
@AllArgsConstructor
public class PostingController {
    private JwtTokenUtil util;
    private InstaService service;

    @GetMapping("/post")
    public String post(HttpServletRequest req, Model model){
        model.addAttribute(util.getUsernameFromToken(req.getSession().getAttribute("Authorization").toString().substring(7)));
        return "new_post";
    }

    @PostMapping("/post.action")
    public String postaction(HttpServletRequest req, BoardDTO boardDTO) throws Exception{
        boardDTO.setUserid(util.getUsernameFromToken(req.getSession().getAttribute("Authorization").toString().substring(7)));
        service.newpost(boardDTO);
        return "forward:/";
    }

    @PostMapping("/post.Imageaction")
    public @ResponseBody boolean postimage(@RequestParam(value = "file")MultipartFile file) throws Exception{
        BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream("C:/Image/ProfileImage/"
                + file.getOriginalFilename()));
        bs.write(file.getBytes());
        bs.close();
        return true;
    }
}
