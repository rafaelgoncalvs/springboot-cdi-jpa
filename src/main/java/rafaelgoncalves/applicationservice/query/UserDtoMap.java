package rafaelgoncalves.applicationservice.query;

import rafaelgoncalves.domain.User;

public class UserDtoMap {

    public static UserDto map(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.id());
        userDto.setName(user.name());
        return userDto;
    }
}
