package org.shopproject.member.entity;

public class Members {
    private String userSerialNum;
    private String mId = "";
    private String mPw = "";
    private String mEmail = "";
    private String mName = "";
    private String mAddress = "";
    private String mPhoneNumber = "";
    private int mPoint;
    private String mMoney = "";
    private String mCardCompany = "";
    private String mCardNumber = "";

    public Members(String mId, String mPw, String mEmail) {
    }

    public Members(String mId, String mId1, String mPw, String mName, String mAddress, String mPhoneNumber, String valueOf, String mMoney, String mCardCompany, String mCardNumber) {
    }


    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmPw() {
        return mPw;
    }

    public void setmPw(String wPw) {
        this.mPw = wPw;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public int getmPoint() {
        return mPoint;
    }

    public void setmPoint(int mPoint) {
        this.mPoint = mPoint;
    }

    public String getmMoney() {
        return mMoney;
    }

    public void setmMoney(String mMoney) {
        this.mMoney = mMoney;
    }

    public String getmCardCompany() {
        return mCardCompany;
    }

    public void setmCardCompany(String mCardCompany) {
        this.mCardCompany = mCardCompany;
    }

    public String getmCardNumber() {
        return mCardNumber;
    }

    public void setmCardNumber(String mCardNumber) {
        this.mCardNumber = mCardNumber;
    }

    @Override
    public String toString() {
        return "Members{" +
                "userSerialNum='" + userSerialNum + '\'' +
                ", mId='" + mId + '\'' +
                ", mPw='" + mPw + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mName='" + mName + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mPhoneNumber='" + mPhoneNumber + '\'' +
                ", mPoint='" + mPoint + '\'' +
                ", mMoney='" + mMoney + '\'' +
                ", mCardCompany='" + mCardCompany + '\'' +
                ", mCardNumber='" + mCardNumber + '\'' +
                '}';
    }
}
