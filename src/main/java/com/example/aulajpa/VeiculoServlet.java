package com.example.aulajpa;

import java.io.*;
import java.util.List;

import com.example.aulajpa.domain.entities.Veiculo;
import com.example.aulajpa.repository.VeiculoRepository;
import com.example.aulajpa.service.AuthenticationService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "veiculoServlet", value = "/veiculos")
public class VeiculoServlet extends HttpServlet {

    VeiculoRepository repository;
    AuthenticationService service;

    public VeiculoServlet (){
        this.repository = new VeiculoRepository();
        this.service = new AuthenticationService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        List<Veiculo> veiculos = repository.findAll();

        request.setAttribute("attr_veiculos", veiculos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}