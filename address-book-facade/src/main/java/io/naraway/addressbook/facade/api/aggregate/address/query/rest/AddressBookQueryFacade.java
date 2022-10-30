/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.facade.api.aggregate.address.query.rest;

import io.naraway.accent.domain.trail.QueryResponse;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressBook;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressBookQuery;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressBookDynamicQuery;
import java.util.List;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressBooksDynamicQuery;

public interface AddressBookQueryFacade {
    /* Gen by NARA Studio */
    QueryResponse<AddressBook> execute(AddressBookQuery addressBookQuery);
    QueryResponse<AddressBook> execute(AddressBookDynamicQuery addressBookDynamicQuery);
    QueryResponse<List<AddressBook>> execute(AddressBooksDynamicQuery addressBooksDynamicQuery);
}
