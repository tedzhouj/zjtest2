//package test.beans;
//
//import com.google.gson.Gson;
//import com.xinbang.credit.mxauth.common.dto.notify.bill.bank.MxBankDto;
//import com.xinbang.credit.mxauth.common.dto.notify.bill.creditbill.MxCardBillDto;
//
///**
// * Created by zhoujun on 2017/7/12.
// */
//public class TestConvert {
//
//
//    public static void main(String[] args) {
//        test22();
//    }
//
//
//    public static void test(){
//        Gson gs = new Gson();
//        String str = "{\n" +
//                "  \"baseInfo\": {\n" +
//                "    \"cards\": [\n" +
//                "      {\n" +
//                "        \"bills\": [\n" +
//                "          {\n" +
//                "            \"bill_date\": \"2017-07-12T09:19:04.496Z\",\n" +
//                "            \"bill_id\": \"string\"\n" +
//                "          }\n" +
//                "        ],\n" +
//                "        \"card_id\": \"string\",\n" +
//                "        \"card_type\": \"string\"\n" +
//                "      }\n" +
//                "    ],\n" +
//                "    \"task_id\": \"string\",\n" +
//                "    \"timestamp\": \"string\",\n" +
//                "    \"user_id\": \"string\",\n" +
//                "    \"username\": \"string\"\n" +
//                "  },\n" +
//                "  \"cardList\": [\n" +
//                "    {\n" +
//                "      \"balance\": 0,\n" +
//                "      \"bank_name\": \"string\",\n" +
//                "      \"bills\": [\n" +
//                "        {\n" +
//                "          \"bank_name\": \"string\",\n" +
//                "          \"bill_date\": \"string\",\n" +
//                "          \"bill_month\": \"string\",\n" +
//                "          \"bill_type\": \"string\",\n" +
//                "          \"cash_limit\": 0,\n" +
//                "          \"credit_limit\": 0,\n" +
//                "          \"installments\": [\n" +
//                "            {\n" +
//                "              \"amount_money\": 0,\n" +
//                "              \"currency_type\": \"string\",\n" +
//                "              \"current_month\": 0,\n" +
//                "              \"handing_fee\": 0,\n" +
//                "              \"handingfee_desc\": \"string\",\n" +
//                "              \"installment_desc\": \"string\",\n" +
//                "              \"installment_type\": \"string\",\n" +
//                "              \"post_date\": \"string\",\n" +
//                "              \"shoppingsheet_id\": \"string\",\n" +
//                "              \"total_month\": 0,\n" +
//                "              \"trans_date\": \"string\",\n" +
//                "              \"transfer_fee\": 0,\n" +
//                "              \"transferfee_desc\": \"string\"\n" +
//                "            }\n" +
//                "          ],\n" +
//                "          \"interest\": 0,\n" +
//                "          \"last_balance\": 0,\n" +
//                "          \"last_payment\": 0,\n" +
//                "          \"min_payment\": 0,\n" +
//                "          \"new_balance\": 0,\n" +
//                "          \"new_charges\": 0,\n" +
//                "          \"payment_due_date\": \"string\",\n" +
//                "          \"shopping_sheets\": [\n" +
//                "            {\n" +
//                "              \"amount_money\": 0,\n" +
//                "              \"balance\": 0,\n" +
//                "              \"card_num\": \"string\",\n" +
//                "              \"category\": \"string\",\n" +
//                "              \"currency_type\": \"string\",\n" +
//                "              \"description\": \"string\",\n" +
//                "              \"id\": \"string\",\n" +
//                "              \"name_on_opposite_card\": \"string\",\n" +
//                "              \"opposite_bank\": \"string\",\n" +
//                "              \"opposite_card_no\": \"string\",\n" +
//                "              \"order_index\": 0,\n" +
//                "              \"post_date\": \"string\",\n" +
//                "              \"remark\": \"string\",\n" +
//                "              \"trans_addr\": \"string\",\n" +
//                "              \"trans_channel\": \"string\",\n" +
//                "              \"trans_date\": \"string\",\n" +
//                "              \"trans_method\": \"string\"\n" +
//                "            }\n" +
//                "          ],\n" +
//                "          \"usd_cash_limit\": 0,\n" +
//                "          \"usd_credit_limit\": 0,\n" +
//                "          \"usd_interest\": 0,\n" +
//                "          \"usd_last_balance\": 0,\n" +
//                "          \"usd_last_payment\": 0,\n" +
//                "          \"usd_min_payment\": 0,\n" +
//                "          \"usd_new_balance\": 0,\n" +
//                "          \"usd_new_charges\": 0\n" +
//                "        }\n" +
//                "      ],\n" +
//                "      \"card_id\": \"string\",\n" +
//                "      \"card_num\": \"string\",\n" +
//                "      \"card_type\": \"string\",\n" +
//                "      \"cash_balance\": 0,\n" +
//                "      \"cash_limit\": 0,\n" +
//                "      \"credit_limit\": 0,\n" +
//                "      \"deposits\": [\n" +
//                "        {\n" +
//                "          \"balance\": 0,\n" +
//                "          \"currency_type\": \"string\",\n" +
//                "          \"deposit_date\": \"string\",\n" +
//                "          \"deposit_type\": \"string\",\n" +
//                "          \"due_date\": \"string\",\n" +
//                "          \"interest\": 0,\n" +
//                "          \"period\": 0,\n" +
//                "          \"period_unit\": \"string\"\n" +
//                "        }\n" +
//                "      ],\n" +
//                "      \"full_card_num\": \"string\",\n" +
//                "      \"name_on_card\": \"string\",\n" +
//                "      \"open_bank\": \"string\",\n" +
//                "      \"open_time\": \"string\"\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
//
//            //MxBankDto
//            //BankKafka
//        System.out.println("---------------------------------------");
//        MxBankDto ttt =  gs.fromJson(str,MxBankDto.class);
//        System.out.println(gs.toJson(ttt,MxBankDto.class));
//
//        System.out.println("---------------------------------------");
//        BankKafka xxx =  gs.fromJson(str,BankKafka.class);
//        System.out.println(gs.toJson(xxx,BankKafka.class));
//        System.out.println("---------------------------------------");
//
//    }
//
//
//    public static void test22(){
//        Gson gs = new Gson();
//        String str = "{\n" +
//                "  \"baseInfo\": {\n" +
//                "    \"bill_count\": 0,\n" +
//                "    \"email\": \"string\",\n" +
//                "    \"email_id\": \"string\",\n" +
//                "    \"task_id\": \"string\",\n" +
//                "    \"timestamp\": \"string\",\n" +
//                "    \"user_id\": \"string\"\n" +
//                "  },\n" +
//                "  \"billAllInfo\": {\n" +
//                "    \"bills\": [\n" +
//                "      {\n" +
//                "        \"adjustment\": 0,\n" +
//                "        \"bank_id\": 0,\n" +
//                "        \"bank_name\": \"string\",\n" +
//                "        \"bill_date\": \"2017-07-12T09:19:04.513Z\",\n" +
//                "        \"bill_id\": \"string\",\n" +
//                "        \"bill_start_date\": \"2017-07-12T09:19:04.513Z\",\n" +
//                "        \"card_number\": \"string\",\n" +
//                "        \"cash_amount\": 0,\n" +
//                "        \"cash_limit\": 0,\n" +
//                "        \"create_time\": \"2017-07-12T09:19:04.513Z\",\n" +
//                "        \"credit_limit\": 0,\n" +
//                "        \"currency_type\": 0,\n" +
//                "        \"email_id\": \"string\",\n" +
//                "        \"failure_point\": 0,\n" +
//                "        \"feature_point\": 0,\n" +
//                "        \"feature_point_add\": 0,\n" +
//                "        \"installments\": [\n" +
//                "          {\n" +
//                "            \"amount_money\": 0,\n" +
//                "            \"bill_id\": \"string\",\n" +
//                "            \"card_no\": \"string\",\n" +
//                "            \"currency_type\": \"string\",\n" +
//                "            \"current_month\": 0,\n" +
//                "            \"handing_fee\": 0,\n" +
//                "            \"handingfee_desc\": \"string\",\n" +
//                "            \"installment_desc\": \"string\",\n" +
//                "            \"installment_type\": 0,\n" +
//                "            \"post_date\": \"2017-07-12T09:19:04.514Z\",\n" +
//                "            \"total_month\": 0,\n" +
//                "            \"trans_date\": \"2017-07-12T09:19:04.514Z\",\n" +
//                "            \"transfer_fee\": 0,\n" +
//                "            \"transferfee_desc\": \"string\"\n" +
//                "          }\n" +
//                "        ],\n" +
//                "        \"interest\": 0,\n" +
//                "        \"last_balance\": 0,\n" +
//                "        \"last_modify_time\": \"2017-07-12T09:19:04.514Z\",\n" +
//                "        \"last_payment\": 0,\n" +
//                "        \"last_point\": 0,\n" +
//                "        \"mail_id\": \"string\",\n" +
//                "        \"mail_sender\": \"string\",\n" +
//                "        \"min_payment\": 0,\n" +
//                "        \"name_on_card\": \"string\",\n" +
//                "        \"new_balance\": 0,\n" +
//                "        \"new_charges\": 0,\n" +
//                "        \"original\": \"string\",\n" +
//                "        \"past_due_amount\": 0,\n" +
//                "        \"payment_due_date\": \"2017-07-12T09:19:04.514Z\",\n" +
//                "        \"point\": 0,\n" +
//                "        \"point_add\": 0,\n" +
//                "        \"point_adjust\": 0,\n" +
//                "        \"point_lose_date\": \"2017-07-12T09:19:04.514Z\",\n" +
//                "        \"point_reward\": 0,\n" +
//                "        \"point_travel\": 0,\n" +
//                "        \"point_used\": 0,\n" +
//                "        \"point_valid_date\": \"2017-07-12T09:19:04.514Z\",\n" +
//                "        \"point_valid_date2\": \"2017-07-12T09:19:04.514Z\",\n" +
//                "        \"point_valid_date3\": \"2017-07-12T09:19:04.514Z\",\n" +
//                "        \"shopping_sheets\": [\n" +
//                "          {\n" +
//                "            \"amount_money\": 0,\n" +
//                "            \"bank_id\": 0,\n" +
//                "            \"bill_id\": \"string\",\n" +
//                "            \"card_no\": \"string\",\n" +
//                "            \"currency_type\": 0,\n" +
//                "            \"description\": \"string\",\n" +
//                "            \"post_date\": \"2017-07-12T09:19:04.514Z\",\n" +
//                "            \"status\": true,\n" +
//                "            \"trans_addr\": \"string\",\n" +
//                "            \"trans_date\": \"2017-07-12T09:19:04.514Z\",\n" +
//                "            \"trans_org_amount\": 0,\n" +
//                "            \"trans_type\": \"string\"\n" +
//                "          }\n" +
//                "        ],\n" +
//                "        \"status\": 0,\n" +
//                "        \"usd_adjustment\": 0,\n" +
//                "        \"usd_cash_amount\": 0,\n" +
//                "        \"usd_cash_limit\": 0,\n" +
//                "        \"usd_credit_limit\": 0,\n" +
//                "        \"usd_interest\": 0,\n" +
//                "        \"usd_last_balance\": 0,\n" +
//                "        \"usd_last_payment\": 0,\n" +
//                "        \"usd_min_payment\": 0,\n" +
//                "        \"usd_new_balance\": 0,\n" +
//                "        \"usd_new_charges\": 0,\n" +
//                "        \"usd_past_due_amount\": 0,\n" +
//                "        \"voucher_balance\": 0,\n" +
//                "        \"voucher_valid_date\": \"2017-07-12T09:19:04.515Z\"\n" +
//                "      }\n" +
//                "    ],\n" +
//                "    \"size\": 0,\n" +
//                "    \"total_size\": 0\n" +
//                "  }\n" +
//                "}";
//
//        System.out.println("---------------------------------------");
//        MxCardBillDto ttt =  gs.fromJson(str,MxCardBillDto.class);
//        System.out.println(gs.toJson(ttt,MxCardBillDto.class));
//
//        System.out.println("---------------------------------------");
//        EmailKafka xxx =  gs.fromJson(str,EmailKafka.class);
//        System.out.println(gs.toJson(xxx,EmailKafka.class));
//        System.out.println("---------------------------------------");
//
//
//
//    }
//
//
//
//
//
//
//
//
//
//}
