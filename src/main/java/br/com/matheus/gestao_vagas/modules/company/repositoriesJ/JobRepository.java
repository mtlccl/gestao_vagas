package br.com.matheus.gestao_vagas.modules.company.repositoriesJ;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matheus.gestao_vagas.modules.company.entitys.JobEntity;

import java.util.List;


public interface JobRepository extends JpaRepository<JobEntity, UUID> {
  List<JobEntity> findByDescriptionContainingIgnoreCase(String title);

  List<JobEntity> findByCompanyId(UUID companyId);
}
