package com.libraryManagementProject.libraryManageSB.service;


import com.libraryManagementProject.libraryManageSB.entity.Publisher;
import com.libraryManagementProject.libraryManageSB.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository  publisherRepository;
    // get all publisher...
    public List<Publisher> findAllPublisher(){
        return publisherRepository.findAll();
    }

    // find single publisher...

    public Publisher findById(Long id){
        Publisher publisher;
        // findById need this exception handling.
        publisher=publisherRepository.findById(id).orElseThrow(()->new RuntimeException("publisher not found"));
        return publisher;
    }


    // create the publisher

    public void  createPublisher(Publisher  publisher){
        publisherRepository.save(publisher);
    }

    /// deleted publisher
    public  void deletedPublisher(Long id){
        // first find publisher
        Publisher  publisher=publisherRepository.findById(id).orElseThrow(()->new RuntimeException("publisher not found"));
        publisherRepository.deleteById(publisher.getId());
    }

    /// it is for the update the Publisher.
    public  void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }


}
