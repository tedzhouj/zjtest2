package hello.Dao;

import hello.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhoujun on 2017/7/6.
 */
@Service
public class UserDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public  MyUser getUserByName(String name){
        MyUser myUser = new    MyUser();
//        Map<String,String> params = new HashMap<String,String>();
//        params.put("name",name);
        RowMapper<MyUser> rowMapper=new BeanPropertyRowMapper<MyUser>(MyUser.class);
        String sql="select name,age from my_users where name = ?";
        List<MyUser> lists =  jdbcTemplate.query(sql, rowMapper, name);

        myUser.setName(lists.get(0).getName());
        myUser.setAge(lists.get(0).getAge());
        return myUser;
    }



}
