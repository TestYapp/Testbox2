package edu.njupt.oms.dao;

import java.util.List;

import edu.njupt.oms.entity.User;
import edu.njupt.oms.utils.BaseDao;

public class UserDao extends BaseDao implements IUserDao {

	@Override
	public void add(User user) {
		String sql = " insert into t_user(name,account,password,birthday,gender,status) " + " values(?,?,?,?,?,?) ";
		Object[] param = new Object[] { user.getName(), user.getAccount(), user.getPassword(), user.getBirthday(),
				user.getGender(), user.getStatus() };
		super.update(sql, param);
	}

	@Override
	public void deleteById(int id) {
		String sql = " delete from t_user where id=? ";
		super.update(sql, id);
	}

	@Override
	public void update(User user) {
		String sql = " update t_user set name=?,account=?,password=?,birthday=?,gender=?,status=? where id=? ";
		Object[] param = new Object[] { user.getName(), user.getAccount(), user.getPassword(), user.getBirthday(),
				user.getGender(), user.getStatus(), user.getId() };
		super.update(sql, param);
	}

	@Override
	public User findById(int id) {
		String sql = " select * from t_user where id=? ";
		return super.selectOne(User.class, sql, id);
	}

	@Override
	public User findByActPwdStatus(String account, String password, int status) {
		String sql = " select * from t_user where account=? and password=? and status=? ";
		return super.selectOne(User.class, sql, account, password, status);
	}

	@Override
	public List<User> findByName(String name) {
		String sql = " select * from t_user where name like ? ";
		return super.select(User.class, sql, name);
	}

	@Override
	public List<User> findAll() {
		String sql = " select * from t_user ";
		return super.select(User.class, sql);
	}

}
