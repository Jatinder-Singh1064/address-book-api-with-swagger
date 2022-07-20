package com.jatinder.springboot.swagger2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
@Api(description = "Set of endpoints for Creating, and Retrieving of Address Book Contacts.", value = "Address Book Resource")
public class AddressBookResource {

    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Contact by Id",
                    notes="Provide an id to look up specific contact from the address book",
                    response = Contact.class)
    public Contact getContact(@ApiParam(value="ID value for the contact you need to retrieve", required = true)
                            @PathVariable String id) {
            return contacts.get(id);
    }

    @GetMapping("/")
    @ApiOperation(value = "Get All Contacts",
                    notes="Get all the contacts from the address book")
    public List<Contact> getAllContacts() {
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/")
    @ApiOperation(value = "Insert new Contact",
            notes="Insert the new Contact record into the address book", response = Contact.class)
    public Contact addContact(@RequestBody Contact contact) {
            contacts.put(contact.getId(), contact);
            return contact;
    }
}
