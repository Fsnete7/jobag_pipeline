package com.example.jobagapi.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Payments")
public class Payment extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private Float amount;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "fk_user_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private User user;

    public Payment() {
    }

    public Payment(Long id, Float amount) {
        this.id = id;
        this.amount = amount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

}
