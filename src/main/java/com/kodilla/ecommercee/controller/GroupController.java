package com.kodilla.ecommercee.controller;

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

    @GetMapping()
    public ResponseEntity<List<GroupDTO>> getGroups() {
        return ResponseEntity.ok(groupService.showGroups());
    }

    @GetMapping("{groupId}")
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable long groupId) throws GroupNotFoundException {
        return ResponseEntity.ok(groupService.showGroup(groupId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGroup(@RequestBody GroupDTO groupDTO) {
        groupService.saveGroup(groupDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO groupDTO) {
        return ResponseEntity.ok(groupService.updateGroup(groupDTO));
    }
}
