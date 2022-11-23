package org.shopproject.member.dao;

import org.shopproject.member.db.ConnectionPoolMgr;
import org.shopproject.member.db.JDBCMgr;
import org.shopproject.member.entity.Members;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberDAO {
    private static MemberDAO memberDAO = null;
    private ConnectionPoolMgr connectionPoolMgr;
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;


    //유저의 모든 정보 삽입
    private static final String MEMBER_INSERT_ALL = "INSERT INTO user_info(user_id, user_pw, user_name, user_ph, user_addr, user_point) VALUES(?, ?, ?, ?, ?, ?)";
    //유저 필수 정보만 삽입
    private static final String MEMBER_INSERT = "INSERT INTO user_info(user_id, user_pw, user_name) VALUES(?,?,?)";
    //유저 기본 정보 들고오기
    private static final String MEMBER_SELECT_ONE = "SELECT user_name, user_point FROM user_info WHERE user_id = ?";
    //전체 데이터 조회 query (디버깅용)
    private static final String MEMBER_SELECT_ALL = "SELECT * FROM user_info";
    //특정 유저 조회 (로그인 및 회원 가입 용)
    private static final String MEMBER_SELECT = "SELECT * FROM user_info WHERE user_id = ? AND user_pw = ?";
    //유저 이름 수정
    private static final String MEMBER_UPDATE_NAME = "UPDATE user_info SET user_name = ? WHERE user_serial_num = ?";
    //유저 주소 수정
    private static final String MEMBER_UPDATE_ADDRESS = "UPDATE user_info SET user_addr = ? WHERE user_serial_num = ?";
    //유저 폰 번호 수정
    private static final String MEMBER_UPDATE_PHONENUMBER = "UPDATE user_info SET user_ph = ? WHERE user_serial_num = ?";


    public MemberDAO(){
        if(connectionPoolMgr == null){
            connectionPoolMgr = ConnectionPoolMgr.getInstance();
        }
    }

    public static MemberDAO getInstance(){
        if(memberDAO == null){
            memberDAO = new MemberDAO();
        }
        return memberDAO;
    }


    public Members select(String uId, String uPw){
        Members member = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT);
            stmt.setString(1, uId);
            stmt.setString(2, uPw);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String mId = rs.getString("mId");
                String mPw = rs.getString("mPw");
                String mEmail = rs.getString("mEmail");
                member = new Members(mId, mPw, mEmail);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return member;

    }





}
