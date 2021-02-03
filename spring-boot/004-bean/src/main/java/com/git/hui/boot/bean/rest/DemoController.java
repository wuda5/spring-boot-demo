package com.git.hui.boot.bean.rest;

import com.alibaba.fastjson.JSON;
import com.git.hui.boot.autoconfig.AutoBean;
import com.git.hui.boot.autoconfig.AutoConfBean;
import com.git.hui.boot.bean.autoload.factory.FacDemoBean;
import com.git.hui.boot.bean.autoload.simple.AnoDemoBean;
import com.git.hui.boot.bean.autoload.simple.ConfigDemoBean;
import com.git.hui.boot.bean.config.BeanLoadConfig;
import com.git.hui.boot.bean.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wu.test.TestWuAutoConfig;
import wu.test.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by @author yihui in 17:04 18/9/30.
 */
@RestController
public class DemoController {
    /**
     * 构造方法引入方式
     */
    private AnoDemoBean anoDemoBean;
    public DemoController(AnoDemoBean anoDemoBean) {
        this.anoDemoBean = anoDemoBean;
    }

    /**
     * 经典的注解引入方式
     */
    @Autowired
    private ConfigDemoBean configDemoBean;

    /**
     * 通过 FactoryBean 创建bean的使用测试
     */
    private FacDemoBean facDemoBean;

    @Autowired
    private void setFacDemoBean(FacDemoBean facDemoBean) {
        this.facDemoBean = facDemoBean;
    }

    /**
     * 测试引入第三方包的情况
     */
    @Autowired
    private AutoBean autoBean;

    /**
     * 测试引入第三方包的情况
     */
    @Autowired
    private User wuUser;
    /**
     * 测试引入第三方包的情况
     */
    @Autowired
    private TestWuAutoConfig.Car car;

    @Autowired
    private AutoConfBean autoConfBean;

    @GetMapping(path = "/show")
    public String show(String name) {
        Map<String, String> map = new HashMap<>(4);
        map.put("ano", anoDemoBean.getName(name));
        map.put("config", configDemoBean.getName(name));
        map.put("fac", facDemoBean.getName(name));
        map.put("auto", autoBean != null ? autoBean.getName() : "null");
        map.put("autoConf", autoConfBean != null ? autoConfBean.getName() : "null");

        System.out.println("user:"+wuUser +"  ,car: "+car);
        BeanLoadConfig bean = SpringUtils.getBean(BeanLoadConfig.class);
        System.out.println("configBean是否是代理对象？："+bean);
        return JSON.toJSONString(map);
    }
}
