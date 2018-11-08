package com.realsprint.academy.hellodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    @Autowired
    public DataSource dataSource;

    public List<User> getUsers() {
        List <User> allUsers = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = ps.executeQuery();
        ) {
            while(resultSet.next()) {
                User user = new User(resultSet.getInt("id"), resultSet.getString("name"));

                allUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }
}
