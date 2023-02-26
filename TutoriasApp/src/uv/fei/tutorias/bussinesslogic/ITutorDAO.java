/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.Tutor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elrevo
 */
public interface ITutorDAO {
    public ArrayList<Tutor> findTutorsByName(String searchName);
}