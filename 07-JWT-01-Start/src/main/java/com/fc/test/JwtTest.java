package com.fc.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class JwtTest {
    @Test
    public void encode1(){
        //头部
        HashMap<String, Object> header = new HashMap<>();

        header.put("alg","HS256");
        header.put("typ","JWT");

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,20);

        String token = JWT
                .create()
                .withHeader(header)
                .withClaim("id",1)
                .withClaim("username","易烊千玺")
                .withClaim("info","管理员")
                .withClaim("createTime",new Date())
                .withExpiresAt(instance.getTime())
                //发布者
                .withIssuer("玛卡巴卡")
                //发布时间
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256("123"));

        System.out.println(token);




    }
}
