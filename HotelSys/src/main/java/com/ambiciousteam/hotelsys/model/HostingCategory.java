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
 * Class to modelling the Room Category.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@Entity
@Data
public class HostingCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_category_name", length = 20)
    private String name;
    
    @Column(name = "room_category_description", length = 20)
    private String description;

    @Column(name = "room_category_price", length = 20)
    private Double price;

    /**
     * This attibute register the date wich change on this class, in TIMESTAMP
     * format
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date_time")
    private Date dateTime;
    
}
