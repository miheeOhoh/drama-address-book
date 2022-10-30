/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.aggregate.address.store;

import io.naraway.addressbook.aggregate.address.domain.entity.AddressPage;
import java.util.List;

public interface AddressPageStore {
    /* Gen by NARA Studio */
    void create(AddressPage addressPage);
    void createAll(List<AddressPage> addressPages);
    AddressPage retrieve(String id);
    void update(AddressPage addressPage);
    void delete(AddressPage addressPage);
    void delete(String id);
    void deleteAll(List<String> ids);
    boolean exists(String id);

    List<AddressPage> retrieveByAddressBookId(String addressBookId);
    List<AddressPage> retrieveByAddressBookIdAndBookAddress(String addressBookId, boolean baseAddress);
    void deleteAllByBookAddressBookId(String addressBookId);
}
