package org.shopproject.member.service;

import org.shopproject.cookies.CookieMgr;
import org.shopproject.member.dao.MemberDAO;
import org.shopproject.member.dto.MemberDTO;
import org.shopproject.member.entity.Members;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements IMemberService {
    private CookieMgr cookieMgr = CookieMgr.getInstance();
    private MemberDAO memberDAO = MemberDAO.getInstance();
    private static MemberService memberService = null;


    @Override
    public List<MemberDTO> findByUserIdOrEmail(String q) {
        return null;
    }

    @Override
    public boolean autoLogin(String autoLogin, String cookieId) {
        return false;
    }

    @Override
    public MemberDTO Login(String mId, String mPw) {
        MemberDTO memberDTO = new MemberDTO(mId, mPw);

        if (memberDTO == null) return null;

        Members member = memberDAO.select(memberDTO.getmId(), memberDTO.getmPw());//왜 null이 될까ㅏ..

        //System.out.println(member);
        if (member == null || member.getmPw() == null) return null;
        if (member.getmPw().equals(memberDTO.getmPw())) {

            return memberDTO;
        }

        return null;
    }
    @Override
    public boolean signup(String userId, String userPassword, String uEmail) {
        return false;
    }

    public MemberDTO showUserInfo(String mId){
        MemberDTO memberDTO = memberDAO.selectUserOne(mId);
        return memberDTO;
    }



}
