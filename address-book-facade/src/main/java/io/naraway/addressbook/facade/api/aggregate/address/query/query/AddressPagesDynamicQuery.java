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
import java.util.List;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressPage;
import io.naraway.accent.util.query.DocQueryRequest;
import io.naraway.addressbook.aggregate.address.store.mongo.odm.AddressPageDoc;
import io.naraway.accent.util.query.DocQueryBuilder;
import org.springframework.data.mongodb.core.query.Query;
import java.util.Optional;
import java.util.ArrayList;
import io.naraway.accent.domain.type.Offset;
import static java.util.Objects.nonNull;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(AddressBookDramaRole.Director)
public class AddressPagesDynamicQuery extends DynamicQueryRequest<List<AddressPage>> {
    /* Gen by NARA Studio */

    public void execute(DocQueryRequest<AddressPageDoc> request) {
        /* Gen by NARA Studio */
        request.addQueryParamsAndClass(getQueryParams(), AddressPageDoc.class);
        Query query = DocQueryBuilder.build(request, getOffset());
        List<AddressPageDoc> addressPageDocs = request.findAll(query);
        setResponse(Optional.ofNullable(addressPageDocs).map(docs -> AddressPageDoc.toDomains(docs)).orElse(new ArrayList<>()));
        if (nonNull(getOffset()) && getOffset().isTotalCountRequested()) {
            Query totalCountQuery = DocQueryBuilder.build(request);
            long totalCount = request.count(totalCountQuery);
            Offset countableOffset = getOffset();
            countableOffset.setTotalCount((int) totalCount);
        }
    }
}
