package com.neo.mapper.test1;

import java.util.List;

import com.neo.entity.UserEntity;

/***
 * 
 * 添加多条用户信息
 * 
 * @author 稚初
 *
 */
public class User1Provider {
	
	
	public static String insertinfo(List<UserEntity> list) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO users (userName,passWord,nickName,userSex)");
		sql.append(" VALUES");
		for (int i = 0; i < list.size(); i++) {
			if (i!=0) {
				sql.append(",");
			}
				sql.append("(");
				UserEntity user = list.get(i);
				sql.append("'"+user.getUserName()+"',");
				sql.append("'"+user.getPassWord()+"',");
				sql.append("'"+user.getNickName()+"',");
				sql.append("'"+user.getUserSex()+"'");
				sql.append(")");
			
			
		}
		
		return sql.toString();
		
	}
	

}
