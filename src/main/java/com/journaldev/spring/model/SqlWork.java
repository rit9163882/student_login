package com.journaldev.spring.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import static jdk.internal.net.http.common.Utils.close;

public class SqlWork {
    private Connection connect,connect2 = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase(Stud st) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("TRYING!!");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/StudentProfilesDB?"
                    + "user=root&password=698172");//Network Service

            System.out.println("Connected!!");
            statement = connect.createStatement();
            // Result set get the result of the SQL query
//            resultSet = statement.executeQuery("select * from studentprofilesdb.students");
//            System.out.println(resultSet);st.getStudName(),st.getStudId(),st.getStudClass()
            preparedStatement=connect.prepareStatement("insert into  studentprofilesdb.students  values (?,?,?)");
            preparedStatement.setString(1, st.getStudName());
            preparedStatement.setString(2, st.getStudId());
            preparedStatement.setString(3, st.getStudClass());
//            preparedStatement = connect
//                    .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            throw e;
        }
//        finally {
//            close();
//        }
    }
    public Stud getDataBase(String s) throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("TRYING2!!");
            connect2 = DriverManager.getConnection("jdbc:mysql://localhost/StudentProfilesDB?"
                    + "user=root&password=698172");//Network Service
//            System.out.println("Connected!!");
//            statement = connect2.createStatement();
            // Result set get the result of the SQL query
//            resultSet = statement.executeQuery("select * from studentprofilesdb.students");
//            System.out.println(resultSet);st.getStudName(),st.getStudId(),st.getStudClass()
            preparedStatement=connect2.prepareStatement("select*from  studentprofilesdb.students  where studId= ? ;");
            preparedStatement.setString(1, s);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            Stud st=new Stud();
            System.out.println(resultSet.getString("studName"));
            st.setStudName(resultSet.getString("studName"));
            st.setStudId(resultSet.getString("studId"));
            st.setStudClass(resultSet.getString("studClass"));
            return st;
        }
        catch (Exception e) {

            throw e;
            //return null;
        }
//        finally {
//            close();
//        }

    }
}
