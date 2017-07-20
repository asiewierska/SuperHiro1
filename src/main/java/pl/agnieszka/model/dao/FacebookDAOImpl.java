package pl.agnieszka.model.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.agnieszka.model.domain.City;
import pl.agnieszka.model.domain.Coords;
import pl.agnieszka.model.domain.Facebook;
import pl.agnieszka.model.domain.Post;
import pl.agnieszka.model.exception.NotFoundException;
import pl.agnieszka.service.FacebookServiceImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Repository
public class FacebookDAOImpl implements FacebookDAO {

    public static final Logger logger = LoggerFactory.getLogger(FacebookServiceImpl.class);

    public List<JSONObject> getJsonObjectList() {

        JSONParser jsonParser = new JSONParser();
        List<JSONObject> jsonObjectList = new ArrayList<JSONObject>();

        try {
            Object obj1 = jsonParser.parse(new FileReader("C:\\Users\\as\\workspace\\SuperHiro1\\jsonFiles\\f1.json"));
            Object obj2 = jsonParser.parse(new FileReader("C:\\Users\\as\\workspace\\SuperHiro1\\jsonFiles\\f2.json"));
            Object obj3 = jsonParser.parse(new FileReader("C:\\Users\\as\\workspace\\SuperHiro1\\jsonFiles\\f3.json"));
            Object obj4 = jsonParser.parse(new FileReader("C:\\Users\\as\\workspace\\SuperHiro1\\jsonFiles\\f4.json"));
            Object obj5 = jsonParser.parse(new FileReader("C:\\Users\\as\\workspace\\SuperHiro1\\jsonFiles\\f5.json"));

            JSONObject jsonObject1 = (JSONObject) obj1;
            JSONObject jsonObject2 = (JSONObject) obj2;
            JSONObject jsonObject3 = (JSONObject) obj3;
            JSONObject jsonObject4 = (JSONObject) obj4;
            JSONObject jsonObject5 = (JSONObject) obj5;

            jsonObjectList.add(jsonObject1);
            jsonObjectList.add(jsonObject2);
            jsonObjectList.add(jsonObject3);
            jsonObjectList.add(jsonObject4);
            jsonObjectList.add(jsonObject5);

            return jsonObjectList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObjectList;
    }

    /**
     * {@inheritDoc}
     */
    public Set<Facebook> findAll() {
        Set<Facebook> profilesSet = new HashSet<Facebook>();
        List<JSONObject> jsonObjectList = getJsonObjectList();
        for (JSONObject jsonObject: jsonObjectList) {
            Facebook facebookProfile = setFacebookProfile(jsonObject);
            profilesSet.add(facebookProfile);
        }
        return profilesSet;
    }

    /**
     * {@inheritDoc}
     */
    public Facebook findById(String id) throws NotFoundException {
        Facebook profile = new Facebook();

        List<JSONObject> jsonObjectList = getJsonObjectList();
        for (JSONObject jsonObject: jsonObjectList) {
            String profileId = (String) jsonObject.get("id");
            if (profileId.equals(id)) {
                profile = setFacebookProfile(jsonObject);
                return profile;
            }
        }
        logger.error("error while searching for profile");
        throw NotFoundException.INVALID_ID;
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, Long> findMostCommonWords() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Set<String> findPostIdsByKeyword(String word) {

        Set<String> postSet = new HashSet<String>();
//        Set<Facebook> profilesSet = findAll();
//        List<Facebook> profilesList = new ArrayList<Facebook>();
//        profilesList.addAll(profilesSet);
//
//        for (Facebook p: profilesList) {
//            List<Post> posts = new ArrayList<Post>();
//            Post post = new Post();
//            post.setId(p.getPosts().get(0).getId());
//            for (Post s: posts) {
//                String[] messageArray = s.getMessage().toLowerCase().split("\\W+");
//                for (int i = 0 ; i < messageArray.length; i++) {
//                    if (messageArray[i].equals(word)) {
//                        postSet.add(s.getId());
//                        break;
//                    }
//                    postSet.add(s.getId());
//                }
//            }
//        }
//        postSet.add("6");
        return postSet;
    }

    public Facebook setFacebookProfile(JSONObject jsonObject) {
        Facebook profile = new Facebook();
        City city = new City();
        Coords coords = new Coords();

        String id = (String) jsonObject.get("id");
        Long birthdayLong = (Long) jsonObject.get("birthday");
        String occupation = (String) jsonObject.get("occupation");
        String gender = (String) jsonObject.get("gender");
        String firstName = (String) jsonObject.get("firstname");
        String lastName = (String) jsonObject.get("lastname");
        JSONObject cityJson = (JSONObject) jsonObject.get("city");
        JSONObject coordsJson = (JSONObject) cityJson.get("coords");
        city.setCountryName((String) cityJson.get("countryName"));
        city.setCityName((String) cityJson.get("cityName"));
        city.setStateName((String) cityJson.get("stateName"));
        coords.setLon((Double) coordsJson.get("lon"));
        coords.setLat((Double) coordsJson.get("lat"));
        city.setCoords(coords);
        String work = (String) jsonObject.get("work");
        JSONArray friends = (JSONArray) jsonObject.get("friends");
        String school = (String) jsonObject.get("school");
        String location = (String) jsonObject.get("location");
        String relationship = (String) jsonObject.get("relationship");
        JSONArray postsJson = (JSONArray) jsonObject.get("posts");

        profile.setId(id);
        Date birthday = new Date(birthdayLong);
        profile.setBirthday(birthday);
        profile.setOccupation(occupation);
        profile.setGender(gender);
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setCity(city);
        profile.setWork(work);
        profile.setFriends(friends);
        profile.setSchool(school);
        profile.setLocation(location);
        profile.setRelationship(relationship);
        List<Post> postList = new ArrayList<Post>();
        Iterator<Post> iteratorPost = postsJson.iterator();
        while (iteratorPost.hasNext()) {
            postList.add(iteratorPost.next());
        }
        profile.setPosts(postList);

        return profile;
    }
}
