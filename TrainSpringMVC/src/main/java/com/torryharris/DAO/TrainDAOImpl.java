package com.torryharris.DAO;

import com.torryharris.api.Train;
import com.torryharris.mapper.TrainRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TrainDAOImpl implements TrainDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Train> loadTrains() {
        List<Train>trainList=new ArrayList<Train>();
            String sql="select * from trains";
            List<Train>trainList1=jdbcTemplate.query(sql,new TrainRowMapper());
            return trainList1;
        }
        public List<Train>loadTrains(int trainNo)
        {
            List<Train>trainList=new ArrayList<Train>();
            String sql="select * from trains where train_no="+trainNo;
            List<Train>trainList1=jdbcTemplate.query(sql,new TrainRowMapper());
            return trainList1;



        }
    }

