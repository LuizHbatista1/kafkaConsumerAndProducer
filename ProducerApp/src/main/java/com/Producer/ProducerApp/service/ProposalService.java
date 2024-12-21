package com.Producer.ProducerApp.service;

import com.Producer.ProducerApp.DTOS.ProposalDTO;
import com.Producer.ProducerApp.domain.Customer;
import com.Producer.ProducerApp.domain.Proposal;
import com.Producer.ProducerApp.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final CustomerService customerService;

    @Autowired
    public ProposalService(ProposalRepository proposalRepository, CustomerService customerService) {
        this.proposalRepository = proposalRepository;
        this.customerService = customerService;
    }


    public Proposal createAndSaveProposal(ProposalDTO proposalDTO){

        Customer customer = customerService.findCustomerById(proposalDTO.customerId());
        Proposal newProposal = new Proposal(proposalDTO);
        newProposal.setCustomer(customer);
        newProposal.setLoan(newProposal.getLoan());
        newProposal.setMouths(newProposal.getMouths());
        this.proposalRepository.save(newProposal);
        return newProposal;


    }

}
