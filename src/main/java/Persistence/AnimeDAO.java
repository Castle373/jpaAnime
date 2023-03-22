/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;

import Entitys.Anime;
import Entitys.Personaje;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 *
 * @author diego
 */
public class AnimeDAO implements IAnimeDAO {

    private EntityManager entity;

    public AnimeDAO(IConexionBD cone) {
        this.entity = cone.crearConexion();
    }

    @Override
    public List<Anime> ListaAnime() {

        entity.getTransaction().begin();
        String queryBuscar = "Select v From Anime v";
        TypedQuery<Anime> query = entity.createQuery(queryBuscar, Anime.class);
        List<Anime> lista = query.getResultList();
        entity.getTransaction().commit();

        return lista;
    }
    @Override
    public List<Anime> ListaAnimeFiltro(String filtro) {
        entity.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<Anime> criteriaQuery = criteriaBuilder.createQuery(Anime.class);
        criteriaQuery.distinct(true);
        Root<Anime> raizAnime = criteriaQuery.from(Anime.class);
        
        Join<Anime, Personaje> joinPersonajes = raizAnime.join("Personaje");
        raizAnime.fetch("Personaje", JoinType.LEFT);
        criteriaQuery.where(
        criteriaBuilder.or(
            criteriaBuilder.like(raizAnime.get("nombre"), "%" + filtro + "%"),
            criteriaBuilder.like(raizAnime.get("cantidadCapitulos"), "%" + filtro + "%"),
            criteriaBuilder.like(raizAnime.get("genero"), "%" + filtro + "%"),
            criteriaBuilder.like(joinPersonajes.get("nombre"), "%" + filtro + "%")
        )
        );
        
        TypedQuery<Anime> query = entity.createQuery(criteriaQuery);
  
        List<Anime> lstAnimes = query.getResultList();
        
        entity.getTransaction().commit();

        return lstAnimes;
    }
    @Override
    public List<Anime> ListaAnimeFiltro(String filtro, int limit, int offset) {
        entity.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
        CriteriaQuery<Anime> criteriaQuery = criteriaBuilder.createQuery(Anime.class);
        criteriaQuery.distinct(true);
        Root<Anime> raizAnime = criteriaQuery.from(Anime.class);
        
        Join<Anime, Personaje> joinPersonajes = raizAnime.join("Personaje");
//        raizAnime.fetch("Personaje", JoinType.LEFT);
        criteriaQuery.where(
        criteriaBuilder.or(
            criteriaBuilder.like(raizAnime.get("nombre"), "%" + filtro + "%"),
            criteriaBuilder.like(raizAnime.get("cantidadCapitulos"), "%" + filtro + "%"),
            criteriaBuilder.like(raizAnime.get("genero"), "%" + filtro + "%"),
            criteriaBuilder.like(joinPersonajes.get("nombre"), "%" + filtro + "%")
        )
        );
        
        TypedQuery<Anime> query = entity.createQuery(criteriaQuery);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
     
        List<Anime> lstAnimes = query.getResultList();
        
        entity.getTransaction().commit();

        return lstAnimes;
    }

    @Override
    public boolean agregaAnimes(Anime anime) {

        try {
            entity.getTransaction().begin();
            entity.persist(anime);
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    @Override
    public boolean agregaAnimeLista(List<Anime> lista) {

        try {
            entity.getTransaction().begin();
            for (Anime anime : lista) {
                entity.persist(anime);
            }
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

}
