package com.Producer.ProducerApp.controller;

import com.Producer.ProducerApp.DTOS.ProposalDTO;
import com.Producer.ProducerApp.domain.Proposal;
import com.Producer.ProducerApp.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProposalController {

    private final ProposalService proposalService;

    @Autowired
    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @PostMapping("/proposal")
    public ResponseEntity<Proposal>createProposal(@RequestBody ProposalDTO proposalDTO){

        Proposal newProposal = proposalService.createAndSaveProposal(proposalDTO);
        return new ResponseEntity<>(newProposal , HttpStatus.CREATED);


    }
}
