package com.fakhruddin.lfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */
@RestController
public class HelloController {
    
    @Autowired
    private RedisTemplate<String,String> template;

    @RequestMapping("/")
    public String index(){
        return "Hello world";
    }


    @RequestMapping("/set/key/{key}/value/{value}")
    public void setConfig(@PathVariable("key") String key,@PathVariable("value") String value){
        template.opsForValue().set(key, value);
    }

    @RequestMapping("/get/key/{key}")
    public String getConfig(@PathVariable("key") String key){
        return template.opsForValue().get(key);
    }
}