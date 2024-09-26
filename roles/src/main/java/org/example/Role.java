package org.example;

import io.smallrye.graphql.api.federation.Extends;
import io.smallrye.graphql.api.federation.FieldSet;
import io.smallrye.graphql.api.federation.Key;

@Key(fields = @FieldSet("id"))
public record Role(Long id, String value) {
}
