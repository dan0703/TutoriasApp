/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uv.fei.tutorias.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elrevo
 */
public class DataBaseConnection {
    private Connection connection;
    private final String DB="jdbc:mysql://127.0.0.1/tutorias";
    private final String USUARIO="tutoriasUser";
    private final String CONTRASENA="passTutorias";
    
    public Connection getConnection() throws SQLException{
        connect();
        return connection;
    }
    
    private void connect() throws SQLException{
        connection=DriverManager.getConnection(DB,USUARIO,CONTRASENA);
    }
    
    public void cerrarConexion(){
        if(connection!=null){
            try {
                if(!connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
