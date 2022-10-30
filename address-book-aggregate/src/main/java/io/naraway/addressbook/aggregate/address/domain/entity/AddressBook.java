/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.aggregate.address.domain.entity;

import io.naraway.accent.domain.ddd.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.naraway.accent.domain.key.stage.ActorKey;
import io.naraway.addressbook.aggregate.address.domain.entity.sdo.AddressBookCdo;
import io.naraway.accent.domain.type.NameValueList;
import io.naraway.accent.util.json.JsonUtil;
import org.springframework.beans.BeanUtils;
import io.naraway.accent.domain.type.NameValue;

@Getter
@Setter
@NoArgsConstructor
@GenOptions
public class AddressBook extends StageEntity implements DomainAggregate {

    @Updatable
    private String name;
    @Updatable
    private String description;
    //private List<AddressPage>

    public AddressBook(String id, ActorKey requesterKey) {
        super(id, requesterKey);
    }

    public AddressBook(AddressBookCdo addressBookCdo) {
        super(addressBookCdo.genId(), addressBookCdo.getRequesterKey());
        BeanUtils.copyProperties(addressBookCdo, this);
    }

    public static AddressBook newInstance(AddressBookCdo addressBookCdo, NameValueList nameValueList) {
        AddressBook addressBook = new AddressBook(addressBookCdo);
        addressBook.modifyAttributes(nameValueList);
        return addressBook;
    }

    @Override
    public String toString() {
        return toJson();
    }

    public static AddressBook fromJson(String json) {
        return JsonUtil.fromJson(json, AddressBook.class);
    }

    @Override
    protected void modifyAttributes(NameValueList nameValues) {
        for (NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch(nameValue.getName()) {
                case "name":
                    this.name = value;
                    break;
                case "description":
                    this.description = value;
                    break;
                default:
                    throw new IllegalArgumentException("Update not allowed: " + nameValue);
            }
        }
    }

    public static AddressBook sample() {
        return new AddressBook(AddressBookCdo.sample());
    }

    public static void main(String[] args) {
        System.out.println(sample().toPrettyJson());
    }
}
