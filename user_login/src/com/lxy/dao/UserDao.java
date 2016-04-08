package com.lxy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lxy.User;

public class UserDao {
	//添加用户对象user
	public void saveUSer(User user){
		Connection conn = ConnectDB.getConnection();
		String sql = "insert into tb_user(username,password,sex,tel,photo,email values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getPhoto());
			ps.setString(6, user.getEmail());
			
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectDB.closeConnection(conn);
		}
		
	}
	
	//用户登录
	public User login(String username, String password){
		User user = null;
		//获取数据库连接
		Connection conn = ConnectDB.getConnection();
		//根据用户名及密码查询用户信息
		String sql = "select * from tb_user where name = ? and password = ?";
		
		try {
			//获取PreparedStatement对象
			PreparedStatement ps = conn.prepareStatement(sql);
			//对sql语句的占位符参数进行动态赋值
			ps.setString(1, username);
			ps.setString(2, password);
			//执行查询获取结果集
			ResultSet rs = ps.executeQuery();
			//判断结果集是否有效
			if(rs.next()){
				//实例化一个用户对象
				user = new User();
				//对用户对象属性赋值
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("tel"));
				user.setPhoto(rs.getString("photo"));
				user.setEmail(rs.getString("email"));
			}
			//释放ResultSet对象的数据库和jdbc资源
			rs.close();
			//释放PreparedStatement对象的数据库和JDBC资源
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库
			ConnectDB.closeConnection(conn);
		}		
		return user;
	}
	
	//判断用户名在数据库中是否存在
	
	public boolean userIsExist(String username){
		//获取数据库连接
		Connection conn = ConnectDB.getConnection();
		//根据指定的用户名查询用户信息
		String sql = "select * from tb_user where username = ?";
		
		try {
			//获取ps
			PreparedStatement ps = conn.prepareStatement(sql);
			//对用户对象进行属性赋值
			ps.setString(1, username);
			//执行结果获取结果集
			ResultSet rs = ps.executeQuery();
			//如果无效则证明用户名可用
			if(!rs.next()){
				return true;
			}
			//释放次resultset的对象数据库和jdbc资源
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库
			ConnectDB.closeConnection(conn);
		}
		return false;
	}
}
