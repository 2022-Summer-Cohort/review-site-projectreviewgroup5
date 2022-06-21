package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.repos.HashtagRepository;


@Component
public class Populator implements CommandLineRunner {

    private HashtagRepository hashtagRepo;

    public Populator(HashtagRepository hashtagsRepo) {
        this.hashtagRepo = hashtagsRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Hashtag hashtag1 = new Hashtag("#bingeable");

        hashtagRepo.save(hashtag1);

    }

}
