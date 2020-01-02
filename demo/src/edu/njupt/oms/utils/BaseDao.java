package edu.njupt.oms.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {

	public int insertForResult(String sql, Object... param) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id = 0;
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < param.length; i++) {
				preparedStatement.setObject(i + 1, param[i]);
			}
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			id = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResources(resultSet, preparedStatement, connection);
		}
		return id;
	}

	public void update(String sql, Object... param) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				preparedStatement.setObject(i + 1, param[i]);
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResources(null, preparedStatement, connection);
		}
	}

	public <E> List<E> select(Class<E> cls, String sql, Object... param) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<E> list = new ArrayList<>();
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				preparedStatement.setObject(i + 1, param[i]);
			}
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			while (resultSet.next()) {
				E e = cls.newInstance();
				for (int i = 0; i < columnCount; i++) {
					String fieldName = resultSetMetaData.getColumnLabel(i + 1);
					Field field = cls.getDeclaredField(fieldName);
					Object value = resultSet.getObject(i + 1);
					field.setAccessible(true);
					field.set(e, value);
				}
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResources(resultSet, preparedStatement, connection);
		}
		return list;
	}

	public <E> E selectOne(Class<E> cls, String sql, Object... param) {
		List<E> list = select(cls, sql, param);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public int selectCount(String sql, Object... param) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				preparedStatement.setObject(i + 1, param[i]);
			}
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			count = resultSet.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResources(resultSet, preparedStatement, connection);
		}
		return count;
	}

}
