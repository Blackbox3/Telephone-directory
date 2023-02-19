package com.college.campaign.entities.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@Getter
@Setter
@Entity
@Table(name = "REGISTRATION_LOG_TRACKER")
public class RegistrationLogTracker {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TRACK_ID")
    private Long trackId;
}
