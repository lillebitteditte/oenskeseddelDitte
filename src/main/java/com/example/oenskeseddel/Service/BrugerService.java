package com.example.oenskeseddel.Service;

import com.example.oenskeseddel.Model.Bruger;
import com.example.oenskeseddel.Repository.BrugerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrugerService {

    @Autowired
    BrugerRepo brugerRepo;

    public List<Bruger> fetchAll() {
        return brugerRepo.fetchAll();
    }

    public void addBruger(Bruger B) {
        brugerRepo.addBruger(B);
    }

    public Bruger findBrugerID(int id) {
        return brugerRepo.findeBruger(id);
    }

    public void deleteBruger(int id, Bruger B) {
        brugerRepo.updateBruger(id, B);
    }


}
