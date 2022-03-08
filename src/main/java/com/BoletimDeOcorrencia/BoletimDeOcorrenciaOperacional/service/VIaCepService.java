package com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.service;

import com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.model.Endereço;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="viaCep", url="https://viacep.com.br/ws")
public interface VIaCepService {

    @GetMapping("/{cep}/json/")
    Endereço consultarCep(@PathVariable("cep") String cep);

}
