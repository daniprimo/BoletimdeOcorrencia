package com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EnderecoRepository extends CrudRepository<Endereço, String> {


}
