package com.example.aulajpa;

import com.example.aulajpa.domain.entities.Proprietario;
import com.example.aulajpa.domain.entities.Veiculo;
import com.example.aulajpa.domain.enums.TipoCombustivel;
import com.example.aulajpa.repository.ProprietarioRepository;
import com.example.aulajpa.repository.VeiculoRepository;

import java.math.BigDecimal;
import java.util.List;

public class AppTest {


    public static void main(String[] args) {

        VeiculoRepository veiculoRepository = new VeiculoRepository();
        ProprietarioRepository proprietarioRepository = new ProprietarioRepository();


        Proprietario p1 = new Proprietario(); //p1 rua da alegria 01
        p1.setNome("Jefferson");
        p1.setEmail("jefferson.chaves@ifpr.edu.br");

        //proprietarioRepository.create(p1);

        Veiculo v1 = new Veiculo();

        v1.setModelo("Uno");
        v1.setFabricante("Fiat");
        v1.setAnoFabricacao(1994);
        v1.setAnoModelo(1995);
        v1.setValor(new BigDecimal("10000.00"));
        v1.setTipoCombustivel(TipoCombustivel.GASOLINA);
        v1.setProprietario(p1);
        //veiculoRepository.create(v1);

        Veiculo v2 = new Veiculo();

        v2.setModelo("Twingo");
        v2.setFabricante("Renault");
        v2.setAnoFabricacao(1994);
        v2.setAnoModelo(1995);
        v2.setValor(new BigDecimal("10000.00"));
        v2.setTipoCombustivel(TipoCombustivel.GASOLINA);
        v2.setProprietario(p1);
        //veiculoRepository.create(v2);

        List<Veiculo> veiculos = veiculoRepository.findAll();

        /*
        for(Veiculo v: veiculos){
            System.out.println(v.getModelo() + " " + v.getProprietario().getNome());
        }*/

        List<Proprietario> proprietarios = proprietarioRepository.findAll();
        for(Proprietario p: proprietarios){
            System.out.println("PROPRIETARIO: " + p.getNome());

            for(Veiculo v: p.getVeiculos()){
                System.out.println(v.getModelo() + " " + v.getFabricante());
            }
        }
    }
}
