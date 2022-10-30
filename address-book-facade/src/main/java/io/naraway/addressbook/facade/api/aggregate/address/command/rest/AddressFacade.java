/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.facade.api.aggregate.address.command.rest;

import io.naraway.accent.domain.trail.CommandResponse;
import io.naraway.addressbook.facade.api.aggregate.address.command.command.AddressBookCommand;
import io.naraway.addressbook.facade.api.aggregate.address.command.command.AddressPageCommand;

public interface AddressFacade {
    /*  Gen by NARA Studio  */
    CommandResponse executeAddressBook(AddressBookCommand addressBookCommand);
    CommandResponse executeAddressPage(AddressPageCommand addressPageCommand);
}
