/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postgresprojects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author abdullah
 */
class PostgresSqlDatabase {
    
    Company databaseCompany = new Company();
    Connection connection = null;
    String connectionURL = "";
    String userName = "";
    String passWord = "";
    
    public PostgresSqlDatabase(String _connectionURL, String _userName, String _passWord){
        this.connectionURL = _connectionURL;
        this.userName = _userName;
        this.passWord = _passWord;
    }
    
    public void insertData(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL,userName,passWord);
            PreparedStatement insertTeemp = connection.prepareStatement("insert into company values(?,?,?,?)");
            //connection.setAutoCommit(false);
            
            //insertTeemp.setInt(1, databaseCompany.getId());
            insertTeemp.setString(1, databaseCompany.getName());
            insertTeemp.setInt(2, databaseCompany.getAge());
            insertTeemp.setString(3, databaseCompany.getAdress());
            insertTeemp.setInt(4, databaseCompany.getSalary());
            insertTeemp.executeUpdate();
           
            //connection.commit();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName()+":"+ e.getMessage());
            System.exit(0);
        }
        this.databaseSelect();
    }
    
    public void databaseSelect(){
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL,userName,passWord);
            connection.setAutoCommit(false);
            
            /*PreparedStatement getIds = connection.prepareStatement("select * from company order by id asc");
            getIds.executeQuery(); */
            
            stmt = connection.createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY order by id asc")) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String  name = rs.getString("name");
                    int age  = rs.getInt("age");
                    String  address = rs.getString("address");
                    float salary = rs.getFloat("salary");
                    System.out.println("ID = " + id );
                    System.out.println("NAME = " + name );
                    System.out.println("AGE = " + age );
                    System.out.println("ADDRESS = " + address );
                    System.out.println("SALARY = " + salary );
                    System.out.println();
                }
            }
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
    }
    
    public void updateTable(int companyID){
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL,userName,passWord);
            PreparedStatement updateTable = connection.prepareStatement("update company set name = ?, age = ?, address = ?, salary = ? where id =?");

            updateTable.setString(1, databaseCompany.getName());
            updateTable.setInt(2, databaseCompany.getAge());
            updateTable.setString(3, databaseCompany.getAdress());
            updateTable.setInt(4, databaseCompany.getSalary());
            updateTable.setInt(5, companyID);
            updateTable.executeUpdate();
            
           
            connection.close();
        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    
    public void deleteDataTable(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL,userName,passWord);
            PreparedStatement deleteTeemp = connection.prepareStatement("delete from company where id =?");
            
            deleteTeemp.setInt(1, databaseCompany.getId());
            deleteTeemp.executeUpdate();
            
            connection.close();
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        } 
    }
    
    public void getIdData(){    
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL,userName,passWord);
            PreparedStatement getIds = connection.prepareStatement("select * from company where id = ?");
            
            getIds.setInt(1, databaseCompany.getId());
            ResultSet results = getIds.executeQuery();
            
            while(results.next()){
                databaseCompany.setName(results.getString("name"));
                databaseCompany.setAge(results.getInt("age"));
                databaseCompany.setAddress(results.getString("address"));
                databaseCompany.setSalary(results.getInt("salary"));
            }
            
            connection.close(); 
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getClass().getName()+": "+ e.getMessage());
                System.exit(0);
         }
    }
    
    public void databaseSort(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL,userName,passWord);
            PreparedStatement getIds = connection.prepareStatement("select * from company order by id asc");
            
            getIds.executeQuery();
            //ResultSet results = getIds.executeQuery();
            
            connection.close(); 
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getClass().getName()+": "+ e.getMessage());
                System.exit(0);
         }
    }
}