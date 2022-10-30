/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.facade.api.aggregate.address.query.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.naraway.addressbook.aggregate.address.store.AddressBookStore;
import org.springframework.data.mongodb.core.MongoTemplate;
import io.naraway.accent.domain.trail.QueryResponse;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressBook;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressBookQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressBookDynamicQuery;
import io.naraway.accent.util.query.DocQueryRequest;
import io.naraway.addressbook.aggregate.address.store.mongo.odm.AddressBookDoc;
import java.util.List;
import io.naraway.addressbook.facade.api.aggregate.address.query.query.AddressBooksDynamicQuery;

@RestController
@RequestMapping("/aggregate/address")
public class AddressBookQueryResource implements AddressBookQueryFacade {
    /* Gen by NARA Studio */
    private final AddressBookStore addressBookStore;
    private final MongoTemplate mongoTemplate;

    public AddressBookQueryResource(AddressBookStore addressBookStore, MongoTemplate mongoTemplate) {
        /* Gen by NARA Studio */
        this.addressBookStore = addressBookStore;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @PostMapping("/address-book/query")
    public QueryResponse<AddressBook> execute(@RequestBody AddressBookQuery addressBookQuery) {
        /* Gen by NARA Studio */
        addressBookQuery.execute(addressBookStore);
        return addressBookQuery.getResponse();
    }

    @Override
    @PostMapping("/address-book/dynamic-single/query")
    public QueryResponse<AddressBook> execute(@RequestBody AddressBookDynamicQuery addressBookDynamicQuery) {
        /* Gen by NARA Studio */
        DocQueryRequest<AddressBookDoc> request = new DocQueryRequest<>(mongoTemplate);
        addressBookDynamicQuery.execute(request);
        return addressBookDynamicQuery.getResponse();
    }

    @Override
    @PostMapping("/address-book/dynamic-multi/query")
    public QueryResponse<List<AddressBook>> execute(@RequestBody AddressBooksDynamicQuery addressBooksDynamicQuery) {
        /* Gen by NARA Studio */
        DocQueryRequest<AddressBookDoc> request = new DocQueryRequest<>(mongoTemplate);
        addressBooksDynamicQuery.execute(request);
        return addressBooksDynamicQuery.getResponse();
    }
}
