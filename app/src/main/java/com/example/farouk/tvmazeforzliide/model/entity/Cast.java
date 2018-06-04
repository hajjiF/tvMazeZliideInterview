package com.example.farouk.tvmazeforzliide.model.entity;

import java.lang.Character;

/**
 * Created by farouk on 03/06/2018.
 */

public class Cast {
    /**
     * person : {"id":7,"url":"http://www.tvmaze.com/people/7/mackenzie-lintz","name":"Mackenzie Lintz","image":{"medium":"http://static.tvmaze.com/uploads/images/medium_portrait/3/7816.jpg","original":"http://static.tvmaze.com/uploads/images/original_untouched/3/7816.jpg"}}
     * character : {"id":7,"url":"http://www.tvmaze.com/characters/7/under-the-dome-norrie-calvert-hill","name":"Norrie Calvert-Hill","image":{"medium":"http://static.tvmaze.com/uploads/images/medium_portrait/0/793.jpg","original":"http://static.tvmaze.com/uploads/images/original_untouched/0/793.jpg"}}
     */

    private Person person;
    private Character character;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
