package com.wickey.config.ehcache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by fatboyliang on 2016/9/3.
 * ehcache缓存配置
 */
@Configuration
@EnableCaching//标记启动缓存
public class EhCacheConfiguration {

    /**
     * ehcache 主要的管理器
     * @param bean
     * @return
     */
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
        System.out.println("CacheConfiguration.ehCacheCacheManager()");
        return new EhCacheCacheManager(bean.getObject());
    }

    /**
       * 据shared是与否的设置,
       * Spring分别通过CacheManager.create()
       * 或new CacheManager()方式来创建一个ehcache基地.
       * 也就是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
       *
       */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        System.out.println("CacheConfiguration.ehCacheManagerFactoryBean()");
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }


}
