/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.witty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Susmi
 */
public class DBconnectionW {
    
    public static Connection DbConnector(){
        try{
            Connection conn = null;
            //https://bitbucket.org/xerial/sqlite-jdbc/downloads
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:math.sqlite");
            return conn;
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        return null;
    }
}
