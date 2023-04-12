package com.example.oenskeseddel.Repository;

import com.example.oenskeseddel.Model.Bruger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrugerRepo {
    // This method will add a wish.
    @Autowired
    JdbcTemplate template;

    public List<Bruger> fetchAll() {
        String sql = "SELECT* FROM bruger";
        RowMapper<Bruger> bruger = new BeanPropertyRowMapper<>(Bruger.class);
        return template.query(sql, bruger);
    }
    public void addBruger(Bruger A) {
        String sql = "INSERT INTO bruger(bruger_id,fornavn,efternavn,brugernavn,bruger_email)VALUES(?,?,?,?,?)";
        template.update(sql, A.getBruger_id(), A.getFornavn(), A.getEfternavn(), A.getBrugernavn(), A.getBruger_email());

    }
    public Bruger findeBruger(int id) {
        String sql = "SELECT* FROM bruger WHERE id=?";
        RowMapper<Bruger> rowMapper = new BeanPropertyRowMapper<>(Bruger.class);
        Bruger bruger = template.queryForObject(sql, rowMapper, id);
        return bruger;
    }
    public boolean deleteBruger(int id) {
    String sql="DELETE FROM bruger WHERE id=?";
    return template.update(sql,id)>0;
    }

    public void updateBruger(int id, Bruger a) {
        String sql="UPDATE bruger SET fornavn=?,efternavn=?,brugernavn=?,bruger_email=?WHERE id=?";
        template.update(sql,a.getFornavn(),a.getEfternavn(),a.getBrugernavn(),a.getBruger_email(),a.getBruger_id());
    }


}
