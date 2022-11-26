DROP TABLE MEMBER;

CREATE TABLE MEMBER (
                        user_serial_num LONG NOT NULL AUTO_INCREMENT,
                        mId VARCHAR(255),
                        mPw VARCHAR(255),
                        mEmail VARCHAR(255),
                        mName VARCHAR(20) NOT NULL ,
                        mAddress VARCHAR(255) ,
                        mPhoneNumber CHAR(13) ,
                        mPoint INT NOT NULL,
                        mMoney INT NOT NULL,
                        mCardCompany VARCHAR(20),
                        mCardNumber VARCHAR(20),
                        PRIMARY KEY (mId)
);

SELECT * FROM MEMBER;