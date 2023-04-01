package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDTO;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public List<GroupDTO> showGroups() {
        List<Group> allGroups = groupRepository.findAll();
        return groupMapper.mapToGroupDTOList(allGroups);
    }

    public GroupDTO showGroup(Long groupId) throws GroupNotFoundException {
        if (groupRepository.existsById(groupId)) {
            return groupMapper.mapToGroupDTO(groupRepository.findById(groupId).get());
        } else {
            System.out.println("Group with  Id " + groupId + " not found");
            throw new GroupNotFoundException();
        }
    }

    public void saveGroup(GroupDTO groupDTO) {
        Group group = groupMapper.mapToGroup(groupDTO);
        groupRepository.save(group);
    }
    public GroupDTO updateGroup(GroupDTO groupDTO) {
        Group group = groupMapper.mapToGroup(groupDTO);
        Group updatedGroup = groupRepository.save(group);
        return groupMapper.mapToGroupDTO(updatedGroup);
    }
}
