/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.aggregate.address.domain.entity.sdo;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.naraway.drama.prologue.domain.ddd.CreationDataObject;
import io.naraway.accent.util.json.JsonUtil;
import io.naraway.drama.prologue.spacekeeper.support.DramaRequestContext;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookCdo extends CreationDataObject {
    private String name;
    private String description;
    private String addressBookId;

    @Override
    public String genId() {
        return super.genId();
    }

    @Override
    public String toString() {
        return toJson();
    }

    public static AddressBookCdo fromJson(String json) {
        return JsonUtil.fromJson(json, AddressBookCdo.class);
    }

    public static AddressBookCdo sample() {
        DramaRequestContext.setSampleContext();
        return new AddressBookCdo();
    }

    public static void main(String[] args) {
        System.out.println(sample().toPrettyJson());
    }
}
