package edu.njupt.oms.test;

import java.util.Date;

import edu.njupt.oms.dao.IUserDao;
import edu.njupt.oms.dao.UserDao;
import edu.njupt.oms.entity.User;

public class TestUserDao {

	public static void main(String[] args) {

		IUserDao userDao = new UserDao();
//		User user = new User(null,"hello张", "hellozhangsan", "111", new Date(), true, 0);
//		userDao.add(user);
		
		//User user = userDao.findById(1);
		//User user = userDao.findByActPwdStatus("zhangsan", "123", 0);
		//List<User> userList = userDao.findByName("%张%");
//		List<User> userList = userDao.findAll();
//		for(User user:userList) {
//			System.out.println(user);
//		}
		
//		userDao.deleteById(4);
		
		User user = userDao.findById(3);
		user.setName("张无忌");
		user.setAccount("zhangwuji");
		user.setPassword("666");
		Date birthday = new Date();
		birthday.setYear(1998-1900);
		birthday.setMonth(5);
		birthday.setDate(6);
		user.setBirthday(birthday);
		user.setStatus(0);
		userDao.update(user);
	}

}
