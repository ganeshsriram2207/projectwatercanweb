package com.revature.wp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.wp.dao.UserDAO;
import com.revature.wp.dao.UserDAOImpl;
import com.revature.wp.model.UserDetail;


public class LoginController 
{

	
	 public static String login(String name, String password) {
         String errorMessage = null;
          UserDAO user = new UserDAOImpl();
          UserDetail ud= null;
         try {
             ud = user.login(name,password);
             if (ud == null) {
                 throw new Exception("invalid");
             }
             
         } catch (Exception e) {
             //e.printStackTrace();
             errorMessage = e.getMessage();
         }
         
         // Prepare JSON Object
         String json = null;
         Gson gson = new Gson();
         if( ud != null) {
              json = gson.toJson(ud);
         }
         else if ( ud == null ) {
             JsonObject obj = new JsonObject();
             obj.addProperty("errorMessage", errorMessage);
             json = obj.toString();
         }
         
         
         return json;
         
     }
  public static String register( String name,long mobilenumber,String emailid,String password)  {
         String errorMessage = null;
         String message = null;
          UserDAO user = new UserDAOImpl();
          UserDetail ud= null;
         try {
             ud=new UserDetail();
             ud.setName(name);
             ud.setMobilenumber(mobilenumber);
             ud.setEmail_id(emailid);
             ud.setPassword(password);
             user.register(name,mobilenumber,emailid,password);
             message = "success";
             }
         
             
         catch (Exception e) {
             //e.printStackTrace();
             errorMessage = e.getMessage();
         }
         
         // Prepare JSON Object
       
  JsonObject obj = new JsonObject();
 if (message != null) {
     obj.addProperty("message", message);
 } else if (errorMessage != null) {
     obj.addProperty("errorMessage", errorMessage);
 }
 return obj.toString();
         
         
         
     }
     
     public static void main(String[] args) {
        // testLogin();
        testRegister();
         
     }
         
     
         public static void testLogin() {
         
         System.out.println("Test Case 1: Valid User");
         String validUserJson = LoginController.login("ganesh", "popi");
         System.out.println(validUserJson);
         
         System.out.println("Test Case 2: Invalid User");
         String invalidUserJson = LoginController.login("1123", "password");
         System.out.println(invalidUserJson);
         }
         
         
         public static void testRegister() {
             
             System.out.println("Test Case 1: Valid User");
             String validUserJson = LoginController.register("priyanka",876543211l,"g22@gmail.com","1234");
             System.out.println(validUserJson);
             
             System.out.println("Test Case 2: Invalid User");
             String invalidUserJson = LoginController.register("111",765432112,"ooo@gmail.com","pop");
             System.out.println(invalidUserJson);
         
         
         
         
     }
		 }
	
	

