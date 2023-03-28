package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
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

    public List<Group> showGroups() {
        return groupRepository.findAll();
    }

    public Group showGroup(Long groupId) throws GroupNotFoundException {
        if (groupRepository.existsById(groupId)){
        return groupRepository.findById(groupId).get();
        }else{
            System.out.println("Group with  Id " + groupId+ " not found" );
            throw  new GroupNotFoundException();
        }
    }

    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }
}
