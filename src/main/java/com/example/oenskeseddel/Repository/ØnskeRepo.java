package com.example.oenskeseddel.Repository;

import com.example.oenskeseddel.Model.Ønske;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ØnskeRepo {
    @Autowired
    JdbcTemplate template;

    public List<Ønske> fetchAll()
    {
        String sql = "SELECT* FROM ønske";
        RowMapper<Ønske> rowMapper = new BeanPropertyRowMapper<>(Ønske.class);
        return template.query(sql, rowMapper);
    }

    public void addØnske(Ønske Ø)
    {
        String sql = "INSERT INTO ønske(navn,beskrivelse,linke,bruger_id)VALUES (?,?,?)";
        template.update(sql, Ø.getNavn(), Ø.getBeskrivelse(), Ø.getLink(),Ø.getBruger_id());

    }


}
