/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entitys.Anime;
import Persistence.IAnimeDAO;
import Persistence.AnimeDAO;
import java.util.List;
/**
 *
 * @author diego
 */
public class AnimeNegocio implements IAnimeNegocio{
    private IAnimeDAO animeDAO;
    public AnimeNegocio(IAnimeDAO animeDAO){
        this.animeDAO= animeDAO;
    }
    
    @Override
    public Anime agregaAnime(Anime anime) {
        if (!animeDAO.agregaAnimes(anime)) {
          return null;  
        }   
       return anime;
    }
    @Override
    public List<Anime>agregaAnimeLista(List<Anime> lista) {
        if (!animeDAO.agregaAnimeLista(lista)) {
          return null;  
        }   
       return lista;
    }

    @Override
    public List<Anime> obtenerLista() {
      List<Anime>lista = animeDAO.ListaAnime();
        if (lista==null||lista.isEmpty()) {
            return null;
        }
        return lista;
    }
    @Override
    public List<Anime> obtenerListaFiltro(String filtro,int limit,int offset) {
      List<Anime>lista = animeDAO.ListaAnimeFiltro(filtro, limit, offset);
        if (lista==null||lista.isEmpty()) {
            return null;
        }
        return lista;
    }
    @Override
    public List<Anime> obtenerListaFiltro(String filtro) {
      List<Anime>lista = animeDAO.ListaAnimeFiltro(filtro);
        if (lista==null||lista.isEmpty()) {
            return null;
        }
        return lista;
    }
    
    
}
