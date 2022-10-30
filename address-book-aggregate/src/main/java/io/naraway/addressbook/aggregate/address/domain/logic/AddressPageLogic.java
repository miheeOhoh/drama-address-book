/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.aggregate.address.domain.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.naraway.addressbook.aggregate.address.store.AddressPageStore;
import io.naraway.janitor.proxy.EventProxy;
import io.naraway.addressbook.aggregate.address.domain.entity.sdo.AddressPageCdo;
import java.util.NoSuchElementException;
import io.naraway.addressbook.aggregate.address.domain.event.AddressPageEvent;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressBook;
import io.naraway.accent.domain.key.tenant.AudienceKey;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressPage;
import java.util.List;
import java.util.stream.Collectors;
import io.naraway.accent.domain.type.NameValueList;
import io.naraway.accent.util.entity.EntityUtil;

@Service
@Transactional
public class AddressPageLogic {
    private final AddressBookLogic addressBookLogic; // Gen by NARA Studio
    private final AddressPageStore addressPageStore;
    private final EventProxy eventProxy;

    public AddressPageLogic(AddressBookLogic addressBookLogic, AddressPageStore addressPageStore, EventProxy eventProxy) {
        /* Gen by NARA Studio */
        this.addressBookLogic = addressBookLogic;
        this.addressPageStore = addressPageStore;
        this.eventProxy = eventProxy;
    }

    public String registerAddressPage(AddressPageCdo addressPageCdo) {
        /* Gen by NARA Studio */
        AudienceKey audienceKey = new AudienceKey();
        AddressPage addressPage = new AddressPage(addressPageCdo);
        if (addressPageStore.retrieve(addressPage.getId()) != null) {
            throw new IllegalArgumentException("addressPage already exists. " + addressPage.getId());
        }
        addressPageStore.create(addressPage);
        AddressPageEvent addressPageEvent = AddressPageEvent.newAddressPageRegisteredEvent(addressPage, addressPage.getId());
        eventProxy.publishEvent(addressPageEvent);
        return addressPage.getId();
    }

    public String registerAddressPage(AddressPage addressPage) {
        if (/* Gen by NARA Studio */
        addressPageStore.exists(addressPage.getId())) {
            throw new IllegalArgumentException("addressPage already exists. " + addressPage.getId());
        }
        addressPageStore.create(addressPage);
        AddressPageEvent addressPageEvent = AddressPageEvent.newAddressPageRegisteredEvent(addressPage, addressPage.getId());
        eventProxy.publishEvent(addressPageEvent);
        return addressPage.getId();
    }

    public List<String> registerAddressPages(List<AddressPageCdo> addressPageCdos) {
        return /* Gen by NARA Studio */
        addressPageCdos.stream().map(this::registerAddressPage).collect(Collectors.toList());
    }

    public AddressPage findAddressPage(String addressPageId) {
        /* Gen by NARA Studio */
        AddressPage addressPage = addressPageStore.retrieve(addressPageId);
        if (addressPage == null) {
            throw new NoSuchElementException("AddressPage id: " + addressPageId);
        }
        return addressPage;
    }

    public void modifyAddressPage(String addressPageId, NameValueList nameValues) {
        /* Gen by NARA Studio */
        AddressPage addressPage = findAddressPage(addressPageId);
        addressPage.modify(nameValues);
        addressPageStore.update(addressPage);
        AddressPageEvent addressPageEvent = AddressPageEvent.newAddressPageModifiedEvent(addressPageId, nameValues, addressPage);
        eventProxy.publishEvent(addressPageEvent);
    }

    public void modifyAddressPage(AddressPage addressPage) {
        /* Gen by NARA Studio */
        AddressPage oldAddressPage = findAddressPage(addressPage.getId());
        NameValueList nameValues = EntityUtil.genNameValueList(oldAddressPage, addressPage);
        if (nameValues.size() > 0) {
            modifyAddressPage(addressPage.getId(), nameValues);
        }
        AddressPageEvent addressPageEvent = AddressPageEvent.newAddressPageModifiedEvent(addressPage.getId(), nameValues, addressPage);
        eventProxy.publishEvent(addressPageEvent);
    }

    public void removeAddressPage(String addressPageId) {
        /* Gen by NARA Studio */
        AddressPage addressPage = findAddressPage(addressPageId);
        addressPageStore.delete(addressPage);
        AddressPageEvent addressPageEvent = AddressPageEvent.newAddressPageRemovedEvent(addressPage, addressPage.getId());
        eventProxy.publishEvent(addressPageEvent);
    }

    public boolean existsAddressPage(String addressPageId) {
        return /* Gen by NARA Studio */
        addressPageStore.exists(addressPageId);
    }

    public void removeAddressPage(AddressPage addressPage) {
        if (/* Gen by NARA Studio */
        addressPage == null) {
            return;
        }
        removeAddressPage(addressPage.getId());
    }

    public void handleEventForProjection(AddressPageEvent addressPageEvent) {
        switch(/* Gen by NARA Studio */
        addressPageEvent.getDataEventType()) {
            case Registered:
                addressPageStore.create(addressPageEvent.getAddressPage());
                break;
            case Modified:
                AddressPage addressPage = addressPageStore.retrieve(addressPageEvent.getAddressPageId());
                addressPage.modify(addressPageEvent.getNameValues());
                addressPageStore.update(addressPage);
                break;
            case Removed:
                addressPageStore.delete(addressPageEvent.getAddressPageId());
                break;
        }
    }

    public List<AddressPage> findByAddressBookId(String addressBookId) {
        /* Gen by NARA Studio */
        return addressPageStore.retrieveByAddressBookId(addressBookId);
    }

    public List<AddressPage> findByAddressBookIdAndBookAddress(String addressBookId, boolean baseAddress) {
        /* Gen by NARA Studio */
        return addressPageStore.retrieveByAddressBookIdAndBookAddress(addressBookId, baseAddress);
    }

    public void removeAllByBookAddressBookId(String addressBookId) {
        /* Gen by NARA Studio */
        addressPageStore.deleteAllByBookAddressBookId(addressBookId);
    }
}
