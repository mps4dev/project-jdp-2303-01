package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GroupTestSuite {

    @Autowired
    private GroupRepository groupRepository;
    private Group group1;
    private Group group2;
    private Product product1;
    private Product product2;
    private void dataForTests(){
         group1 = new Group("group1",new ArrayList<>());
         group2 = new Group("group2",new ArrayList<>());
         product1 = new Product("product1",12.2,5,group1);
         product2 = new Product("product2",122.2,7,group2);
    }

    @Test
    public void testShouldSaveGroup(){

        //Given
        dataForTests();
        //When
        Group savedGroup1 = groupRepository.save(group1);
        Group savedGroup2 = groupRepository.save(group2);

        //Then
        assertThat(savedGroup1.getName()).isEqualTo("group1");
        assertThat(savedGroup2.getName()).isEqualTo("group2");


        //CleanUp
        groupRepository.deleteAll();
    }

    @Test
    public void testUpdateGroups(){

        //Given
        dataForTests();

        //When
        Group saveGroup1 = groupRepository.save(group1);
        saveGroup1.getProducts().add(product1);
        saveGroup1.getProducts().add(product2);
        Group saveGroup2 = groupRepository.save(group2);
        saveGroup2.setName("group2AfterChange");

        //Then
        assertEquals("group1", saveGroup1.getName());
        assertEquals("group2AfterChange", saveGroup2.getName());
        assertEquals(2, saveGroup1.getProducts().size());


        //CleanUp
        groupRepository.deleteAll();
    }

    @Test
    public void testDeleteGroupById(){

        //Given
        dataForTests();

        //When
       groupRepository.save(group1);
       groupRepository.save(group2);
       groupRepository.deleteById(group1.getGroupId());
       Optional<Group> deletedGroup1 = groupRepository.findById(group1.getGroupId());

        //Then
        assertFalse(deletedGroup1.isPresent());
        assertEquals(1,groupRepository.count());

        //CleanUp
        groupRepository.deleteAll();
    }

    @Test
    public void testFindAllGroups(){

        //Given
        dataForTests();

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);

        //Then
        assertEquals(2,groupRepository.count());

        //CleanUp
        groupRepository.deleteAll();
    }

    @Test
    public void testFindGroupById(){
        //Given
        dataForTests();

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        Optional<Group> retriveById = groupRepository.findById(group1.getGroupId());

        //Then
        assertEquals("group1",retriveById.orElse(new Group()).getName());
        assertTrue(retriveById.isPresent());

        //CleanUp
        groupRepository.deleteAll();
    }



}
