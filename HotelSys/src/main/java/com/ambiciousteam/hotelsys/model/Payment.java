package com.ambiciousteam.hotelsys.model;

import com.ambiciousteam.hotelsys.enumerations.PaymentWay;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Class to modelling the Room Payment.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@Entity
@Data
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_value", length = 10)
    private Double value;
    
    @Column(name = "payment_way")
    @Enumerated(EnumType.STRING)
    private PaymentWay paymentWay;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date")
    private Date payment_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date_time")
    private Date dateTime;
}
