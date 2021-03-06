package com.asmith.right.rate.wikipedia.table.parser.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring configuration class
 * Scans for components in specified package(s)
 * @author asmith
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"com.asmith.right.rate.wikipedia"}) // scans all packages under the declared package
public class TestContainerConfig {}
