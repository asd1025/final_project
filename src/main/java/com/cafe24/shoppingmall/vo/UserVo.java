package com.cafe24.shoppingmall.vo;

import com.cafe24.shoppingmall.validator.constraints.ValidID;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class UserVo {
	private enum Gender{
		MALE,FEMALE
	}
	private enum MembershipStatus{
		MEMBER, ADMIN, SECESSION
	}
	
	@ValidID
	private String id;
	
	@NotEmpty
	@Pattern(regexp="(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}", message="비밀번호는 8자 이상 20자 이하의 알파벳, 숫자, 특수문자를 조합하여 작성해야 합니다.")
	@Length(min=8, max=20,message="비밀번호는 8자 이상 20자 이하로 입력해야 합니다.")
	private String password;

	@NotEmpty
	private String name;
	@NotEmpty
	@Pattern(regexp="[0-9]{3}-[0-9]{4}-[0-9]{4}",message="숫자만 입력하세요!")
	private String phone;
	@NotEmpty
	@Email(message = "올바른 이메일 형식이 아닙니다.")
	private String email;

	private String birth;
	private Gender gender;
	private String refundAccount;
	private MembershipStatus membershipStatus;

	public UserVo(String id) {
		this.id=id;
	}

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
