/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.facade.api.aggregate.address.query.rest;

import io.naraway.accent.domain.trail.QueryResponse;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressPage;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressPageQuery;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressPageDynamicQuery;
import java.util.List;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressPagesDynamicQuery;

public interface AddressPageQueryFacade {
    /* Gen by NARA Studio */
    QueryResponse<AddressPage> execute(AddressPageQuery addressPageQuery);
    QueryResponse<AddressPage> execute(AddressPageDynamicQuery addressPageDynamicQuery);
    QueryResponse<List<AddressPage>> execute(AddressPagesDynamicQuery addressPagesDynamicQuery);
}
