package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.GroupDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping("v1/groups")
@RestController
@CrossOrigin("*")
public class GroupController {

    @GetMapping("getGroups")
    public ResponseEntity<List<GroupDto>>getGroups(){
        return ResponseEntity.ok(Collections.emptyList());
    }
    @GetMapping("{groupId}")
    public ResponseEntity<GroupDto> getGroupById(@PathVariable Long groupId) {
        return ResponseEntity.ok(null);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>createGroup(@RequestBody GroupDto groupDto){
        return ResponseEntity.ok().build();
    }
    @PutMapping("updateGroup")
    public ResponseEntity<GroupDto>groupUpdate(@RequestBody GroupDto groupDto){
        return ResponseEntity.ok(null);

    }


}
