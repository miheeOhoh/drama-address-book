/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClients;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@ConditionalOnMissingClass("org.springframework.test.context.junit4.SpringJUnit4ClassRunner")
public class MongoTransactionConfig extends AbstractMongoClientConfiguration {
    /* Gen by NARA Studio */
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private int port;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.password}")
    private String password;
    @Value("${spring.data.mongodb.authentication-database}")
    private String authenticationDatabase;
    @Autowired
    Environment environment;

    @Bean
    @Profile("!default & !local & !test")
    public MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        /* Gen by NARA Studio */
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    public MongoClient mongoClient() {
        /* Gen by NARA Studio */
        MongoCredential credential = MongoCredential.createCredential(username, authenticationDatabase, password.toCharArray());
        MongoClientSettings settings = MongoClientSettings.builder().credential(credential).retryWrites(true).applyToConnectionPoolSettings(builder -> builder.maxConnectionIdleTime(5000, TimeUnit.MILLISECONDS)).applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(host, port)))).build();
        return MongoClients.create(settings);
    }

    @Override
    protected String getDatabaseName() {
        /* Gen by NARA Studio */
        return database;
    }
}
