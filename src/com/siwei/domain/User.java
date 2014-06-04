/*
 * @title: User.java
 * @package com.siwei.domain
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2013-6-26 下午2:03:34
 * @version V1.0
 */
package com.siwei.domain;

import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @class User
 * @description 用户表
 * @author lzxz1234<lzxz1234@gmail.com>
 * @version v1.0
 */
@Table("S_USER")
public class User extends Domain {

    @Id
    private Long userId;
    @Name
    private String username;
    @Column
    private String passwd;
    @Column
    private Date createTime;
    @Column
    private Integer status;
    @Column
    private String email;
    @Column
    private String mobile;
    @Column
    private Integer level;
    @Column
    private Integer source;
    @Column
    private String nickName;
    @Column
    private String company;
    @Column
    private String pic1Path;
    @Column
    private String pic2Path;
    @Column
    private double weightNum;
    @Column
    private Integer gender;
    @Column
    private String trueName;
    @Column
    private String certification;
    
    @One(target=UserInfo.class, field = "userId",key="userId")
    private UserInfo userInfo;
    @ManyMany(target=Resource.class, relation="S_BOOKMARK", from="S_U_ID", to="ID")
    private List<Resource> bookMarks;
    @Many(target=MoneyRecord.class, field="userId")
    private List<MoneyRecord> moneyRecordList;
    
    public final List<MoneyRecord> getMoneyRecordList() {
        return moneyRecordList;
    }
    public final void setMoneyRecordList(List<MoneyRecord> moneyRecordList) {
        this.moneyRecordList = moneyRecordList;
    }
    /**
     * @return 书架
     */
    public final List<Resource> getBookMarks() {
        return bookMarks;
    }
    /**
     * @param bookMarks 书架
     */
    public final void setBookMarks(List<Resource> bookMarks) {
        this.bookMarks = bookMarks;
    }
    /**
     * @return 用户ID
     */
    public final Long getUserId() {
        return userId;
    }
    /**
     * @param userId 用户ID
     */
    public final void setUserId(Long userId) {
        this.userId = userId;
    }
    /**
     * @return 用户名
     */
    public final String getUsername() {
        return username;
    }
    /**
     * @param username 用户名
     */
    public final void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return 密码
     */
    public final String getPasswd() {
        return passwd;
    }
    /**
     * @param passwd 密码
     */
    public final void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    /**
     * @return 注册时间
     */
    public final Date getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime 注册时间
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * @return 状态<br>
     * 1:可用 0:失效
     */
    public final Integer getStatus() {
        return status;
    }
    /**
     * @param status 状态<br>
     * 1:可用 0:失效
     */
    public final void setStatus(Integer status) {
        this.status = status;
    }
    /**
     * @return 邮箱
     */
    public final String getEmail() {
        return email;
    }
    /**
     * @param email 邮箱
     */
    public final void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return 手机号码
     */
    public final String getMobile() {
        return mobile;
    }
    /**
     * @param mobile 手机号码
     */
    public final void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
     * @return 类别<br>
     * 1:普通用户,2:认证作家,3:企业用户
     */
    public final Integer getLevel() {
        return level;
    }
    /**
     * @param level 类别<br>
     * 1:普通用户,2:认证作家,3:企业用户
     */
    public final void setLevel(Integer level) {
        this.level = level;
    }
    /**
     * @return 注册来源<br>
     * 1：web
2：wap
3：客户端
     */
    public final Integer getSource() {
        return source;
    }
    /**
     * @param source 注册来源<br>
     * 1：web
2：wap
3：客户端
     */
    public final void setSource(Integer source) {
        this.source = source;
    }
    /**
     * @return 昵称
     */
    public final String getNickName() {
        return nickName;
    }
    /**
     * @param nickName 昵称
     */
    public final void setNickName(String nickName) {
        this.nickName = nickName;
    }
    /**
     * @return 公司名称
     */
    public final String getCompany() {
        return company;
    }
    /**
     * @param company 公司名称
     */
    public final void setCompany(String company) {
        this.company = company;
    }
    /**
     * @return 营业执照
     */
    public final String getPic1Path() {
        return pic1Path;
    }
    /**
     * @param pic1Path 营业执照
     */
    public final void setPic1Path(String pic1Path) {
        this.pic1Path = pic1Path;
    }
    /**
     * @return 许可证
     */
    public final String getPic2Path() {
        return pic2Path;
    }
    /**
     * @param pic2Path 许可证
     */
    public final void setPic2Path(String pic2Path) {
        this.pic2Path = pic2Path;
    }
    /**
     * @return 评价权重
     */
    public final double getWeightNum() {
        return weightNum;
    }
    /**
     * @param weightNum 评价权重
     */
    public final void setWeightNum(double weightNum) {
        this.weightNum = weightNum;
    }
    /**
     * @return 性别
     * 1：男
0：女
2：保密
     */
    public final Integer getGender() {
        return gender;
    }
    /**
     * @param gender 性别
     * 1：男
0：女
2：保密
     */
    public final void setGender(Integer gender) {
        this.gender = gender;
    }
    /**
     * @return 真实姓名
     */
    public final String getTrueName() {
        return trueName;
    }
    /**
     * @param trueName 真实姓名
     */
    public final void setTrueName(String trueName) {
        this.trueName = trueName;
    }
    /**
     * @return 身份证号
     */
    public final String getCertification() {
        return certification;
    }
    /**
     * @param certification 身份证号
     */
    public final void setCertification(String certification) {
        this.certification = certification;
    }
	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}
	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
    
}
