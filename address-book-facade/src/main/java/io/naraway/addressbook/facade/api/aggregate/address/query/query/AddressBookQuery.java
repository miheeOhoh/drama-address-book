/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.facade.api.aggregate.address.query.query;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.naraway.accent.domain.ddd.AuthorizedRole;
import io.naraway.addressbook.aggregate.AddressBookDramaRole;
import io.naraway.accent.domain.trail.QueryRequest;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressBook;
import io.naraway.addressbook.aggregate.address.store.AddressBookStore;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(AddressBookDramaRole.Director)
public class AddressBookQuery extends QueryRequest<AddressBook> {
    /* Gen by NARA Studio */
    private String addressBookId;

    public void execute(AddressBookStore addressBookStore) {
        /* Gen by NARA Studio */
        setResponse(addressBookStore.retrieve(addressBookId));
    }
}
