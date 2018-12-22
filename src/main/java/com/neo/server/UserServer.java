package com.neo.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.entity.UserEntity;
import com.neo.mapper.test1.User1Mapper;

@Service
public class UserServer {
	
	@Autowired
	private User1Mapper user1Mapper;
	
	public UserEntity load(long id) {
		return user1Mapper.getOne(id);
	}
	
	
	
	public String loadFile(String realPath) {
        	// 1.定义目标文件
     		File file = new File(realPath);
     		// 2.创建一个流，指向目标文件
     		InputStream is = null;
     		try {
     			is = new FileInputStream(file);
     			//3.创建一个用来存储读取数据的缓冲数组
     			byte[]array = new byte[is.available()];
     			//4.循环往外流(count为每次读取数组中的有效字节总数)
     			int count = is.read(array);
     			// 5.循环打印
     			while (count != -1) {
     				// 将byte[] -》 String
     				// 将byte数组读取到的有效字节转换成字符串
     				String string = new String(array, 0, count);
     				String str = new String(string.toString().getBytes("UTF-8")); 
     				System.out.print(str);
     				count = is.read(array);
     				return str;
     			}
     		} catch (FileNotFoundException e) {
     			e.printStackTrace();
     		} catch (IOException e) {
     			e.printStackTrace();
     		} finally {
     			// 关闭io流
     			try {
     				is.close();
     			} catch (IOException e) {
     				e.printStackTrace();
     			}
     		}
			return null;
	
		}
	

}
