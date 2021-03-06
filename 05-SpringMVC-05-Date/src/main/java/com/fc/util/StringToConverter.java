package com.fc.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        //这是SpringMVC所支持的格式
        String pattern = "yyyy/MM/dd";

        //如果请求中的字符串携带了-
        if(source.contains("-")){
            pattern="yyyy-MM-dd";
        }

        //声明一个简单日期格式化器
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        Date parse = null;

        try {
            parse = formatter.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
