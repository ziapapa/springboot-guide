package com.spring.guide.domain.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AddressTest {

    @Test
    public void address() {
        final Address address = Address.builder()
                .county("county")
                .city("city")
                .state("state")
                .zipCode("zipCode")
                .build();

        assertThat(address.getCounty(), is("county"));
        assertThat(address.getCity(), is("city"));
        assertThat(address.getState(), is("state"));
        assertThat(address.getZipCode(), is("zipCode"));
        assertThat(address.getFullAddress(), is("state city zipCode"));
    }

}