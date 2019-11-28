package com.ustglobal.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.ustglobal.springcore.di")
public class ComponentScanConfiguration {

}
