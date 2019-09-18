package com.revature.wp.servlet;

import java.sql.SQLException;
import java.util.List;

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
             user.register(ud);
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
  public  String setavailablecans(int noOfCans)
	{
		String json = null;
		String errorMessage = null;
		UserDAO user=new UserDAOImpl();
		try {
			 UserDetail admin = new UserDetail();
			 admin.setAvailablecans(noOfCans);//getter setter
			
			 
			user.setavailablecans(noOfCans);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		
		JsonObject obj = new JsonObject();
		if (errorMessage != null) {
			obj.addProperty("errorMessage", errorMessage);
		}
		else {
			obj.addProperty("message", "Successfully Updated");
		}
		
		json = obj.toString();
		
		return json;
	}
  public  String findAll(){
	  
  UserDAOImpl user=new UserDAOImpl();
      String json = null;
       List<UserDetail> findAll  = null;
      String errorMessage = null;
      try {
          findAll=user.findAll();
      } catch (SQLException e) {
          errorMessage = e.getMessage();
      }
      
      //Convert list to json
      if ( findAll != null) {
          Gson gson = new Gson();
          json = gson.toJson(findAll);
      }
      if (errorMessage != null) {
          JsonObject obj = new JsonObject();
          obj.addProperty("errorMessage", errorMessage);
      }
      return json;
  }
     
     public static void main(String[] args) {
       // testLogin();
        //testRegister();
        testsetavailablecans(); 
        testavailablecans(); 
        
         
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
             String validUserJson = LoginController.register("priyanka",876543211l,"k@gmail.com","1234");
             System.out.println(validUserJson);
             
             System.out.println("Test Case 2: Invalid User");
             String invalidUserJson = LoginController.register("111",765432112,"g22@gmail.com","pop");
             System.out.println(invalidUserJson);
         
         
         
         
     }
         public static void testsetavailablecans() 
         {
         
        	 LoginController controller = new LoginController();
     		String json = controller.setavailablecans(1001);
     		System.out.println(json);
     	
     		
         }
         public static void testavailablecans() 
         {
         
        	 LoginController controller = new LoginController();
     		String json = controller.findAll();
     		System.out.println(json);
         
		 }
}
	
	

