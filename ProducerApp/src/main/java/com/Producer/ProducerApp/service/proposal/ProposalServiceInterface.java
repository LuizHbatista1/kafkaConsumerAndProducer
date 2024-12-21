package com.Producer.ProducerApp.service.proposal;

import com.Producer.ProducerApp.DTOS.ProposalDTO;
import com.Producer.ProducerApp.domain.Proposal;

public interface ProposalServiceInterface {

    Proposal createAndSaveProposal(ProposalDTO proposalDTO);

}
