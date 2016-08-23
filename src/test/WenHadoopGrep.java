package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LiuFangGuo on 6/27/16.
 */
public class WenHadoopGrep {
    public static void main(String[] args) {
        String input = "00000fdc-4035-4259-9b7f-7c78fb249edc|\\N|a21c76fe-7841-436e-bab5-003a5e80676d|\\N|\\N|\\N|active|\\N|ShLYCX00_DM_YDG|0e319f08-caeb-48de-81cd-09d0a73d4ec9|e7a4fe22-255d-4598-96ae-8a6b6fe61bce|com.zrlh.llkc|2015040101|19.0|Linux version 3.10.28-svn1496 (compiler@compiler029) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Fri Nov 28 18:09:31 CST 2014|\\N|\\N|\\N|\\N|\\N|2015-05-26 10:35:35|2015-05-26 10:35:37";
//        String input = "message:2016-06-05 00:00:00  [ http-bio-8080-exec-5612:8931895248 ] - [ INFO ]  requestId:6645a090-34de-452e-a90c-e3b77450dc62:{\"_id\":\"41ca7915-c2b1-41e5-a787-adcd395bd2c2\",\"eventId\":\"do_inject\",\"reasons\":{\"inject_result\":\"true\"},\"timeStamp\":1465018209294,\"phoneTime\":\"2016-06-04 13:30:09\",\"phoneBrand\":\"samsung\",\"e\":\"352736061626332\",\"tag\":\"CsADB012_DU_DM_YDG\",\"dm_v\":\"1002_4.00.20160108.1715_0\",\"aid\":\"13ee1fc8-3d56-4c8e-8b0c-fb58e13f2ba3\",\"phoneModel\":\"SM-G3812\",\"version\":\"9.1.20160108.1715.0\",\"androidSdk\":\"17\",\"sub_tag\":\"20160108\",\"phonePlatform\":\"OTHER\",\"androidOs\":\"4.2.2\",\"uuid\":\"600000001\",\"dm_ph\":\"/system/bin/npsobex\",\"createTime\":\"2016-06-05 00:00:00\"}\thostname:NY-JAVA-12-101";
        String pattern = "2015-0[1-5]";
//        String pattern = "\"eventId\":\"(.*?)\"";
        Pattern pattern1 = Pattern.compile(pattern);
        String[] split = input.split("[|]");
//        String[] split = input.split("\\|");


        Matcher matcher = pattern1.matcher(split[split.length - 1]);
        while (matcher.find()) {
            System.out.println(matcher.group());

        }

    }
}
