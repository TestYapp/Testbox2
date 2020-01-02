package edu.njupt.oms.dao;

import java.util.List;

import edu.njupt.oms.entity.User;

/**
 * 用户的DAO接口
 * 
 * @author Wesley
 *
 */
public interface IUserDao {

	/**
	 * 新增(添加)新用户
	 * 
	 * @param user 被新增(添加)的用户对象
	 */
	void add(User user);

	/**
	 * 根据用户id删除用户
	 * 
	 * @param id 用户的id
	 */
	void deleteById(int id);

	/**
	 * 更新(修改)用户信息
	 * 
	 * @param user 被修改的用户对象
	 */
	void update(User user);

	/**
	 * 根据用户id查询用户
	 * 
	 * @param id 用户id
	 * @return 用户对象
	 */
	User findById(int id);

	/**
	 * 根据用户的账号、密码、状态去查找用户对象
	 * 
	 * @param account  用户的账号
	 * @param password 用户的密码
	 * @param status   用户的状态
	 * @return 用户对象
	 */
	User findByActPwdStatus(String account, String password, int status);

	/**
	 * 根据用户的姓名去查找用户对象
	 * 
	 * @param name 用户的姓名
	 * @return 用户对象集合
	 */
	List<User> findByName(String name);

	/**
	 * 查找所有的用户对象
	 * 
	 * @return 用户对象集合
	 */
	List<User> findAll();

}
