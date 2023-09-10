package com.suresh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.suresh.implementation", "com.suresh.services", "com.suresh.aspects" })
@EnableAspectJAutoProxy
public class ProjectConfig {

}