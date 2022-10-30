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
import io.naraway.addressbook.aggregate.address.domain.entity.sdo.AddressPageCdo;
import java.util.List;
import io.naraway.accent.domain.type.NameValueList;
import io.naraway.accent.domain.trail.CommandType;
import io.naraway.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(AddressBookDramaRole.Director)
public class AddressPageCommand extends CommandRequest {
    /* Gen by NARA Studio */
    private AddressPageCdo addressPageCdo;
    private List<AddressPageCdo> addressPageCdos;
    private boolean multiCdo;
    private String addressPageId;
    private NameValueList nameValues;

    protected AddressPageCommand(CommandType type) {
        /* Gen by NARA Studio */
        super(type);
    }

    public static AddressPageCommand newRegisterAddressPageCommand(AddressPageCdo addressPageCdo) {
        /* Gen by NARA Studio */
        AddressPageCommand command = new AddressPageCommand(CommandType.Register);
        command.setAddressPageCdo(addressPageCdo);
        return command;
    }

    public static AddressPageCommand newRegisterAddressPageCommand(List<AddressPageCdo> addressPageCdos) {
        /* Gen by NARA Studio */
        AddressPageCommand command = new AddressPageCommand(CommandType.Register);
        command.setAddressPageCdos(addressPageCdos);
        command.setMultiCdo(true);
        return command;
    }

    public static AddressPageCommand newModifyAddressPageCommand(String addressPageId, NameValueList nameValues) {
        /* Gen by NARA Studio */
        AddressPageCommand command = new AddressPageCommand(CommandType.Modify);
        command.setAddressPageId(addressPageId);
        command.setNameValues(nameValues);
        return command;
    }

    public static AddressPageCommand newRemoveAddressPageCommand(String addressPageId) {
        /* Gen by NARA Studio */
        AddressPageCommand command = new AddressPageCommand(CommandType.Remove);
        command.setAddressPageId(addressPageId);
        return command;
    }

    public String toString() {
        /* Gen by NARA Studio */
        return toJson();
    }

    public static AddressPageCommand fromJson(String json) {
        /* Gen by NARA Studio */
        return JsonUtil.fromJson(json, AddressPageCommand.class);
    }

    public static AddressPageCommand sampleForRegister() {
        /* Gen by NARA Studio */
        return newRegisterAddressPageCommand(AddressPageCdo.sample());
    }

    public static void main(String[] args) {
        /* Gen by NARA Studio */
        System.out.println(sampleForRegister());
    }
}
