package com.ekwateur.test.domains.customer.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ParticuliarCustomerDTO extends CustomerDTO {
    private String civility;
    private String firstName;
    private String lastName;

    public ParticuliarCustomerDTO(String refClient, Timestamp created, Timestamp updated) {
        super.refClient = refClient;
        super.created = created;
        super.updated = updated;
    }


    public static final class Builder {
        private String refClient;
        private Timestamp created;
        private Timestamp updated;
        private String civility;
        private String firstName;
        private String lastName;

        private Builder() {
        }

        public static Builder aParticuliarCustomerDTO() {
            return new Builder();
        }

        public Builder refClient(String refClient) {
            this.refClient = refClient;
            return this;
        }

        public Builder created(Timestamp created) {
            this.created = created;
            return this;
        }

        public Builder updated(Timestamp updated) {
            this.updated = updated;
            return this;
        }

        public Builder civility(String civility) {
            this.civility = civility;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ParticuliarCustomerDTO build() {
            ParticuliarCustomerDTO particuliarCustomerDTO = new ParticuliarCustomerDTO(refClient, created, updated);
            particuliarCustomerDTO.firstName = this.firstName;
            particuliarCustomerDTO.lastName = this.lastName;
            particuliarCustomerDTO.civility = this.civility;
            return particuliarCustomerDTO;
        }
    }
}
