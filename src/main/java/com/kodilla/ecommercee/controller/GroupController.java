package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDTO;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/groups")
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;
    @GetMapping()
    public ResponseEntity<List<GroupDTO>> getGroups() {
        List<Group> groupList = groupService.showGroups();
        return ResponseEntity.ok(groupMapper.mapToGroupDTOList(groupList));
    }

    @GetMapping("{groupId}")
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable long groupId) throws GroupNotFoundException {
        Group foundGroup = groupService.showGroup(groupId);
        return ResponseEntity.ok(groupMapper.mapToGroupDTO(foundGroup));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGroup(@RequestBody GroupDTO groupDTO) {
        Group newGroup = groupMapper.mapToGroup(groupDTO);
        groupService.saveGroup(newGroup);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO groupDTO) {
        Group group = groupMapper.mapToGroup(groupDTO);
        Group updatedGroup = groupService.saveGroup(group);
        return ResponseEntity.ok(groupMapper.mapToGroupDTO(updatedGroup));
    }
}
