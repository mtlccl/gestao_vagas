package br.com.matheus.gestao_vagas.modules.cadidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheus.gestao_vagas.exceptions.UserFoundExcetion;
import br.com.matheus.gestao_vagas.modules.cadidate.CandidateEntity;
import br.com.matheus.gestao_vagas.modules.cadidate.CandidateRepository;

@Service
public class CreatedCandidateUseCases {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundExcetion();
                });
        return this.candidateRepository.save(candidateEntity);
    }

}
