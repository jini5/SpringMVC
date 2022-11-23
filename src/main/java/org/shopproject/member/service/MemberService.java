package org.shopproject.member.service;

import org.shopproject.cookies.CookieMgr;
import org.shopproject.member.dao.MemberDAO;

public class MemberService {
    private CookieMgr cookieMgr = CookieMgr.getInstance();
    private MemberDAO memberDAO = MemberDAO.getInstance();
    private static MemberService memberService = null;




}
