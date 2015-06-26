package com.ambiciousteam.hotelsys.controller;

import com.ambiciousteam.hotelsys.enumerations.Documentation;
import com.ambiciousteam.hotelsys.enumerations.Gender;
import com.ambiciousteam.hotelsys.enumerations.States;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Model;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Model
public class PersonBean {

    private final List<States> states;
    private final List<Gender> genders;
    private final List<Documentation> documentations;
    static transient List<String> cities = new ArrayList<>();

    public PersonBean() {
        //Initializing list and receiving the valus of States Enumeration as a List.
        states = Arrays.asList(States.values());
        genders = Arrays.asList(Gender.values());
        documentations = Arrays.asList(Documentation.values());
    }
    
    public List<States> getStates() {
        return states;
    }

    public List<Gender> getGenders() {
        return genders;
    }

    public List<Documentation> getDocumentations() {
        return documentations;
    }

    public static List<String> getCities() {
        return cities;
    }
}
