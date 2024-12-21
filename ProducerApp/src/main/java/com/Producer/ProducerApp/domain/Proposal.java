package com.Producer.ProducerApp.domain;

import com.Producer.ProducerApp.DTOS.ProposalDTO;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

@Table(name = "proposals")
@Entity(name = "proposals")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;
    private Double loan;
    private Integer mouths;

    public Proposal(){

    }

    public Proposal(ProposalDTO data){
        this.customer = customer;
        this.loan = data.loan();
        this.mouths = data.mouths();

    }

    public Proposal(Long id, Customer customer, Double loan, Integer mouths) {
        this.id = id;
        this.customer = customer;
        this.loan = loan;
        this.mouths = mouths;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getLoan() {
        return loan;
    }

    public void setLoan(Double loan) {
        this.loan = loan;
    }

    public Integer getMouths() {
        return mouths;
    }

    public void setMouths(Integer mouths) {
        this.mouths = mouths;
    }
}
