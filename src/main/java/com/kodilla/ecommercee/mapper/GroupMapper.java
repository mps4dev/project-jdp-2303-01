package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {
    public Group mapToGroup(GroupDTO groupDTO) {
        return new Group(groupDTO.getName(), groupDTO.getProducts());
    }

    public GroupDTO mapToGroupDTO(Group group) {
        return new GroupDTO(group.getName(), group.getProducts());
    }

    public List<GroupDTO> mapToGroupDTOList(List<Group> groupList) {
        return groupList.stream()
                .map(this::mapToGroupDTO)
                .collect(Collectors.toList());
    }
}
