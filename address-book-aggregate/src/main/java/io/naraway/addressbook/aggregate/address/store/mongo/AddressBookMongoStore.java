/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.aggregate.address.store.mongo;

import org.springframework.stereotype.Repository;
import io.naraway.addressbook.aggregate.address.store.AddressBookStore;
import io.naraway.addressbook.aggregate.address.store.mongo.repository.AddressBookMongoRepository;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressBook;
import io.naraway.addressbook.aggregate.address.store.mongo.odm.AddressBookDoc;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import io.naraway.accent.domain.type.Offset;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Repository
public class AddressBookMongoStore implements AddressBookStore {
    /* Gen by NARA Studio */
    private final AddressBookMongoRepository addressBookMongoRepository;

    public AddressBookMongoStore(AddressBookMongoRepository addressBookMongoRepository) {
        /* Gen by NARA Studio */
        this.addressBookMongoRepository = addressBookMongoRepository;
    }

    @Override
    public void create(AddressBook addressBook) {
        /* Gen by NARA Studio */
        AddressBookDoc addressBookDoc = new AddressBookDoc(addressBook);
        addressBookMongoRepository.save(addressBookDoc);
    }

    @Override
    public void createAll(List<AddressBook> addressBooks) {
        /* Gen by NARA Studio */
        if (addressBooks == null) {
            return;
        }
        addressBooks.forEach(this::create);
    }

    @Override
    public AddressBook retrieve(String id) {
        /* Gen by NARA Studio */
        Optional<AddressBookDoc> addressBookDoc = addressBookMongoRepository.findById(id);
        return addressBookDoc.map(AddressBookDoc::toDomain).orElse(null);
    }

    @Override
    public void update(AddressBook addressBook) {
        /* Gen by NARA Studio */
        AddressBookDoc addressBookDoc = new AddressBookDoc(addressBook);
        addressBookMongoRepository.save(addressBookDoc);
    }

    @Override
    public void delete(AddressBook addressBook) {
        /* Gen by NARA Studio */
        addressBookMongoRepository.deleteById(addressBook.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by NARA Studio */
        addressBookMongoRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        /* Gen by NARA Studio */
        if (ids == null) {
            return;
        }
        ids.forEach(this::delete);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by NARA Studio */
        return addressBookMongoRepository.existsById(id);
    }

    private Pageable createPageable(Offset offset) {
        /* Gen by NARA Studio */
        if (offset.getSortDirection() != null && offset.getSortingField() != null) {
            return PageRequest.of(offset.page(), offset.limit(), (offset.ascendingSort() ? Sort.Direction.ASC : Sort.Direction.DESC), offset.getSortingField());
        } else {
            return PageRequest.of(offset.page(), offset.limit());
        }
    }
}
