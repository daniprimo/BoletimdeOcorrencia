package com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.service;

import com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.model.Vitma;

public interface VitmaService {

    Iterable<Vitma> buscarTodos ();

    Vitma buscarPorId(Long id);

    void inserirVitma (Vitma vitma);

    void atualziar(Long id, Vitma vitma);

    void deletar (Long id);

}
