package com.tutoriales.simplecrudroom.entities.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.tutoriales.simplecrudroom.entities.Director;
import com.tutoriales.simplecrudroom.entities.School;

//relacion de uno a uno escuela y director
public class SchoolAndDirector {
    @Embedded
    private School school;
    @Relation(
            entity = Director.class,
            entityColumn = "schoolId",
            parentColumn = "schoolId"
    )
    private Director director;

    public SchoolAndDirector() {
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
