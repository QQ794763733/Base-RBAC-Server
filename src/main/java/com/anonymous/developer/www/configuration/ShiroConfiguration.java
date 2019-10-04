package com.anonymous.developer.www.configuration;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @author: 肖宇
* @QQ: 794763733
* @WeChat: Anonymous-developer
* @Description: Shiro配置类
*/
@Configuration
public class ShiroConfiguration {
    /**
     * 注册自定义Realm
     * @return
     */
    @Bean
    public Realm createRealm(){
        return new CustomRealm();
    }

    /**
     * 注册URL过滤器
     * @return
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/**","anon");
        /*chainDefinition.addPathDefinition("/login","anon");
        chainDefinition.addPathDefinition("/logout","logout");
        Map<String,String> filters = new HashMap<>();
        filters.put("/Api/**","authc");
        filters.put("/account/**","authc");
        filters.put("/role/**","authc");
        filters.put("permission/**","authc");
        chainDefinition.addPathDefinitions(filters);*/
        return chainDefinition;
    }

    /**
     * 解决Spring Aop和注解配置一起使用的Bug
     * @return
     */
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        /**
         * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
         * 在@Controller注解的类的方法中加入@RequiresRole等shiro注解，会导致该方法无法映射请求，导致返回404。
         * 加入这项配置能解决这个bug
         */
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * 注册内存缓存管理
     * @return
     */
    @Bean
    protected CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }
}