package com.social.media;


import com.social.media.model.SocialGroup;
import com.social.media.model.SocialPost;
import com.social.media.model.SocialProfile;
import com.social.media.model.SocialUser;
import com.social.media.repository.SocialGroupRepository;
import com.social.media.repository.SocialPostRepository;
import com.social.media.repository.SocialProfileRepository;
import com.social.media.repository.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MediaInitializer {

    private final SocialUserRepository socialUserRepository;
    private final SocialPostRepository socialPostRepository;
    private final SocialGroupRepository socialGroupRepository;
    private final SocialProfileRepository socialProfileRepository;

    public MediaInitializer(SocialUserRepository socialUserRepository, SocialPostRepository socialPostRepository, SocialGroupRepository socialGroupRepository, SocialProfileRepository socialProfileRepository) {
        this.socialUserRepository = socialUserRepository;
        this.socialPostRepository = socialPostRepository;
        this.socialGroupRepository = socialGroupRepository;
        this.socialProfileRepository = socialProfileRepository;
    }

    @Bean
    public CommandLineRunner dataInitialization(){
        return args -> {


            //SocialUser
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);




            //SocialGroup
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            group1.getSocialUser().add(user1);
            group1.getSocialUser().add(user2);

            group2.getSocialUser().add(user2);
            group2.getSocialUser().add(user3);

            socialGroupRepository.save(group1);
            socialGroupRepository.save(group2);

            user1.getSocialGroup().add(group1);
            user2.getSocialGroup().add(group1);

            user2.getSocialGroup().add(group2);
            user3.getSocialGroup().add(group2);

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);


            //SocialPost
            SocialPost post1 = new SocialPost();
            SocialPost post2 = new SocialPost();
            SocialPost post3 = new SocialPost();

            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            socialPostRepository.save(post1);
            socialPostRepository.save(post2);
            socialPostRepository.save(post3);



            SocialProfile socialProfile1 = new SocialProfile();
            SocialProfile socialProfile2 = new SocialProfile();
            SocialProfile socialProfile3 = new SocialProfile();

                socialProfile1.setUser(user1);
                socialProfile2.setUser(user2);
                socialProfile3.setUser(user3);
        };
    }

    
}
