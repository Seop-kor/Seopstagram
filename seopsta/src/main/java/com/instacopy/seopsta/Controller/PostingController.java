package com.instacopy.seopsta.Controller;

import com.instacopy.seopsta.DTO.BoardDTO;
import com.instacopy.seopsta.Service.InstaService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;


@Controller
@Log
public class PostingController {
    public PostingController(InstaService service){
        this.service = service;
    }
    private InstaService service;
    private String filename;

    @GetMapping("/post")
    public String post(){
//        model.addAttribute(request.getSession().getAttribute("usernick"));
//        return "new_post";
        return "redirect:/post_link";
    }

    @GetMapping("/post_link")
    public String postlink(){
        return "new_post";
    }

    @PostMapping("/post.action")
    public String postaction(HttpServletRequest req, BoardDTO boardDTO) throws Exception{
        boardDTO.setUsernick(req.getSession().getAttribute("usernick").toString());
        boardDTO.setBoardimg(filename);
        service.newpost(boardDTO);
        return "redirect:/";
    }

    @PostMapping("/post.Imageaction")
    public @ResponseBody boolean postimage(@RequestParam(value = "file")MultipartFile file) throws Exception{
        BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream("C:/Users/Seop/IdeaProjects/seopsta/src/main/resources/static/imgs/"
                + file.getOriginalFilename()));
        bs.write(file.getBytes());
        filename ="/imgs/" + file.getOriginalFilename();
        bs.close();
        return true;
    }
}
