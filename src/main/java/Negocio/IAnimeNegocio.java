/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Entitys.Anime;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IAnimeNegocio {
    public Anime agregaAnime(Anime anime);
    public List<Anime> agregaAnimeLista(List<Anime> anime);
    public List<Anime> obtenerLista();
    public List<Anime> obtenerListaFiltro(String filtro);
    public List<Anime> obtenerListaFiltro(String filtro,int limit,int offset);
}
