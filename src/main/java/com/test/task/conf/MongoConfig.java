package com.test.task.conf;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.test.task.db")
public class MongoConfig extends AbstractMongoConfiguration {

    public final String DATABASE = "test";
    public final String HOST = "127.0.0.1";

    @Override
    public String getDatabaseName() {
        return DATABASE;
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(HOST);
    }
}