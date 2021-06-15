package com.fuguiping.dao;

import com.fuguiping.model.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {

        // TODO 5.1 : write update sql where id=?
        // TODO 5.2 : create prepared statement
        // TODO 5.3 : executeQuery()
        // TODO 5.4 : return int value

        try {
            Statement createDbStatement = con.createStatement();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String sql = "update usertable set Username='" + user.getUsername() + "',Password='" + user.getPassword() + "',Email='" + user.getEmail() + "',Gender='" + user.getGender() + "',BirthDate='" + simpleDateFormat.format(user.getBirthDate()) + "' where id=" + user.getId();
            createDbStatement.executeUpdate(sql);
            System.out.println("update " + user.getId() + " success");
            return 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        try {
            Statement createDbStatement = con.createStatement();
            String dbRequire = "select * from usertable where id=" + id.toString();
            ResultSet resultDb = createDbStatement.executeQuery(dbRequire);
            while (resultDb.next()) {
                return new User(resultDb.getInt("Id"), resultDb.getString("Username"), resultDb.getString("Password"), resultDb.getString("Email"), resultDb.getString("Gender"), resultDb.getDate("BirthDate"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String Username, String Password) throws SQLException {

        String sql = "select * from usertable where Username=? and Password=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, Username);
        st.setString(2, Password);
        ResultSet rs = st.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("Username"));
            user.setPassword(rs.getString("Password"));
            user.setEmail(rs.getString("Email"));
            user.setGender(rs.getString("Gender"));
            user.setBirthDate(rs.getDate("BirthDate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String Username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String Password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String Email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String Gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }



    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}