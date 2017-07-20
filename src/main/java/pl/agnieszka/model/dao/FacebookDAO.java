package pl.agnieszka.model.dao;

import org.json.simple.JSONObject;
import pl.agnieszka.model.domain.Facebook;
import pl.agnieszka.model.exception.NotFoundException;

import java.util.Map;
import java.util.Set;

/**
 * Interface DAO zawierajacy metody pobierające dane z plików zewnętrznych
 *
 * @author Agnieszka Siewierska
 */

public interface FacebookDAO {

    /**
     * Zwraca obiekt reprezentujący profil Facebooka na podstawie id
     *
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

    /**
     * Zwraca zbiór obiektów reprezentujących profile Facebooka
     * posortowane po firstname, lastname
     */
    Set<Facebook> findAll();

    public Facebook setFacebookProfile(JSONObject jsonObject);
}
