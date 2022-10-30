/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.aggregate.address.domain.event;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.naraway.accent.domain.trail.DataEvent;
import io.naraway.addressbook.aggregate.address.domain.entity.AddressBook;
import io.naraway.accent.domain.type.NameValueList;
import io.naraway.accent.domain.trail.DataEventType;
import io.naraway.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class AddressBookEvent extends DataEvent {
    /* Gen by NARA Studio */
    private AddressBook addressBook;
    private String addressBookId;
    private NameValueList nameValues;

    protected AddressBookEvent(DataEventType type) {
        /* Gen by NARA Studio */
        super(type);
    }

    public static AddressBookEvent newAddressBookRegisteredEvent(AddressBook addressBook, String addressBookId) {
        /* Gen by NARA Studio */
        AddressBookEvent event = new AddressBookEvent(DataEventType.Registered);
        event.setAddressBook(addressBook);
        event.setAddressBookId(addressBookId);
        return event;
    }

    public static AddressBookEvent newAddressBookModifiedEvent(String addressBookId, NameValueList nameValues, AddressBook addressBook) {
        /* Gen by NARA Studio */
        AddressBookEvent event = new AddressBookEvent(DataEventType.Modified);
        event.setAddressBookId(addressBookId);
        event.setNameValues(nameValues);
        event.setAddressBook(addressBook);
        return event;
    }

    public static AddressBookEvent newAddressBookRemovedEvent(AddressBook addressBook, String addressBookId) {
        /* Gen by NARA Studio */
        AddressBookEvent event = new AddressBookEvent(DataEventType.Removed);
        event.setAddressBook(addressBook);
        event.setAddressBookId(addressBookId);
        return event;
    }

    public String toString() {
        /* Gen by NARA Studio */
        return toJson();
    }

    public static AddressBookEvent fromJson(String json) {
        /* Gen by NARA Studio */
        return JsonUtil.fromJson(json, AddressBookEvent.class);
    }
}
