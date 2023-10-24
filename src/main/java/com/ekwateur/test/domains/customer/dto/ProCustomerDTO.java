package com.ekwateur.test.domains.customer.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ProCustomerDTO extends CustomerDTO {
    private String siretNumber;
    private String raisonSociale;
    private Long turnover;

    public ProCustomerDTO(String refClient, Timestamp created, Timestamp updated) {
        super.refClient = refClient;
        super.created = created;
        super.updated = updated;
    }

    public static final class Builder {
        private String refClient;
        private Timestamp created;
        private Timestamp updated;
        private String siretNumber;
        private String raisonSociale;
        private Long turnover;

        private Builder() {
        }

        public static Builder aProCustomerDTO() {
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

        public Builder siretNumber(String siretNumber) {
            this.siretNumber = siretNumber;
            return this;
        }

        public Builder raisonSociale(String raisonSociale) {
            this.raisonSociale = raisonSociale;
            return this;
        }

        public Builder turnover(Long turnover) {
            this.turnover = turnover;
            return this;
        }

        public ProCustomerDTO build() {
            ProCustomerDTO proCustomerDTO = new ProCustomerDTO(refClient, created, updated);
            proCustomerDTO.turnover = this.turnover;
            proCustomerDTO.raisonSociale = this.raisonSociale;
            proCustomerDTO.siretNumber = this.siretNumber;
            return proCustomerDTO;
        }
    }
}
