/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook.aggregate;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.List;
import io.naraway.accent.domain.key.kollection.DramaRole;
import io.naraway.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

@Getter
@Setter
@NoArgsConstructor
public class AddressBookDramaRole {
    /* Gen by NARA Studio */
    public static final String Director = "director";
    public static final String TeamUser = "teamUser";
    public static final String PersonalUser = "TeamPersonalUser";
    public static final String TeamAdmin = "TeamAdmin";

    private List<DramaRole> roles;

    public static void validate(String json) {
        /* Gen by NARA Studio */
        AddressBookDramaRole role = JsonUtil.fromJson(json, AddressBookDramaRole.class);
        role.validate();
    }

    public void validate() {
        /* Gen by NARA Studio */
        Assert.notNull(this.roles, "'roles' is required");
        if (roles.stream().noneMatch(role -> role.getCode().equals(Director))) {
            throw new IllegalArgumentException("drama role is missed, role = " + Director);
        }
        if (roles.stream().noneMatch(role -> role.getCode().equals(PersonalUser))) {
            throw new IllegalArgumentException("drama role is missed, role = " + PersonalUser);
        }
        if (roles.stream().noneMatch(role -> role.getCode().equals(TeamAdmin))) {
            throw new IllegalArgumentException("drama role is missed, role = " + TeamAdmin);
        }
        if (roles.stream().noneMatch(role -> role.getCode().equals(TeamAdmin))) {
            throw new IllegalArgumentException("drama role is missed, role = " + TeamAdmin);
        }
    }
}
