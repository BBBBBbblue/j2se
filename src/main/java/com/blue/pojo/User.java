package com.blue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author blue
 * @date 2023/3/31 15:33
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String password;
    private String name;

    public String getAnonymousName(){
        if(name==null){
            return null;
        }
        if(name.length()<=1){
            return "*";
        }
        if(name.length()==2){
            return name.substring(0,1)+"*";
        }
        char[] cs = name.toCharArray();
        for (int i = 1 ; i < cs.length-1 ; i++) {
            cs[i]='*';
        }
        return new String(cs);
    }
}
