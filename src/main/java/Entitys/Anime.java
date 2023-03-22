/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author diego
 */

@Entity
@Table(name = "Animes")
public class Anime implements Serializable {

    public Anime(){
        
    }

    public Anime(String nombre, String cantidadCapitulos) {
        this.nombre = nombre;
        this.cantidadCapitulos = cantidadCapitulos;
    }

    public Anime(String nombre, String genero, String cantidadCapitulos) {
        this.nombre = nombre;
        this.genero = genero;
        this.cantidadCapitulos = cantidadCapitulos;
    }

    public Anime(String nombre, String cantidadCapitulos, List<Personaje> Personaje) {
        this.nombre = nombre;
        this.cantidadCapitulos = cantidadCapitulos;
        this.Personaje = Personaje;
    }

    public Anime(Integer id, String nombre, String cantidadCapitulos, List<Personaje> Personaje) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadCapitulos = cantidadCapitulos;
        this.Personaje = Personaje;
    }
    
    @Id
    @Column(name = "idAnime")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Capitulos")
    private String cantidadCapitulos;
    
    @OneToMany(mappedBy = "anime", cascade = {CascadeType.ALL})
    private List<Personaje> Personaje;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidadCapitulos() {
        return cantidadCapitulos;
    }

    public void setCantidadCapitulos(String cantidadCapitulos) {
        this.cantidadCapitulos = cantidadCapitulos;
    }

    public List<Personaje> getPersonaje() {
        return Personaje;
    }

    public void setPersonaje(List<Personaje> Personaje) {
        this.Personaje = Personaje;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anime)) {
            return false;
        }
        Anime other = (Anime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Anime{" + "id=" + id + ", nombre=" + nombre + ", cantidadCapitulos=" + cantidadCapitulos + ", Personaje=" + Personaje + '}';
    }

    
    
}
