package pl.agnieszka.service;

import org.json.simple.JSONObject;
import pl.agnieszka.model.domain.Facebook;
import pl.agnieszka.model.exception.NotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Autor: Agnieszka Siewierska
 */

public interface FacebookService {

    /**
     * Zwraca zbiór obiektów reprezentujących profile Facebooka
     * posortowane po firstname, lastname
     */
    List<Facebook> findAll();

    /**
     * Zwraca obiekt reprezentujący profil Facebooka na podstawie id
     * w czasie
     */
    Facebook findById(String id) throws NotFoundException;

    /**
     * Zwraca mapę której kluczem jest słowo a wartością liczba jego
     * wystąpień - pod uwagę brane są wszystkie posty
     */
    Map<String, Long> findMostCommonWords();

    /**
     * Zwraca zbiór id Postów zawierających słowo word
     */
    Set<String> findPostIdsByKeyword(String word);

    public Facebook setFacebookProfile(JSONObject jsonObject);

}
