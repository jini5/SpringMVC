package org.shopproject.member.service;

import org.shopproject.member.dto.MemberDTO;

import java.util.List;

public interface IMemberService {

    List<MemberDTO> findByUserIdOrEmail(String q);

    boolean autoLogin(String autoLogin, String cookieId);

    MemberDTO Login(String mId, String mPw);

    boolean signup(String userId, String userPassword, String uEmail);
}
