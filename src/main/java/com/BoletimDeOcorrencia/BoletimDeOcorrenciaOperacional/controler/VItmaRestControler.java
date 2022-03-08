package com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.controler;

import com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.model.Vitma;
import com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.service.VitmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Vitma")
public class VItmaRestControler {

    @Autowired
    private VitmaService vitmaService;

   @GetMapping
    public  ResponseEntity<Iterable<Vitma>> buscarTodos(){
       return ResponseEntity.ok(vitmaService.buscarTodos());
   }
   @GetMapping("/{id}")
    public  ResponseEntity<Vitma> buscarPorId(@PathVariable Long id){
       return ResponseEntity.ok(vitmaService.buscarPorId(id));
   }

   @PostMapping
    public ResponseEntity<Vitma> inserir (@RequestBody Vitma vitma){
       vitmaService.inserirVitma(vitma);
       return ResponseEntity.ok(vitma);
   }

   @PutMapping("/{id}")
    public ResponseEntity<Vitma> atualizar(@PathVariable Long id, @RequestBody Vitma vitma){
       vitmaService.atualziar(id, vitma);
       return ResponseEntity.ok(vitma);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
       vitmaService.deletar(id);
       return ResponseEntity.ok().build();
   }



}
