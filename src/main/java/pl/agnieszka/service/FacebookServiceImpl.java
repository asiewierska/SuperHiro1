package pl.agnieszka.service;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agnieszka.model.dao.FacebookDAO;
import pl.agnieszka.model.domain.Facebook;
import pl.agnieszka.model.exception.NotFoundException;

import java.util.*;


/**
 * Created by as on 15.07.2017.
 */

@Service
public class FacebookServiceImpl implements FacebookService {


    public static final Logger logger = LoggerFactory.getLogger(FacebookServiceImpl.class);

    @Autowired
    FacebookDAO facebookDAO;

    /**
     * {@inheritDoc}
     */
    public List<Facebook> findAll() {
        Set<Facebook> profilesSet = facebookDAO.findAll();
        List<Facebook> profilesList = new ArrayList<Facebook>();
        profilesList.addAll(profilesSet);
        Collections.sort(profilesList, new ProfilesComparator());

        return profilesList;
    }

    /**
     * {@inheritDoc}
     */
    public Facebook findById(String id) throws NotFoundException {

        return facebookDAO.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, Long> findMostCommonWords() {
        return facebookDAO.findMostCommonWords();
    }

    /**
     * {@inheritDoc}
     */
    public Set<String> findPostIdsByKeyword(String word) {
        return facebookDAO.findPostIdsByKeyword(word);
    }

    public Facebook setFacebookProfile(JSONObject jsonObject) {
        return facebookDAO.setFacebookProfile(jsonObject);
    }

    private class ProfilesComparator implements Comparator<Facebook> {

        public int compare(Facebook profile1, Facebook profile2) {

            int res = profile1.getFirstName().compareToIgnoreCase(profile2.getFirstName());
            if (res != 0)
                return res;
            return profile1.getLastName().compareToIgnoreCase(profile2.getLastName());
        }
    }

}
