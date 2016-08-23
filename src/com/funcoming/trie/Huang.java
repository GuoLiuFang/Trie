package com.funcoming.trie;

/**
 * Created by LiuFangGuo on 201608/22/.
 */
public class Huang {
    public static String findRrisEnd(String line) {
        int stack = 1;
        int endPos = line.length();
        int beginPos = line.indexOf("rris");
        int stackBegin = line.indexOf('{', beginPos);
        String target = line.substring(stackBegin+1);
        System.out.println(target);
        char[] chars = target.toCharArray();
        int i = 0;
        for (; i < target.length(); i++) {
            if (chars[i] == '{') {
                stack++;
            }
            if (chars[i] == '}') {
                stack--;
            }
            if (stack == 0) {
                break;
            }
        }
        String substring = line.substring(beginPos, stackBegin + i + 2);
        System.out.println(substring);
        return substring;
//        return stackBegin + 2 + i;
    }

    public static void main(String[] args) {
        System.out.println(findRrisEnd("_011, iso=false, sc=\"+8613800311500\",145, rris={\"rri\"=>[{\"a_cc\"=>0, \"a_csc\"=>0, \"a_hbc\"=>14, \"a_st\"=>\"2016-08-11 19:44:32\"}, {\"a_cc\"=>7, \"a_csc\"=>4, \"a_hbc\"=>6302, \"a_st\"=>\"2016-08-11 19:54:07\"}, {\"a_cc\"=>17, \"a_csc\"=>13, \"a_hbc\"=>10859, \"a_st\"=>\"2016-08-14 11:25:15\"}], \"a_lust\"=>\"2016-08-18 17:55:21\", \"a_lupt\"=>\"2016-08-18 17:55:20\"}, ms=20160808, wifi=false, mac=ac:cf:85:49:08:54, vl=9.2.20160808.1757.0, ctime=2016-08-18 23:55:22, m=SzZYMY01_DU2_DM_YDG, androidSdk=22, ppf=QUALCOMM, jib=[], phoneBrand=Huawei, d=460002390876402, sysa=1, phoneModel=SCL-AL00, scpp={\"30f5266f\"=>\"true\", \"6e028dcc\"=>\"false\", \"ad7658a9\"=>\"false\", \"23f66dcb\"=>\"false\"}, ijd=true, aid=e6b6db80-52a1-465f-a497-a95f19850cc8, mds=true,    \thostname:NY-APP-12-10"));
    }
}

