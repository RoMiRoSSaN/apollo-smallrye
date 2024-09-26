package org.example;

import io.smallrye.graphql.api.federation.Extends;
import io.smallrye.graphql.api.federation.FieldSet;
import io.smallrye.graphql.api.federation.Key;

@Extends
@Key(fields = @FieldSet("id"))
public record User(Long id) {
}
