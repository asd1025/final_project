package com.cafe24.shoppingmall.util;

import java.util.Random;

public class CookieIdMaker {

	/***
	 * 랜덤한 쿠키 아이디 생성
	 * 20자리의 랜덤한 쿠키 아이디를 생성한다. 
	 * (영문+숫자)
	 * @return 쿠키 id
	 */
	public static String generateRandomCookieId() {
		StringBuffer sb=new StringBuffer();
		Random random=new Random();
		for(int i=0;i<20;i++) {
			if(random.nextBoolean()) {
				sb.append((char)((int)(random.nextInt(26))+97));
			}
			else sb.append((random.nextInt(10)));
		}
		
		return null;
		
	}
}
