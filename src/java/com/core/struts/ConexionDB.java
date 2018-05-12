/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ismaelsanchez
 */
public class ConexionDB {
    
        public Connection getConnection(){
                Connection conn = null;
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    //conn =  DriverManager.getConnection("jdbc:mysql://ventas-qa.cxwsdw2ago7m.us-east-1.rds.amazonaws.com/lacastellanaQA","lacastellanaQA","%laCastellana01#");
                    conn =  DriverManager.getConnection("jdbc:mysql://localhost/claustro","root","root");
                }catch(ClassNotFoundException cnfe){
                        cnfe.printStackTrace();

                }catch(SQLException sql){
                       sql.printStackTrace();
                }
                
                return conn;
        }

 
}
