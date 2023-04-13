package com.example.oenskeseddel.Service;

import com.example.oenskeseddel.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepo loginRepo;

    public boolean checkLogin(String brugernavn) {
        return loginRepo.checkLogin(brugernavn);
    }

}
