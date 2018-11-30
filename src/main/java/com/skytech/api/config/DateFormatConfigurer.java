package com.skytech.api.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DateFormatConfigurer implements WebMvcConfigurer {

    /**
     * 自动转换时间格式
     *
     * @param registry date
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
////        super.configureMessageConverters(converters);
//
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteNullStringAsEmpty
//        );
//        //此处是全局处理方式
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
//        supportedMediaTypes.add(MediaType.ALL); // 全部格式
//        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
//        converters.add(fastConverter);
//    }

}
