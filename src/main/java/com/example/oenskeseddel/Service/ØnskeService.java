package com.example.oenskeseddel.Service;

import com.example.oenskeseddel.Model.Bruger;
import com.example.oenskeseddel.Model.Ønske;
import com.example.oenskeseddel.Repository.ØnskeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ØnskeService
{
    @Autowired
    ØnskeRepo ønskeRepo;

    public List<Ønske> fetchAll()
    {
        return ønskeRepo.fetchAll();
    }

    public void addØnske(Ønske ø)
    {
        ønskeRepo.addØnske(ø);
    }
    public Ønske findeØnske(int id)
    {
      return ønskeRepo.findeØnske(id);
    }
    public void deletØnske(int id,Ønske ø)
    {
        ønskeRepo.updateØnske(id,ø);
    }


}
