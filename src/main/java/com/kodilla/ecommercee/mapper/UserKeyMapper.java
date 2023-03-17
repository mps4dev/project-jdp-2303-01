package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.UserKey;
import com.kodilla.ecommercee.domain.dto.UserKeyDTO;
import org.springframework.stereotype.Service;

@Service
public class UserKeyMapper {
    public UserKeyDTO mapToUserKeyDTO(final UserKey userKey) {
        return new UserKeyDTO(
                userKey.getValue(),
                userKey.getExpirationTime()
        );
    }

    public UserKey maptoUserKey(final UserKeyDTO userKeyDto) {
        return new UserKey(
                userKeyDto.getValue(),
                userKeyDto.getExpirationTime()
        );
    }
}
