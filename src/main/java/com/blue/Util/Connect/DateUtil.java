package com.blue.Util.Connect;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author blue
 * @date 2023/4/3 8:53
 **/
public class DateUtil {
    public static Timestamp d2t(Date d){
        if(d==null){
            return null;
        }
        return new Timestamp(d.getTime());
    }
    public static Date t2d(Timestamp t){
        if(t==null){
            return null;
        }
        return new Date(t.getTime());
    }
}
