package org.wecancoeit.reviews.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int reviewNumber;

    @ManyToOne
    private Sites sites;

    public Review(String name, int reviewNumber, Sites sites) {
        this.name = name;
        this.reviewNumber = reviewNumber;
        this.sites = sites;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReviewNumber() {
        return reviewNumber;
    }

    public Sites getSites() {
        return sites;
    }
}
