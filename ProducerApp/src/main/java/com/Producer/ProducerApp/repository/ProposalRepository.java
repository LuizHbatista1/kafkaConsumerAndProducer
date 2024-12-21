package com.Producer.ProducerApp.repository;

import com.Producer.ProducerApp.domain.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
