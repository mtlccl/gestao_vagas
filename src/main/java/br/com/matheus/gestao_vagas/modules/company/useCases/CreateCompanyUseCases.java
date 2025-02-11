package br.com.matheus.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheus.gestao_vagas.exceptions.UserFoundExcetion;
import br.com.matheus.gestao_vagas.modules.company.entitys.CompanyEntity;
import br.com.matheus.gestao_vagas.modules.company.repositoriesJ.CompanyRepositorios;

@Service
public class CreateCompanyUseCases {
    
    @Autowired
    private CompanyRepositorios companyRepositorios;

    public CompanyEntity execute(CompanyEntity companyEntity){

        this.companyRepositorios.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail()).ifPresent((user)-> {
            throw new UserFoundExcetion();
        });

        return this.companyRepositorios.save(companyEntity);
    }
}
