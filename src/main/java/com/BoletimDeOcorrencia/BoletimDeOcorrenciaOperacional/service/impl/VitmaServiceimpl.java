package com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.service.impl;

import com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.model.Endereço;
import com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.model.EnderecoRepository;
import com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.model.Vitma;
import com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.model.VitmaRepository;
import com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.service.VIaCepService;
import com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.service.VitmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VitmaServiceimpl implements VitmaService {
    //Singletoon: implementar todos os componentes do spring   com @Autowired
    @Autowired
    private VitmaRepository vitmaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private VIaCepService vIaCepService;

    @Autowired
    private  Endereço endereço;

    public VitmaServiceimpl() {
    }


    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.



    @Override
    public Iterable<Vitma> buscarTodos() {
        return vitmaRepository.findAll();
    }

    @Override
    public Vitma buscarPorId(Long id) {
        Optional<Vitma> vitma = vitmaRepository.findById(id);
        return vitma.get();
    }



    @Override
    public void inserirVitma(Vitma vitma) {
          SalvarVitmaComCep(vitma);
    }

    @Override
    public void atualziar(Long id, Vitma vitma) {
        Optional<Vitma> vitmaBD = vitmaRepository.findById(id);
        if (vitmaBD.isPresent()){
            SalvarVitmaComCep(vitma);
        };
    }

    @Override
    public void deletar(Long id) {
        vitmaRepository.deleteById(id);
    }

    //É nescessário criar este metodo para manipulação dos dados no BD, e adicionar os dados do via cep

    private void SalvarVitmaComCep(Vitma vitma) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = vitma.getEndereço().getCep();
        Endereço endereço = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereço novoEndereco = vIaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        vitma.setEndereço(endereço);

        vitmaRepository.save(vitma);

    }
}
