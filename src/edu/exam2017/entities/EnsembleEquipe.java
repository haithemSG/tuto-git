/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.exam2017.entities;

import java.util.Set;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author MedAmineBou
 */
public class EnsembleEquipe {

    public Set<Equipe> equipes;

    public EnsembleEquipe() {
       equipes= new HashSet<>();
    }

    @Override
    public String toString() {
        return "EnsembleEquipe{" + "equipes=" + equipes + '}';
    }
    
    

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void ajouterEquipe(Equipe e) {
        equipes.add(e);
    }

    public void supprimerEquipe(Equipe e) {
        equipes.remove(e);
    }

    public boolean rechercherEquipe(Equipe e)
    {
        return equipes.stream().anyMatch(x->x.equals(e));
    }
    
    public void afficherEquipes()
    {
        equipes.stream().forEach(System.out::println);
    }
    
    public Set<Equipe> trierEquipesParNom()
    {
        return equipes.stream().collect(Collectors.toCollection(()->new TreeSet<>((a,b)->a.getNom().compareTo(b.getNom()))));
    }
    
    
}
