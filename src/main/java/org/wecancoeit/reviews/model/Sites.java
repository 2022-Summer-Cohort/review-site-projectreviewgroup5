package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Entity
public class Sites {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String imgUrl;
    private String altImgTxt;
    private String url;
    private Boolean paid;

    @OneToMany (mappedBy = "sites")
    private Collection<Review> reviews;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    public Sites(String name, String imgUrl, String altImgTxt,
                 String url, Boolean paid,
                 Hashtag...hashtags) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.altImgTxt = altImgTxt;
        this.url = url;
        this.paid = paid;
        this.reviews = new ArrayList<>();
        this.hashtags = Arrays.asList(hashtags);
    }

    public Sites() {
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getAltImgTxt() {
        return altImgTxt;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getPaid() {
        return paid;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }
}
