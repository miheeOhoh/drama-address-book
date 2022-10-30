/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.aggregate.address.domain.entity.sdo;

import io.naraway.addressbook.aggregate.address.domain.entity.vo.Address;
import io.naraway.addressbook.aggregate.address.domain.entity.vo.Field;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.naraway.drama.prologue.domain.ddd.CreationDataObject;
import io.naraway.accent.util.json.JsonUtil;
import io.naraway.drama.prologue.spacekeeper.support.DramaRequestContext;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressPageCdo extends CreationDataObject {

    private String name;
    private Address address;
    private String phoneNumber;
    private List<Field> fields;
    private String addressBookId;



    @Override
    public String genId() {
        return super.genId();
    }

    @Override
    public String toString() {
        return toJson();
    }

    public static AddressPageCdo fromJson(String json) {
        return JsonUtil.fromJson(json, AddressPageCdo.class);
    }

    public static AddressPageCdo sample() {
        DramaRequestContext.setSampleContext();
        return new AddressPageCdo(
            "Home", Address.sampleKorean(), "+82 010-1234-5678", Arrays.asList(Field.sample()), AddressBookCdo.sample().genId()
        );
    }

    public static void main(String[] args) {
        System.out.println(sample().toPrettyJson());
    }
}
