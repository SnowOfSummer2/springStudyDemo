package com.betterchengpu.bussiness;

import com.betterchengpu.IImpl.SpitterRepository;
import com.betterchengpu.model.TestTable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

public class JdbcSpitterRepository implements SpitterRepository {
    private JdbcOperations jdbcOperations;

    public JdbcSpitterRepository(JdbcOperations operations){
        this.jdbcOperations=operations;
    }

    @Override
    public TestTable addSpitter(TestTable tb){
        jdbcOperations.update("insert into TestTable (KeyId, A, B)"+" values (?, ?, ?)",tb.getKeyId(),tb.getA(),tb.getB());
        return tb;
    }

    @Override
    public TestTable findOne(String keyId) {
        return jdbcOperations.queryForObject("select * from TestTable where KeyId=?",(rs,rowNum)->{ TestTable tb= new TestTable();
        tb.setKeyId(rs.getString("KeyId"));
        tb.setA(rs.getInt("A"));
        tb.setB(rs.getString("b"));
        return  tb;
        },keyId);
    }
}
