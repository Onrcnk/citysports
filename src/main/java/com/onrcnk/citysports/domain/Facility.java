package com.onrcnk.citysports.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Facility {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String facilityId;

    private String facilityName;

    @ManyToOne
    private SportCenter sportsCenter;

    @ManyToMany(mappedBy = "facilitySet")
    private Set<Branch> branchSet;

    @OneToMany
    private Set<Reservation> reservationSet = new HashSet<>();

    @Lob
    private String image;

}
