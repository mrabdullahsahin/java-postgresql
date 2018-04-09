/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postgresprojects;

/**
 *
 * @author abdullah
 */
public class Company {
    static private int id;
    static private String name;
    static private int age;
    static private String address;
    static private int salary;
        
    public int getId(){
        return id;
    }
    
    public void setId(int _id){
        this.id = _id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String _name){
        this.name = _name;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int _age){
        this.age = _age;
    }
    
    public String getAdress(){
        return address;
    }
    
    public void setAddress(String _address){
        this.address = _address;
    }
    
    public int getSalary(){
        return salary;
    }
    
    public void setSalary(int _salary){
        this.salary = _salary;
    }
}