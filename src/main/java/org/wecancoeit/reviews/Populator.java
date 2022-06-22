package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Sites;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.SitesRepository;


@Component
public class Populator implements CommandLineRunner {

    private HashtagRepository hashtagRepo;
    private SitesRepository sitesRepo;

    public Populator(HashtagRepository hashtagRepo, SitesRepository sitesRepo) {
        this.hashtagRepo = hashtagRepo;
        this.sitesRepo = sitesRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Hashtag hashtag1 = new Hashtag("#bingeable");
        hashtagRepo.save(hashtag1);

        Sites hbo = new Sites("HBO","https://hbomax-images.warnermediacdn.com/2020-05/square%20social%20logo%20400%20x%20400_0.png",
                "hbo logo","http://www.hbo.com",true,);
        sitesRepo.save(hbo);

        Sites hulu = new Sites("Hulu", "https://riddleandbloom.com/wp-content/uploads/2020/05/hulu0-square.jpg",
                "hulu logo","https://www.hulu.com/welcome",true);
        sitesRepo.save(hulu);

        Sites netflix = new Sites("Netflix", "https://cdn.vox-cdn.com/thumbor/Yq1Vd39jCBGpTUKHUhEx5FfxvmM=/39x0:3111x2048/1200x800/filters:focal(39x0:3111x2048)/cdn.vox-cdn.com/uploads/chorus_image/image/49901753/netflixlogo.0.0.png",
                "netflix logo","https://www.netflix.com/",true);
        sitesRepo.save(netflix);

        Sites paramount = new Sites("Paramount", "https://ca-times.brightspotcdn.com/dims4/default/1629592/2147483647/strip/true/crop/3300x2550+0+0/resize/840x649!/quality/90/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F0e%2Ffc%2Fcca99a12483eae714f5f2e7667ca%2Fparamount-plus-logo.jpg",
                "parramount logo","https://www.paramount.com/",true);
        sitesRepo.save(paramount);

        Sites crackle = new Sites("Crackle","https://gobrolly.com/wp-content/uploads/2018/09/sony-crackle-logo-300x300.png",
                "crackle logo","http://www.crackle.com",false,hashtag1);
        sitesRepo.save(crackle);

        Sites roku = new Sites("Roku","https://image.roku.com/bWFya2V0aW5n/logo-therokuchannel.jpg",
                "roku logo","https://www.therokuchannel.roku.com/",false);
        sitesRepo.save(roku);

        Sites tubi = new Sites("TubiTv","https://cdn.adrise.tv/tubitv-assets/img/tubi_open-graph-512x512.png",
                "tubi logo","https://www.tubitv.com/",false);
        sitesRepo.save(tubi);

        Sites youtube = new Sites("Youtube","https://static.vecteezy.com/system/resources/previews/003/399/771/original/youtube-icon-editorial-free-vector.jpg",
                "youtube logo", "https://www.youtube.com",false);
        sitesRepo.save(youtube);


    }

}
