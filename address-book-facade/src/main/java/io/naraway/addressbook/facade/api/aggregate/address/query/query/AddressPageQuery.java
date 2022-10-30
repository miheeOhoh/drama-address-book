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
import io.naraway.addressbook.aggregate.address.domain.entity.AddressPage;
import io.naraway.addressbook.aggregate.address.store.AddressPageStore;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(AddressBookDramaRole.Director)
public class AddressPageQuery extends QueryRequest<AddressPage> {
    /* Gen by NARA Studio */
    private String addressPageId;

    public void execute(AddressPageStore addressPageStore) {
        /* Gen by NARA Studio */
        setResponse(addressPageStore.retrieve(addressPageId));
    }
}
