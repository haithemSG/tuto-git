/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.exam2017.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author MedAmineBou
 */
public class Fifa {

    private Map<Competition, EnsembleEquipe> mapFifa;

    public Fifa() {
        mapFifa = new HashMap<>();
    }

    public void ajouterCompetition(Competition c) {
        mapFifa.put(c, new EnsembleEquipe());
    }

    public void ajouterEquipe(Competition c, Equipe e) {
        if (mapFifa.containsKey(c)) {
            mapFifa.get(c).ajouterEquipe(e);
        } else {
            ajouterCompetition(c);
            mapFifa.get(c).ajouterEquipe(e);

        }
    }

    public void afficherFifa() {
        mapFifa.entrySet().forEach(e -> System.out.println("Competition: " + e.getKey() + " Equipes: " + e.getValue()));
    }

    public List<Equipe> retournerEquipesParPays(String nom) {
        return mapFifa.values().stream()
                .flatMap(e -> e.getEquipes().stream())
                .filter(x -> x.getPays().equals(nom))
                .collect(Collectors.toList());
    }

    public void afficherEquipesPersonalisees(Competition c, String nationalite) {
        mapFifa.get(c).getEquipes().stream().flatMap(p -> p.getJoueurs().stream())
                .filter(p -> p.getNationalite().equals(nationalite)).forEach(System.out::println);
    }
    
    public List<Competition> retournerCompetitionParJoueurTunisien()
    {
        List<Competition> L=new ArrayList<>();
        for(Competition c: mapFifa.keySet())
        {
        if(mapFifa.get(c).getEquipes().stream().flatMap(p->p.getJoueurs().stream())
                 .anyMatch(p->p.getNationalite().equalsIgnoreCase("Tunisien")))
        {
            L.add(c);
        }
        }
        
        return L;
    }
    
    public boolean returnSiUneEquipeParticipeEnPlusieursCompetitions()
    {
        List<String> tab=new ArrayList<>();
            for(Competition c: mapFifa.keySet())
            {
                for(Equipe var:mapFifa.get(c).getEquipes())
                {
                   tab.add(var.getNom());
                }
                
            }
            for(int i=0;i<tab.size();i++)
            {
                for(int j=0;j<i;j++)
                {
                    if(tab.get(i).equals(tab.get(j)))
                    {
                        System.out.println(tab.get(i).toString());
                        return true;
                    }
                }
            }
            
            return false;
    }

}
