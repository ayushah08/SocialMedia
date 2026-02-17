package com.social.media.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
//    @OneToOne
//    @JoinColumn(name = "social_User")
//    private SocialUser socialUser;

    @OneToMany(mappedBy = "socialUser")
    private List<SocialPost> socialPosts;


    @ManyToMany
    @JoinTable(name = "User_Groups",
               joinColumns = @JoinColumn(name = "User_id"),
               inverseJoinColumns = @JoinColumn(name = "Group_id"))
    private Set<SocialGroup> socialGroup = new HashSet<>();


    @OneToOne(mappedBy = "user")
    private SocialProfile socialProfile;


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

