package test.beans;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xinbang.credit.mxauth.common.dto.notify.bill.bank.MxBankDto;
import com.xinbang.credit.mxauth.common.dto.notify.req.NotifyBankReqDto;

import java.util.Map;

/**
 * Created by zhoujun on 2017/7/12.
 */
public class ObjectToJSON {


    public static void main(String[] args) {
        MxBankDto mxBankDto = new MxBankDto();
        mxBankDto.setBaseInfo(new NotifyBankReqDto());


        test(mxBankDto);
        Map mp=  objectToMap(mxBankDto);

//        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject( mp );
//        System.out.println( jsonObject );

    }

    public static void test(Object obj) {

        String str = JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue);//将java对象转换为json对象
      //  String str = json.toString();//将json对象转换为字符串
        System.out.println(str);
    }

    public static Map<?, ?> objectToMap(Object obj) {
        if(obj == null)
            return null;

        return new org.apache.commons.beanutils.BeanMap(obj);
    }


}
