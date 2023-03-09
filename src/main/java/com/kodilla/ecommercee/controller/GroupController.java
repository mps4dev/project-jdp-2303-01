package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping("v1/groups")
@RestController
@CrossOrigin("*")
public class GroupController {
    @GetMapping()
    public ResponseEntity<List<GroupDTO>>getGroups(){
        return ResponseEntity.ok(Collections.emptyList());
    }
    @GetMapping("{groupId}")
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable Long groupId) {
        return ResponseEntity.ok(null);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>createGroup(@RequestBody GroupDTO groupDto){
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO>updateGroup(@RequestBody GroupDTO groupDto){
        return ResponseEntity.ok(null);

    }
}
