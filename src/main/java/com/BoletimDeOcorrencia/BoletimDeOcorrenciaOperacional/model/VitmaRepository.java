package com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitmaRepository extends CrudRepository<Vitma, Long> {

}
