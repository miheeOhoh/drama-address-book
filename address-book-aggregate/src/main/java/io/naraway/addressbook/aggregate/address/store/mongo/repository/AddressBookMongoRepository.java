/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.aggregate.address.store.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import io.naraway.addressbook.aggregate.address.store.mongo.odm.AddressBookDoc;

public interface AddressBookMongoRepository extends MongoRepository<AddressBookDoc, String> {
    /* Gen by NARA Studio */
}
