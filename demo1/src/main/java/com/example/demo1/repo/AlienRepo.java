package com.example.demo1.repo;

// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.Alien;

@Repository
public class AlienRepo {

    @Autowired
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien) {
        String sql = "insert into alien ( id, name, tech) values (?,?,?)";
        int rows = template.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println(rows + "rows Affected");
    }

    public List<Alien> findAll() {

        String sql = "select * from alien";

        // RowMapper<Alien> mapper = new RowMapper<Alien>() {
        //     @Override
        //     public Alien mapRow(ResultSet rs, int rowNum) throws SQLException { // executes the result one by one...each  row at a time.
                                                                            
        //         Alien a = new Alien();
        //         a.setId(rs.getInt(1));
        //         a.setName(rs.getString(2));
        //         a.setTech(rs.getString(3));
        //         return a;
        //     }
        // };

        RowMapper<Alien>mapper=(rs,row) ->{
             Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
        };

        List<Alien> aliens = template.query(sql, mapper);

        return  aliens;
    }

}
