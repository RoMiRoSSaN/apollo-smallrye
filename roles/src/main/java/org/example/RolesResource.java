package org.example;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import java.util.List;
import java.util.stream.LongStream;

@GraphQLApi
public class RolesResource {
    @Query
    public List<Role> rolesByIds(@NonNull List<Long> id) {
        return id.stream()
                .map(value -> new Role(value, "Role = " + value))
                .toList();
    }

    public List<List<User>> users(@Source List<Role> roles) {
        return roles.stream()
                .map(value -> LongStream.range(1,4)
                        .boxed()
                        .map(i -> new User(i * value.id()))
                        .toList()
                )
                .toList();
    }
}
