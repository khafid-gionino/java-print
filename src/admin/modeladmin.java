/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author asus
 */
public class modeladmin {
    private String id;
    private String username;
    private String password;
    
    public modeladmin(){
        
    }
    
    public modeladmin(String id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public void setID(String id){
        this.id=id;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getID(){
        return id;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}
