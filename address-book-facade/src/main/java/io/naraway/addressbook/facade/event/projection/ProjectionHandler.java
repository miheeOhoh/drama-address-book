/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.facade.event.projection;

import io.naraway.addressbook.aggregate.address.domain.logic.AddressBookLogic;
import io.naraway.accent.domain.trail.wrapper.StreamEvent;
import io.naraway.addressbook.aggregate.address.domain.event.AddressBookEvent;
import io.naraway.addressbook.aggregate.address.domain.event.AddressPageEvent;
import io.naraway.addressbook.aggregate.address.domain.logic.AddressPageLogic;

public class ProjectionHandler {
    private final AddressBookLogic addressBookLogic; // Gen by NARA Studio
    private final AddressPageLogic addressPageLogic;

    public ProjectionHandler(AddressBookLogic addressBookLogic, AddressPageLogic addressPageLogic) {
        /* Gen by NARA Studio */
        this.addressBookLogic = addressBookLogic;
        this.addressPageLogic = addressPageLogic;
    }

    public void handle(StreamEvent event) {
        /* Gen by NARA Studio */
        String classFullName = event.getPayloadClass();
        String payload = event.getPayload();
        String eventName = classFullName.substring(classFullName.lastIndexOf(".") + 1);
        switch(eventName) {
            case "AddressBookEvent":
                AddressBookEvent addressBookEvent = AddressBookEvent.fromJson(payload);
                addressBookLogic.handleEventForProjection(addressBookEvent);
                break;
            case "AddressPageEvent":
                AddressPageEvent addressPageEvent = AddressPageEvent.fromJson(payload);
                addressPageLogic.handleEventForProjection(addressPageEvent);
                break;
        }
    }
}
