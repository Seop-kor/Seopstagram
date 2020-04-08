package com.instacopy.seopsta.Controller;


import com.instacopy.seopsta.Config.JwtTokenUtil;
import com.instacopy.seopsta.DTO.JwtTokenDTO;
import com.instacopy.seopsta.DTO.MemberDTO;
import com.instacopy.seopsta.Service.*;
import lombok.AllArgsConstructor;
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
public class MemberController {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService userDetailsService;
    private InstaService service;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login.action")
    public String loginaction(HttpServletRequest httpServletRequest, JwtTokenDTO jwtTokenDTO, Model model) throws Exception{
        if(!service.membercheck(MemberDTO.builder().userid(jwtTokenDTO.getUsername()).userpass(jwtTokenDTO.getPassword()).build())){
            return "redirect:/login";
        }
        String username = jwtTokenDTO.getUsername();
        authenticate(username, jwtTokenDTO.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        httpServletRequest.getSession().setAttribute("Authorization", "Bearer " + token);
        return "forward:/";
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
