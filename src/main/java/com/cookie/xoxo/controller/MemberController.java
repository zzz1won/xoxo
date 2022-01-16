package com.cookie.xoxo.controller;

import com.cookie.xoxo.dto.MemberDetailDTO;
import com.cookie.xoxo.dto.MemberLoginDTO;
import com.cookie.xoxo.dto.MemberSaveDTO;
import com.cookie.xoxo.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.List;

import static com.cookie.xoxo.common.SessionConst.Login_Email;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceImpl ms;

    @GetMapping ("save")
    public String saveForm()    {
        System.out.println("MemberController.saveForm");
        return "/member/save";
    }

    @PostMapping("save")
    public String save(@ModelAttribute MemberSaveDTO memberSaveDTO)    {
        System.out.println("MemberController.save");
        Long memberId = ms.save(memberSaveDTO);
        return "/member/login";
    }

    @GetMapping ("login")
    public String loginForm()   {
        System.out.println("MemberController.loginForm");
        return "/member/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute MemberLoginDTO memberLoginDTO, HttpSession loginSession)  {
        System.out.println("MemberController.login");
        boolean loginResult = ms.login(memberLoginDTO);
            if(loginResult)   {
                /*loginSession.setAttribute("loginEmail", memberLoginDTO.getMemberEmail());*/
                loginSession.setAttribute(Login_Email, memberLoginDTO.getMemberEmail());
                /*return "/index";*/
                return "redirect:/member/";
            } else  {
                return "/member/login";
            }
    }

    @GetMapping
    public String findAll(Model model)  {
        List<MemberDetailDTO> memberList = ms.findAll();
        model.addAttribute("memberList", memberList);
        return "/member/findAll";
    }

    @GetMapping("{memberId}")
    public String findById(Model model, @PathVariable("memberId") Long memberId)    {
        MemberDetailDTO member = ms.findById(memberId);
        model.addAttribute("member", member);
        return "/member/findById";
    }
}
