/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;

import java.sql.Connection;
import java.sql.SQLException;
import javax.persistence.EntityManager;
/**
 *
 * @author Edgar Alonso
 */
public interface IConexionBD {
    public EntityManager crearConexion();

}
