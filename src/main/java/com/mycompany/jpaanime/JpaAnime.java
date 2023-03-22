/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jpaanime;

import Negocio.AnimeNegocio;
import Negocio.IAnimeNegocio;
import Persistence.IAnimeDAO;
import Persistence.AnimeDAO;
import Persistence.ConexionBD;
import Persistence.IConexionBD;
import forms.formPrincipal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author diego
 */
public class JpaAnime {

    public static void main(String[] args) {
        IConexionBD cone = new ConexionBD();
        IAnimeDAO animedao = new AnimeDAO(cone);
        IAnimeNegocio animeNegocio = new AnimeNegocio(animedao);
        formPrincipal a = new formPrincipal(animeNegocio);
        a.setVisible(true);
    }
}
