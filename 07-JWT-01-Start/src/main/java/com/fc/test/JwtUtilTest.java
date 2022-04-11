package com.fc.test;

import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JwtUtilTest {
    @Test
    public void testCreate(){
        Map<String, Object> claim = new HashMap<>();

        claim.put("id","1");
        claim.put("username","易烊千玺");

        String token = JwtUtil.createToken(claim, System.currentTimeMillis() + 1000 * 20);

        System.out.println(token);
    }
}
