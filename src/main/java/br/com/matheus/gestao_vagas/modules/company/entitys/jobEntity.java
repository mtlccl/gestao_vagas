package br.com.matheus.gestao_vagas.modules.company.entitys;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "job")
@Data
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String benefits;

    @NotBlank(message = "esse campo e obrigatorio")
    private String level;

    @ManyToOne()
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity companyEntity;

    @Column(name = "company_id", nullable = false)
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
