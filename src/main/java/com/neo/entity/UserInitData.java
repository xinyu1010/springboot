package com.neo.entity;

import java.util.ArrayList;
import java.util.List;

import com.neo.enums.UserSexEnum;

public class UserInitData {
	
	public static List<UserEntity> addInfoSum(int count){
		
		List<UserEntity> result = new ArrayList<UserEntity>();
		for (int i = 0; i < count; i++) {
			UserEntity u = new UserEntity();
			
			u.setUserName("恭喜发财"+i);
			u.setPassWord("红包拿来"+i);
			u.setNickName("新年大吉"+i+i);
			
			if (i%2==0) {
				u.setUserSex(UserSexEnum.MAN);
			}else {
				u.setUserSex(UserSexEnum.WOMAN);
			}
			result.add(u);
			
		}
		return result;
	}
	

}
