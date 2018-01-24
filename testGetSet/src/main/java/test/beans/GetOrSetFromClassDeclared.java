package test.beans;

//import com.moxie.cloud.services.asset.dto.moxie.mail.AllDataBill;
//import com.moxie.cloud.services.asset.dto.moxie.mail.CreditBillInstallment;
//import com.moxie.cloud.services.asset.dto.moxie.mail.CreditBillShoppingSheet;
//import com.moxie.cloud.services.asset.dto.moxie.onlinebank.BillDetail;
//import com.moxie.cloud.services.asset.dto.moxie.onlinebank.BillItem;
//import com.moxie.cloud.services.asset.dto.moxie.onlinebank.CardDeposit;
//import com.moxie.cloud.services.asset.dto.moxie.onlinebank.CardDetail;
//import com.moxie.cloud.services.asset.dto.moxie.onlinebank.Installment;
//import com.xinbang.credit.mxauth.common.dto.notify.bill.creditbill.MxCreditBillAllDataInfo;

import com.xinbang.cfs.dao.model.AccountPO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoujun on 2017/7/12.
 */
public class GetOrSetFromClassDeclared {

    /**
     * get/set代码生成
     *
     * @param args
     */
    public static void main(String[] args) {
        //pringSetValue(CreditBillInstallment.class,"","");
        //pringSet(MxCreditBillAllDataInfo.class, "allDataBill");
        //pringSetValue(AllDataBill.class,"allDataBill","mxdatainfo");
        //pringSetValue(CreditBillInstallment.class,"creditBillInstallment","mxCreditBillInstallmentInfo");
        //pringSetValue(CreditBillShoppingSheet.class,"creditBillShoppingSheet","mxCreditBillShoppingSheetInfo");
        //pringSetValue(CardDetail.class,"cardDetail","mxBankCardDetailInfo");
        //pringSetValue(CardDeposit.class,"cardDeposit","mxBankCardDepositInfo");
//        pringSetValue(BillDetail.class,"bills","mxBankBillDetailInfo");
//        pringSetValue(BillItem.class,"billItem","mxBankBillItemInfo");
        //pringSetValue(Installment.class,"installments","mxBankInstallmentInfo");
        //pringSetValue(CreditBillInstallment.class,"","");
        //pringSetValue(CreditBillInstallment.class,"","");
        //pringSetValue(CreditBillInstallment.class,"","");

        pringSetValue(AccountPO.class, "accountPO", "req");

    }

    public static void pringGet(Class clazz, String beanName) {
        Field[] BeanSetField = clazz.getDeclaredFields();
        List<Field> BeanSetList = new ArrayList<Field>();
        BeanSetList.addAll(Arrays.asList(BeanSetField));
        for (Field entry : BeanSetList) {
            System.out.println(beanName + "." + "get" + entry.getName().substring(0, 1).toUpperCase() + entry.getName().substring(1) + "();");
        }
    }

    public static void pringSet(Class clazz, String beanName) {
        Field[] BeanSetField = clazz.getDeclaredFields();
        List<Field> BeanSetList = new ArrayList<Field>();
        BeanSetList.addAll(Arrays.asList(BeanSetField));
        for (Field entry : BeanSetList) {
            System.out.println(beanName + "." + "set" + entry.getName().substring(0, 1).toUpperCase() + entry.getName().substring(1) + "();");
        }
    }

    public static void pringSetValue(Class clazz, String beanName, String fromBeanName) {
        Field[] BeanSetField = clazz.getDeclaredFields();
        List<Field> BeanSetList = new ArrayList<Field>();
        BeanSetList.addAll(Arrays.asList(BeanSetField));
        for (Field entry : BeanSetList) {
            System.out.println(beanName + "." + "set" + entry.getName().substring(0, 1).toUpperCase() + entry.getName().substring(1) + "(" + fromBeanName + ".get" + entry.getName().substring(0, 1).toUpperCase() + entry.getName().substring(1) + "()" + ");");
        }
    }

}
