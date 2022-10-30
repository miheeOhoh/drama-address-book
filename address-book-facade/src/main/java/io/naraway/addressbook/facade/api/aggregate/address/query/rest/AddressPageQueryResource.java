/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.facade.api.aggregate.address.query.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.naraway.addressbook.aggregate.address.store.AddressPageStore;
import org.springframework.data.mongodb.core.MongoTemplate;
import io.naraway.accent.domain.trail.QueryResponse;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressPage;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressPageQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressPageDynamicQuery;
import io.naraway.accent.util.query.DocQueryRequest;
import io.naraway.addressbook.aggregate.address.store.mongo.odm.AddressPageDoc;
import java.util.List;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressPagesDynamicQuery;

@RestController
@RequestMapping("/aggregate/address")
public class AddressPageQueryResource implements AddressPageQueryFacade {
    /* Gen by NARA Studio */
    private final AddressPageStore addressPageStore;
    private final MongoTemplate mongoTemplate;

    public AddressPageQueryResource(AddressPageStore addressPageStore, MongoTemplate mongoTemplate) {
        /* Gen by NARA Studio */
        this.addressPageStore = addressPageStore;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @PostMapping("/address-page/query")
    public QueryResponse<AddressPage> execute(@RequestBody AddressPageQuery addressPageQuery) {
        /* Gen by NARA Studio */
        addressPageQuery.execute(addressPageStore);
        return addressPageQuery.getResponse();
    }

    @Override
    @PostMapping("/address-page/dynamic-single/query")
    public QueryResponse<AddressPage> execute(@RequestBody AddressPageDynamicQuery addressPageDynamicQuery) {
        /* Gen by NARA Studio */
        DocQueryRequest<AddressPageDoc> request = new DocQueryRequest<>(mongoTemplate);
        addressPageDynamicQuery.execute(request);
        return addressPageDynamicQuery.getResponse();
    }

    @Override
    @PostMapping("/address-page/dynamic-multi/query")
    public QueryResponse<List<AddressPage>> execute(@RequestBody AddressPagesDynamicQuery addressPagesDynamicQuery) {
        /* Gen by NARA Studio */
        DocQueryRequest<AddressPageDoc> request = new DocQueryRequest<>(mongoTemplate);
        addressPagesDynamicQuery.execute(request);
        return addressPagesDynamicQuery.getResponse();
    }
}
