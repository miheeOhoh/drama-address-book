/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.facade.api.aggregate.address.command.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.naraway.addressbook.aggregate.address.domain.logic.AddressBookLogic;
import io.naraway.accent.domain.trail.CommandResponse;
import io.naraway.addressbook.facade.api.aggregate.address.command.command.AddressBookCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.naraway.accent.domain.trail.FailureMessage;
import java.util.List;
import io.naraway.addressbook.aggregate.address.domain.logic.AddressPageLogic;
import io.naraway.addressbook.facade.api.aggregate.address.command.command.AddressPageCommand;

@RestController
@RequestMapping("/aggregate/address")
public class AddressResource implements AddressFacade {
    private final AddressBookLogic addressBookLogic; // Gen by NARA Studio
    private final AddressPageLogic addressPageLogic;

    public AddressResource(AddressBookLogic addressBookLogic, AddressPageLogic addressPageLogic) {
        /* Gen by NARA Studio */
        this.addressBookLogic = addressBookLogic;
        this.addressPageLogic = addressPageLogic;
    }

    @Override
    @PostMapping("/address-book/command")
    public CommandResponse executeAddressBook(@RequestBody AddressBookCommand addressBookCommand) {
        return /* Gen by NARA Studio */
        routeCommand(addressBookCommand).getResponse();
    }

    private AddressBookCommand routeCommand(AddressBookCommand command) {
        switch(/* Gen by NARA Studio */
        command.getCommandType()) {
            case Register:
                if (command.isMultiCdo()) {
                    List<String> entityIds = addressBookLogic.registerAddressBooks(command.getAddressBookCdos());
                    command.setResponse(new CommandResponse(entityIds));
                } else {
                    String entityId = addressBookLogic.registerAddressBook(command.getAddressBookCdo());
                    command.setResponse(new CommandResponse(entityId));
                }
                break;
            case Modify:
                addressBookLogic.modifyAddressBook(command.getAddressBookId(), command.getNameValues());
                command.setResponse(new CommandResponse(command.getAddressBookId()));
                break;
            case Remove:
                addressBookLogic.removeAddressBook(command.getAddressBookId());
                command.setResponse(new CommandResponse(command.getAddressBookId()));
                break;
            default:
                command.setResponse(new FailureMessage(new Throwable("CommandType must be Register, Modify or Remove")));
        }
        return command;
    }

    @Override
    @PostMapping("/address-page/command")
    public CommandResponse executeAddressPage(@RequestBody AddressPageCommand addressPageCommand) {
        /* Gen by NARA Studio */
        return routeCommand(addressPageCommand).getResponse();
    }

    private AddressPageCommand routeCommand(AddressPageCommand command) {
        /* Gen by NARA Studio */
        switch(command.getCommandType()) {
            case Register:
                if (command.isMultiCdo()) {
                    List<String> entityIds = addressPageLogic.registerAddressPages(command.getAddressPageCdos());
                    command.setResponse(new CommandResponse(entityIds));
                } else {
                    String entityId = addressPageLogic.registerAddressPage(command.getAddressPageCdo());
                    command.setResponse(new CommandResponse(entityId));
                }
                break;
            case Modify:
                addressPageLogic.modifyAddressPage(command.getAddressPageId(), command.getNameValues());
                command.setResponse(new CommandResponse(command.getAddressPageId()));
                break;
            case Remove:
                addressPageLogic.removeAddressPage(command.getAddressPageId());
                command.setResponse(new CommandResponse(command.getAddressPageId()));
                break;
            default:
                command.setResponse(new FailureMessage(new Throwable("CommandType must be Register, Modify or Remove")));
        }
        return command;
    }
}
