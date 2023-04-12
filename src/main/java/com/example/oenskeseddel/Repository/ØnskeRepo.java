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

    public List<Ønske> fetchAll() {
        String sql = "SELECT* FROM ønske";
        RowMapper<Ønske> rowMapper = new BeanPropertyRowMapper<>(Ønske.class);
        return template.query(sql, rowMapper);
    }

    public void addØnske(Ønske Ø) {
        String sql = "INSERT INTO ønske(navn,beskrivelse,linke,bruger_id)VALUES (?,?,?)";
        template.update(sql, Ø.getNavn(), Ø.getBeskrivelse(), Ø.getLink(), Ø.getBruger_id());

    }

    public Ønske findeØnske(int id) {
        String sql = "SELECT* FROM ønske WHERE id=?";
        RowMapper<Ønske> rowMapper = new BeanPropertyRowMapper<>(Ønske.class);
        Ønske ønske = template.queryForObject(sql, rowMapper, id);
        return ønske;
    }

    public Boolean deletØnske(int id) {
        String sql = "DELETE FROM ønske WHERE id=?";
        return template.update(sql, id) > 0;
    }
    // This method will update the ønske.
   public void updateØnske(int id,Ønske ø) {
   String sql="UPDATE ønske SET navn=?,beskrivelse=?,link=?,bruger_id=?WHERE id=?";
   template.update(sql,ø.getNavn(),ø.getBeskrivelse(),ø.getLink(),ø.getBruger_id());
   }


}
