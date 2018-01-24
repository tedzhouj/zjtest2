package test.menus;

import com.alibaba.fastjson.JSONObject;
import com.moxie.commons.BaseJsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhoujun on 2017/8/25.
 */
public class GetMenuForInsert {

    protected static HashMap<String, List<JSONObject>> objList;

    public static void main(String[] args)throws Exception {

        objList = JSONObject.parseObject( GetMenuForInsert.class.getResourceAsStream("/test/menu_list.json")    , HashMap.class );
        System.out.println();
        List<JSONObject> list = objList.get("menus");

        List<MenuItem> mlist = new ArrayList<>();
        list.forEach(record->
                mlist.add( JSONObject.toJavaObject(record , MenuItem.class) )
        );

        mlist.forEach(record ->{
            insertsql(record);
        });
        System.out.println();

    }

    public static void insertsql(MenuItem menuItem){
    String str = "insert into t_cfg_cf_sys_resource(id,parent_id,resource_url,resource_type,resource_name,resource_icon_id,resource_order,resource_level,created_by,status,created_at) values("
       +"'"+  menuItem.getId() +"',"+
            "'"+menuItem.getParentId()   +"',"+
            "'"+menuItem.getRoute()   +"',"+
            "'1'," +
            "'"+ menuItem.getName()  +"',"+
            "'"+ menuItem.getIconId()  +"',"+
            "'"+  menuItem.getOrder() +"',"+
            "'"+  menuItem.getLevel() +"'," +
            "'sys init'," +
            "'ACTIVE'," +
            " now()" +
            ") ;";
        System.out.println(str);

    }








}
