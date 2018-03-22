package com.ambiciousteam.hotelsys.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Class to modelling the Room entity.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@Entity
@Data
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_status", length = 20)
    private String status;

    @Column(name = "room_category", length = 50, nullable = false)
    private String category;

    @Column(name = "room_number", length = 7, unique = true, nullable = false)
    private String number;

    @Column(name = "card_key", length = 50, unique = true)
    private String cardKey;

    @Column(name = "room_description")
    private String description;

    @Column(name = "room_extension_number", length = 6, unique = true)
    private Long extensionNumber;

    @Column(name = "room_tv")
    private boolean tv;

    @Column(name = "room_cable_tv")
    private boolean cableTv;

    @Column(name = "room_fridge")
    private boolean fridge;

    @Column(name = "room_bunk")
    private boolean bunk;

    @Column(name = "room_double_bed")
    private boolean doubleBed;

    @Column(name = "room_single_bed")
    private boolean singleBed;

    @Column(name = "room_dvd")
    private boolean dvd;

    @Column(name = "room_air_conditioning")
    private boolean airConditioning;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "room_date_time")
    private Date dateTime;

    /* Attibutes to relationship of Entities */
//    @ManyToOne
//    @JoinColumn(name = "employee_fk", referencedColumnName = "id")
//    private Employee employeeFK;
//
//    @OneToMany(mappedBy = "roomFK", targetEntity = Hosting.class, cascade = CascadeType.ALL)
//    private List<Hosting> hostings;
}
