package com.jatinder.springboot.swagger2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the Address Book contact")
public class Contact {

    @ApiModelProperty(notes = "The unique id of the contact.", example = "foo", required = true, position = 0)
    private String id;
    @ApiModelProperty(notes = "The contact's phone number.", example = "123-123-1234", required = true, position = 2)
    private String phone;
    @ApiModelProperty(notes = "The contact's name.", example = "John Wick", required = true, position = 1)
    private String name;

    public Contact(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
