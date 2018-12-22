package com.neo.mapper.test1;

import com.neo.entity.UserEntity;
import com.neo.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface User1Mapper {


	@Select("SELECT * FROM users")
	List<UserEntity> getAll();

	@Select("SELECT * FROM users WHERE id = #{id}")
	UserEntity getOne(Long id);
	
	
	
	
	
	
	String sql = "SELECT * FROM users WHERE id >=(SELECT id FROM users WHERE "
			+ "userSex = #{userSex} limit #{pageStart},1) limit #{pageSize}";
	
	/***
	 * 
	 * @param id 用户ID
	 * @param pageStart 从第几条数据开始查询
	 * @param pageSize  每页显示几条
	 * @return
	 */
	@Select(sql)
	List<UserEntity> selectInfo(@Param("userSex") String userSex,@Param("pageStart")int pageStart,@Param("pageSize") int pageSize);
	
	

	
	
	
	
	/***
	 * 添加用户信息
	 * 
	 * @param list 传mybatis时 转map集合的key值
	 */
	
	@InsertProvider(type = User1Provider.class,method = "insertinfo")
	public void insertInfo(@Param("list") List<UserEntity> list);
	
	
	@InsertProvider(type = User1Provider.class,method = "insertUser")
	public void insertUser(@Param("data") UserEntity data);
	
	
	

	
	/*@Insert("INSERT INTO users(userName,passWord,userSex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(UserEntity user);
	 
	@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(UserEntity user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);*/

}