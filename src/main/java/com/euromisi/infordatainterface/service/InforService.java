package com.euromisi.infordatainterface.service;

import com.euromisi.infordatainterface.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InforService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Item> getItems(){
        String sql="select LTRIM(RTRIM(t_item)) t_item,t_dsca,t_cuni from ttcibd001350";
        List items = jdbcTemplate.query(sql,  BeanPropertyRowMapper.newInstance(Item.class));

        return items;

    }

    public Item getItemById(String itemId){
        String sql="select LTRIM(RTRIM(t_item)) t_item,t_dsca,t_cuni from ttcibd001350 where LTRIM(RTRIM(t_item))=?";
        try{
            Item item = jdbcTemplate.queryForObject(sql, new Object[]{itemId}, BeanPropertyRowMapper.newInstance(Item.class));
            return item;
        }catch(Exception e){
            return null;
        }
    }

    public List<Item> getItemsByPartialId(String itemId){
        String sql="select top 10 LTRIM(RTRIM(t_item)) t_item,t_dsca,t_cuni from ttcibd001350 where t_item like ?";
        List items = jdbcTemplate.query(sql, new Object[]{"%" + itemId + "%"}, BeanPropertyRowMapper.newInstance(Item.class));

        return items;
    }

    public int countItemById(String itemId){
        String sql="select count(*) num from ttcibd001350 where LTRIM(RTRIM(t_item))=?";
        try{
            int num = jdbcTemplate.queryForObject(sql, new Object[]{itemId}, Integer.class);
            return num;
        }catch(Exception e){
            return 0;
        }
    }
}
