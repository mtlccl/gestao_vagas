package br.com.matheus.gestao_vagas.modules.company.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheus.gestao_vagas.modules.company.entitys.JobEntity;
import br.com.matheus.gestao_vagas.modules.company.useCases.CreateTrabalhoCasosUsar;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateTrabalhoCasosUsar createTrabalhoCasosUsar;

    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity) {
        return this.createTrabalhoCasosUsar.execute(jobEntity);
    }

}
