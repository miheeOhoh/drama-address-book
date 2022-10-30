/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.aggregate.address.store.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import io.naraway.addressbook.aggregate.address.store.mongo.odm.AddressPageDoc;
import java.util.List;

public interface AddressPageMongoRepository extends MongoRepository<AddressPageDoc, String> {
    /* Gen by NARA Studio */
    List<AddressPageDoc> findByAddressBookId(String addressBookId);
    List<AddressPageDoc> findByAddressBookIdAndBookAddress(String addressBookId, boolean baseAddress);
    void removeAllByBookAddressBookId(String addressBookId);
}
