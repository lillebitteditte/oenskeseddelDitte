package com.example.oenskeseddel.Service;

import com.example.oenskeseddel.Model.Ønske;
import com.example.oenskeseddel.Repository.BrugerRepo;
import com.example.oenskeseddel.Repository.ØnskeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ØnskeService {
    @Autowired
    ØnskeRepo ønskeRepo;
    BrugerRepo brugerRepo;

    public List<Ønske> fetchAll() {
        return ønskeRepo.fetchAll();
    }

    public List<Ønske> fetchUserWishes(int userId) {
        return ønskeRepo.fetchUserWishes(userId);
    }

    public void addØnske(Ønske ø) {
        System.out.println("test2");
        ønskeRepo.addØnske(ø);
    }

    public Ønske findeØnske(int id) {
        return ønskeRepo.findeØnske(id);
    }

    public Boolean deleteØnske(int id) {
        return ønskeRepo.deleteØnske(id);
    }

    public void opdaterØnske(int id, Ønske ø) {
        ønskeRepo.opdaterØnske(id, ø);
    }
/*
    public Bruger findBrugerById(int id){
        return ønskeRepo.findbrugerById(id);
    }


 */
    public List<Ønske> findØnskerByBrugerId(int brugerId) {
        List<Ønske> alleØnsker = ønskeRepo.fetchAll();
        return alleØnsker.stream()
                .filter(o -> o.getBruger_id() == brugerId)
                .collect(Collectors.toList());
    }

}
