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
        String sql = "SELECT* FROM oenske";
        RowMapper<Ønske> rowMapper = new BeanPropertyRowMapper<>(Ønske.class);
        return template.query(sql, rowMapper);
    }

    public List<Ønske> fetchUserWishes(int id) {
       String sql = "SELECT * FROM oenske WHERE bruger_id = ?";
       RowMapper<Ønske> rowMapper = new BeanPropertyRowMapper<>(Ønske.class);
       return template.query(sql, rowMapper, id);
    }

    public void addØnske(Ønske ø) {
        System.out.println("test3");
        String sql = "INSERT INTO oenske(navn, beskrivelse,link, bruger_id)VALUES (?,?,?,?)";
        System.out.println("test4");
        template.update(sql, ø.getNavn(), ø.getBeskrivelse(), ø.getLink(), ø.getBruger_id());
        System.out.println("test12");
    }

    public Ønske findeØnske(int id) {
        String sql = "SELECT* FROM oenske WHERE id=?";
        RowMapper<Ønske> rowMapper = new BeanPropertyRowMapper<>(Ønske.class);
        Ønske ønske = template.queryForObject(sql, rowMapper, id);
        return ønske;
    }

    public Boolean sletOenske(int id) {
        String sql = "DELETE FROM oenske WHERE id=?";
        return template.update(sql, id) > 0;
    }

    // This method will update the ønske.
    public void opdaterOenske(int id, Ønske ø) {
        String sql = "UPDATE oenske SET id=? navn = ?,beskrivelse=?,link=?,bruger_id=?WHERE id=?";
        template.update(sql, ø.getId(), ø.getNavn(), ø.getBeskrivelse(), ø.getLink(), ø.getBruger_id());
    }


}
