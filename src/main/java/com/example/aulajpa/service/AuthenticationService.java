package com.example.aulajpa.service;

import com.example.aulajpa.domain.entities.Proprietario;
import com.example.aulajpa.repository.ProprietarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class AuthenticationService {

    ProprietarioRepository repository;

    public AuthenticationService(){
        repository = new ProprietarioRepository();
    }

    public static String generatePassword(String plainTextPassword){
        /*
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
        */
        return null;
    }

    private Boolean passwordMatch(String plainPassword, String hashedPassword) {
         /*
        return BCrypt.checkpw(plainPassword, hashedPassword);
        */
        return null;
    }

    public Proprietario verifyLogin(String email, String password){

        /*
        Proprietario proprietario = repository.findByEmail(email);

        if (proprietario == null) {
            throw new IllegalArgumentException("Invalid e-mail when verify login");
        }

        if(!passwordMatch(password, proprietario.getPassword())){
            throw new IllegalArgumentException("Invalid password");
        }

        return proprietario;
        */

        return null;
    }

    public void createSession(HttpServletRequest request, Proprietario proprietario){
        HttpSession session = request.getSession(true);
        session.setAttribute("proprietario", proprietario);
    }
}
