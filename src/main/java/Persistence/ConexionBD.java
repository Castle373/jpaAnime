    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edgar Alonso
 */
public class ConexionBD implements IConexionBD {
    private EntityManagerFactory enti;
    private EntityManager entity;
    
    @Override
    public EntityManager crearConexion(){
         enti = Persistence.createEntityManagerFactory("Conexion");
         entity = enti.createEntityManager(); 
         return entity;
    }
    
   
    
}
