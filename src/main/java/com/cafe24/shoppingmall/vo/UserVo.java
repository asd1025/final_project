package com.cafe24.shoppingmall.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	private enum Gender{
		MALE,FEMALE
	}
	private enum MembershipStatus{
		MEMBER, ADMIN, SECESSION
	}
	
	@NotEmpty
	@Length(min=2,max=8)
	private String id;
	
	@NotEmpty
	@Length(min=8, max=20,message="비밀번호는 8자 이상 20자 이하로 입력해야 합니다.")
	private String password;
	
	private String name;
	private String phone;
	private String email;
	private String birth;
	private Gender gender;
	private String refundAccount;
	private MembershipStatus membershipStatus;
	
	public UserVo() {
		this.gender = Gender.MALE;
		this.membershipStatus = MembershipStatus.MEMBER;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getRefundAccount() {
		return refundAccount;
	}
	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}
	public MembershipStatus getMembershipStatus() {
		return membershipStatus;
	}
	public void setMembershipStatus(MembershipStatus membershipStatus) {
		this.membershipStatus = membershipStatus;
	}
	
	
	
	

}
