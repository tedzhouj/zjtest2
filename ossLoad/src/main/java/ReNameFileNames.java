import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoujun on 2017/8/15.
 */
public class ReNameFileNames {

    /**
     * face++
     * 批量重命名
     * @param args
     */
    public static void main(String[] args) throws Throwable{

//        String header= "C:\\Users\\zhoujun\\Desktop\\face++\\face";
//        String newPath = "C:\\Users\\zhoujun\\Desktop\\face++\\targets";
//        File f = new File(header);
//
//        String[] names = f.list();
//
//        List<String> nameList = Arrays.asList(names);
//
//        //  nameList.forEach(record-> System.out.println(record));
//
//        nameList.forEach(record->{
//            String path = header+"\\"+record+"\\"+"photo_living.jpeg";
//            File file = new File(path);
//            //System.out.println(file.getName()+" size:"+file.length());
//            file.renameTo(new File(newPath+"\\zfq-his-"+record));
//        });

        String oldPath = "C:\\Users\\zhoujun\\Desktop\\face++\\targets";
        File ff = new File(oldPath);

        List<String> fileList = Arrays.asList(ff.list());

//        fileList.forEach(record->{
//            String path = oldPath+ "\\"+ record ;
//            File file = new File(path);
//            file.renameTo(new File(oldPath+"\\"+record.replace(".jpeg","")));
//            System.out.println(  record+   " ---rename success"                );
//        });
        File outFile = new File("C:\\Users\\zhoujun\\Desktop\\face++\\script.sql");
        PrintStream ps= new PrintStream(new FileOutputStream(outFile));
        fileList.forEach(record->{
           // System.out.println(record.replace("zfq-his-",""));
            //System.out.println("INSERT INTO `cloud_risk`.`t_customer_image_auth` (`id`, `type`, `org_code`, `contract_no`, `contract_name`, `id_no`, `status`, `identity_card_type`, `identity_card_front_key`, `identity_card_reverse_key`, `self_base_key`, `self_portrait_key`, `confidence`, `remark`, `created_by`, `created_at`, `updated_by`, `updated_at`, `fail_remark`) VALUES (uuid(), NULL, '8018000000000498', '"+record.replace("zfq-his-","")+"', '"+record.replace("zfq-his-","")+"', '"+record.replace("zfq-his-","")+"', 'normal', 'ID', '', '', '"+record+"', '"+record+"', '0', 'old zfq data insert', 'sys manual','2017-08-15 00:00:00', NULL, NULL, NULL);");
            ps.println("INSERT INTO `cloud_risk`.`t_customer_image_auth` (`id`, `type`, `org_code`, `contract_no`, `contract_name`, `id_no`, `status`, `identity_card_type`, `identity_card_front_key`, `identity_card_reverse_key`, `self_base_key`, `self_portrait_key`, `confidence`, `remark`, `created_by`, `created_at`, `updated_by`, `updated_at`, `fail_remark`) VALUES (uuid(), NULL, '8018000000000498', '"+record.replace("zfq-his-","")+"', '"+record.replace("zfq-his-","")+"', '"+record.replace("zfq-his-","")+"', 'normal', 'ID', '', '', '"+record+"', '"+record+"', '0', 'old zfq data insert', 'sys manual','2017-08-15 00:00:00', NULL, NULL, NULL);");
        });

    }

}
