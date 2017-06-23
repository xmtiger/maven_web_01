/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikex.form.dao;

import com.mikex.form.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 *
 * @author xmtig
 */
@Repository
public class UserDaoImpl implements UserDao{
    
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User findById(Integer id) {
        
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        
        String sql = "SELECT * FROM users WHERE id=:id";
        
        User result = null;
        try{
            result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());            
        }catch(EmptyResultDataAccessException e){
            //do nothing, return null
            return null;
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class UserMapper implements RowMapper<User>{
        
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException{
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setFramework(convertDelimitedStringToList(rs.getString("framework")));
            user.setAddress(rs.getString("address"));
            user.setCountry(rs.getString("country"));
            user.setNewsletter(rs.getBoolean("newsletter"));
            user.setNumber(rs.getInt("number"));
            user.setPassword(rs.getString("password"));
            user.setSex(rs.getString("sex"));
            user.setSkill(convertDelimitedStringToList(rs.getString("skill")));
            
            return user;
        }
    }
    
    private static List<String> convertDelimitedStringToList(String delimitedString){
        
        List<String> result = new ArrayList();
        
        if(!StringUtils.isEmpty(delimitedString)){
            result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
        }
        return result;
    }
}
