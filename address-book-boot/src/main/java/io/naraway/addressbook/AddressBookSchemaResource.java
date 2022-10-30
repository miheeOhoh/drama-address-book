/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.naraway.addressbook;

import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import java.io.IOException;
import io.naraway.accent.util.json.JsonUtil;
import io.naraway.addressbook.aggregate.AddressBookDramaRole;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AddressBookSchemaResource {
    /* Gen by NARA Studio */
    private final Map<String, Object> schema;

    public AddressBookSchemaResource(@Value("classpath:drama.json") Resource resourceFile) throws IOException {
        /* Gen by NARA Studio */
        String json = new String(resourceFile.getInputStream().readAllBytes());
        AddressBookDramaRole.validate(json);
        this.schema = JsonUtil.fromJson(json, Map.class);
    }

    @GetMapping("/schema")
    public Map<String, Object> schema() {
        /* Gen by NARA Studio */
        return this.schema;
    }
}
