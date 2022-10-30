/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook;

import io.naraway.drama.prologue.spacekeeper.config.DramaApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.SpringApplication;

@DramaApplication
@SpringBootApplication(scanBasePackages = { "io.naraway.addressbook" }, exclude = DataSourceAutoConfiguration.class)
@EnableMongoRepositories(basePackages = { "io.naraway.addressbook" })
public class AddressBookBootApplication {
    /* Gen by NARA Studio */

    public static void main(String[] args) {
        /* Gen by NARA Studio */
        SpringApplication.run(AddressBookBootApplication.class, args);
    }
}
