package com.example.jobagapi.resource;

import com.example.jobagapi.domain.model.User;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SavePaymentResource {

    @NotNull
    public Float amount;

    private Date createdAt;

    public  SavePaymentResource()
    {}

    public SavePaymentResource(Float amount, Date createdAt) {
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
