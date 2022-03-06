package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    @Test
    public void testQuery(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cyk001?useSSL=false&useUnicode=true";
            String username = "root";
            String password = "20020517";
            String sql = "select * from student";

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Student> students = new ArrayList<>();

            while (resultSet.next()){
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getByte("age"));
                student.setGender(resultSet.getString("gender"));
                student.setInfo(resultSet.getString("info"));

                students.add(student);
            }
            for (Student student:students) {
                System.out.println(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAdd(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/cyk001?useSSL=false&useUnicode=true";
            String username = "root";
            String password = "20020517";
            String sql = "insert into student(name, age, gender, info) values(?, ?, ?, ?)";

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1,"0511");
            preparedStatement.setObject(2,22);
            preparedStatement.setObject(3,"男");
            preparedStatement.setObject(4,"可爱");

            int affectedRows = preparedStatement.executeUpdate();

            System.out.println(affectedRows);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
