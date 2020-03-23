package com.instacopy.seopsta.Controller;


import com.instacopy.seopsta.Config.JwtTokenUtil;
import com.instacopy.seopsta.DTO.ClientDTO;
import com.instacopy.seopsta.DTO.JwtTokenDTO;
import com.instacopy.seopsta.DTO.MemberDTO;
import com.instacopy.seopsta.Entity.InstaEntity;
import com.instacopy.seopsta.Service.*;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@AllArgsConstructor
@Log
public class MemberController {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService userDetailsService;
    private InstaService service;
    private ClientService cliservice;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login.action")
    public String loginaction(HttpServletRequest httpServletRequest, JwtTokenDTO jwtTokenDTO, Model model) throws Exception{
        if(!service.membercheck(MemberDTO.builder().userid(jwtTokenDTO.getUsername()).userpass(jwtTokenDTO.getPassword()).build())){
            return "redirect:/login";
        }
        authenticate(jwtTokenDTO.getUsername(), jwtTokenDTO.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtTokenDTO.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setToken(token);
        clientDTO.setUserid(jwtTokenDTO.getUsername().toCharArray());
        httpServletRequest.getSession().setAttribute("token",token);
        httpServletRequest.getSession().setAttribute("usernick", service.eqaulUserid(jwtTokenDTO.getUsername()).getUsernick());
        httpServletRequest.getSession().setAttribute("boards",service.boards(jwtTokenDTO.getUsername()));
        cliservice.setToken(clientDTO);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signup(){
        return "register";
    }

    @PostMapping("/signup.action")
    public String signupaction(MemberDTO memberDTO) throws Exception{
        service.register(memberDTO);
        return "redirect:/login"; //redirect를 써야할까 forward를 써야할까?
    }

    @GetMapping("/idcheck")
    public @ResponseBody boolean check(@RequestParam(value = "id")String id) throws Exception{
        return service.check(id);
    }

    @GetMapping("/find")
    public String find(@RequestParam(value = "id")String nick, Model model) throws Exception{
        InstaEntity entity = service.userfind(nick);
        model.addAttribute("nick", entity.getUsernick());
        return null; //여기 프로필 화면으로 바꿔야함
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    private void authenticate(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("user_Disabled", e);
        }catch (BadCredentialsException e){
            throw new Exception("invalid_credentials",e);
        }
    }

}
