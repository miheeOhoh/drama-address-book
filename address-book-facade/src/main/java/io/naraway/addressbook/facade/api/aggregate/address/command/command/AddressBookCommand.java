/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.facade.api.aggregate.address.command.command;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.naraway.accent.domain.ddd.AuthorizedRole;
import io.naraway.addressbook.aggregate.AddressBookDramaRole;
import io.naraway.accent.domain.trail.CommandRequest;
import io.naraway.addressbook.aggregate.address.domain.entity.sdo.AddressBookCdo;
import java.util.List;
import io.naraway.accent.domain.type.NameValueList;
import io.naraway.accent.domain.trail.CommandType;
import io.naraway.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(AddressBookDramaRole.Director)
public class AddressBookCommand extends CommandRequest {
    /* Gen by NARA Studio */
    private AddressBookCdo addressBookCdo;
    private List<AddressBookCdo> addressBookCdos;
    private boolean multiCdo;
    private String addressBookId;
    private NameValueList nameValues;

    protected AddressBookCommand(CommandType type) {
        /* Gen by NARA Studio */
        super(type);
    }

    public static AddressBookCommand newRegisterAddressBookCommand(AddressBookCdo addressBookCdo) {
        /* Gen by NARA Studio */
        AddressBookCommand command = new AddressBookCommand(CommandType.Register);
        command.setAddressBookCdo(addressBookCdo);
        return command;
    }

    public static AddressBookCommand newRegisterAddressBookCommand(List<AddressBookCdo> addressBookCdos) {
        /* Gen by NARA Studio */
        AddressBookCommand command = new AddressBookCommand(CommandType.Register);
        command.setAddressBookCdos(addressBookCdos);
        command.setMultiCdo(true);
        return command;
    }

    public static AddressBookCommand newModifyAddressBookCommand(String addressBookId, NameValueList nameValues) {
        /* Gen by NARA Studio */
        AddressBookCommand command = new AddressBookCommand(CommandType.Modify);
        command.setAddressBookId(addressBookId);
        command.setNameValues(nameValues);
        return command;
    }

    public static AddressBookCommand newRemoveAddressBookCommand(String addressBookId) {
        /* Gen by NARA Studio */
        AddressBookCommand command = new AddressBookCommand(CommandType.Remove);
        command.setAddressBookId(addressBookId);
        return command;
    }

    public String toString() {
        /* Gen by NARA Studio */
        return toJson();
    }

    public static AddressBookCommand fromJson(String json) {
        /* Gen by NARA Studio */
        return JsonUtil.fromJson(json, AddressBookCommand.class);
    }

    public static AddressBookCommand sampleForRegister() {
        /* Gen by NARA Studio */
        return newRegisterAddressBookCommand(AddressBookCdo.sample());
    }

    public static void main(String[] args) {
        /* Gen by NARA Studio */
        System.out.println(sampleForRegister());
    }
}
