package com.example.test.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Getter @Setter


public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_seq")
    private Long id;

    @ManyToOne
    private User users;

    @ManyToOne
    private Car car;

    private Date timestart;
    private Date timeend;


}
