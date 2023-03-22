/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistence;

import Entitys.Anime;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IAnimeDAO {
    public List<Anime> ListaAnime();
    public List<Anime> ListaAnimeFiltro(String filtro,int limit,int offset);
    public List<Anime> ListaAnimeFiltro(String filtro);
    public boolean agregaAnimes(Anime anime);
    public boolean agregaAnimeLista(List<Anime> anime);
}
