package org.shopproject.member.dto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Password {
    private String mPw = "";

    private Password() {}

    private Password(String mPw) {
        mPw = sha256(mPw);
    }


    public static Password of(String mPw) {
        Password password = new Password();
        password.setmPw(password.sha256(mPw));

        return password;
    }

    public static Password of(String mPw, boolean needEncode) {
        Password password = new Password();

        if (needEncode) {
            password.setmPw(password.sha256(mPw));
        } else {
            password.setmPw(mPw);
        }
        return password;
    }

    public String getmPw() {
        return mPw;
    }

    public void setmPw(String mPw) {
        this.mPw = mPw;
    }

    /**
     * SHA-256으로 해싱하는 메소드
     * */
    private String sha256(String password) {
        if (password == null || password.equals("")) return null;

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // 바이트를 16진수로 변환
        messageDigest.update(password.getBytes());
        return String.format("%064x", new BigInteger(1, messageDigest.digest()));

    }

    /**
     * SHA-512으로 해싱하는 메소드
     * */
    private String sha512(String password) {
        if (password == null || password.equals("")) return null;

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // 바이트를 16진수로 변환
        messageDigest.update(password.getBytes());
        return String.format("%0128x", new BigInteger(1, messageDigest.digest()));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return mPw.equals(password.mPw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mPw);
    }

    @Override
    public String toString() {
        return "Password{" +
                "mPw='" + mPw + '\'' +
                '}';
    }
}
