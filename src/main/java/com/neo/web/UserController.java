package com.neo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neo.mapper.test1.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.entity.UserEntity;
import com.neo.mapper.test2.User2Mapper;
import com.neo.server.UserServer;

@RestController
public class UserController {

    @Autowired
    private User1Mapper user1Mapper;
    
    @Autowired
    UserServer userServer;

	@Autowired
	private User2Mapper user2Mapper;
	
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=user1Mapper.getAll();
		return users;
	}
	
	@RequestMapping("/getFile/{id}")
	public String load(@PathVariable("id") Long id,HttpServletRequest request) {
		//获取getFile的根目录
		/*String path = request.getServletContext().getRealPath("/");*/
		//通过ID查出UserEntity的属性值
		UserEntity entity = userServer.load(id);
		//获取UserEntity的UserFileUrl值
		String url = entity.getUserFileUrl();
		
		/*//获取文件的绝对路径
        int index = url.indexOf("/");
        String realPath = request.getSession().getServletContext().getRealPath(url.substring(0, index));*/
        
       
		
		System.out.println("url:"+url);
		/*System.out.println("realPath::"+realPath);*/
		//调用userServer.loadFile()方法读取数据
		String string = userServer.loadFile(url);
		
		return string;
	}
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=user2Mapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
        user2Mapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
        user2Mapper.update(user);
    }
    
    /*@RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }*/
    
}