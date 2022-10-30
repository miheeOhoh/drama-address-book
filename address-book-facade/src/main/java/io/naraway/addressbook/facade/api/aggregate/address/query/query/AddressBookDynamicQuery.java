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
import io.naraway.accent.domain.trail.DynamicQueryRequest;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressBook;
import io.naraway.accent.util.query.DocQueryRequest;
import io.naraway.addressbook.aggregate.address.store.mongo.odm.AddressBookDoc;
import io.naraway.accent.util.query.DocQueryBuilder;
import org.springframework.data.mongodb.core.query.Query;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(AddressBookDramaRole.Director)
public class AddressBookDynamicQuery extends DynamicQueryRequest<AddressBook> {
    /* Gen by NARA Studio */

    public void execute(DocQueryRequest<AddressBookDoc> request) {
        /* Gen by NARA Studio */
        request.addQueryParamsAndClass(getQueryParams(), AddressBookDoc.class);
        Query query = DocQueryBuilder.build(request);
        AddressBookDoc addressBookDoc = request.findOne(query);
        setResponse(Optional.ofNullable(addressBookDoc).map(doc -> doc.toDomain()).orElse(null));
    }
}
