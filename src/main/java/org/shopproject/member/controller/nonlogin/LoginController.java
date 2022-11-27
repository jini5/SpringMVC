package org.shopproject.member.controller.nonlogin;

import org.shopproject.cookies.CookieMgr;
import org.shopproject.member.dto.MemberDTO;
import org.shopproject.member.entity.Members;
import org.shopproject.member.service.MemberService;
import org.shopproject.sessions.SessionMgr;
import org.shopproject.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private SessionMgr sessionMgr; // = SessionMgr.getInstance();
    private CookieMgr cookieMgr; // = CookieMgr.getInstance();
    private MemberService memberService ; //= MemberService.getInstance();


    @Autowired
    public LoginController(SessionMgr sessionMgr, CookieMgr cookieMgr, MemberService memberService){
        this.sessionMgr= sessionMgr;
        this.cookieMgr = cookieMgr;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String LoginPage(HttpServletRequest request, HttpSession session){

        if(session.getAttribute("SESSION_ID")!=null){
            return "redirect:/";
        }

        String autoLogin = cookieMgr.get(request, "AUTO_LOGIN");
        String cookieId = cookieMgr.get(request, "COOKIE_ID");


        if (autoLogin != null && cookieId != null) {
            if (memberService.autoLogin(autoLogin, cookieId)) {
                sessionMgr.create(session, cookieId);
                return "redirect:/";
            }
        }

        return "login";
    }


    @PostMapping("/Login")
    public String doLogin(@RequestParam String userId,
                          @RequestParam String userPw,
                          @RequestParam(required = false) String save,
                          Model model,
                          HttpServletRequest request,
                          HttpSession session,
                          HttpServletResponse response){

        String view = LoginPage(request, session); // Login.jsp
        Status respStatus = Status.FAIL;
        MemberDTO memberDTO = memberService.Login(userId, userPw);

        if (memberDTO != null) { //userDTO에 정보가 담겨 있을 때

            sessionMgr.create(session, userId); //세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관

            model.addAttribute("userId", session.getAttribute("SESSION_ID"));

            view = "redirect:/";
            respStatus = Status.SUCCESS;
        }

        session.setAttribute("Login", respStatus);
        return view;



    }



}
