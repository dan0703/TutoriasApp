/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Tutor;

/**
 *
 * @author elrevo
 */
public class TutorDAO implements ITutorDAO {

    @Override
    public ArrayList<Tutor> findTutorsByName(String searchName) {
        ArrayList<Tutor> tutors = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="Select * from tutors where nombre like ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,"%"+searchName + "%");
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()==false){
                throw new SQLException("tutors not found");
            }else{
                int tutorId=0;
                String name="";
                String lastName="";
                do {
                    tutorId= resultSet.getInt("noPersonal");
                    name=resultSet.getString("nombre");
                    lastName=resultSet.getString("apellidos");
                    Tutor tutor = new Tutor();
                    tutor.setTutorId(tutorId);
                    tutor.setName(name);
                    tutor.setLastName(lastName);
                    tutors.add(tutor);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tutors;
    }

}
