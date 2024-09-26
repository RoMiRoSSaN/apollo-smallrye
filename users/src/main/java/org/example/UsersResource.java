package org.example;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import java.util.List;
import java.util.stream.LongStream;

@GraphQLApi
public class UsersResource {
    @Query
    public User me() {
        return new User(1L, "User - 1");
    }

    @Query
    public User userById(@NonNull Long id) {
        return new User(id, "User - " + id);
    }

    public List<Role> roles(@Source User user) {
        return LongStream.range(1, 3)
                .boxed()
                .map(Role::new)
                .toList();
    }
}
