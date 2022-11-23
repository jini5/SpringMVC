package org.shopproject.member.controller.nonlogin;

import org.shopproject.cookies.CookieMgr;
import org.shopproject.member.entity.Members;
import org.shopproject.member.service.MemberService;
import org.shopproject.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
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
    public String loginPage(HttpServletRequest request, HttpSession session){

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


}
