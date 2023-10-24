CREATE TABLE IF NOT EXISTS ekw_billing
(
    id            BIGINT NOT NULL AUTO_INCREMENT,
    energy        VARCHAR(32),
    customer_type VARCHAR(32),
    price         DOUBLE PRECISION,
    pro_range     VARCHAR(16),
    created       TIMESTAMP,
    updated       TIMESTAMP,
    CONSTRAINT pk_ekw_billing PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS ekw_consumption_seq START WITH 1;

CREATE TABLE IF NOT EXISTS ekw_consumption
(
    id            BIGINT           NOT NULL DEFAULT NEXTVAL('ekw_consumption_seq'),
    customer_id   VARCHAR(16)      NOT NULL,
    month_of_year VARCHAR(16)      NOT NULL,
    year_of       INT              NOT NULL,
    energy        VARCHAR(32)      NOT NULL,
    kwh           DOUBLE PRECISION NOT NULL,
    created       TIMESTAMP,
    updated       TIMESTAMP,
    CONSTRAINT pk_ekw_consumption PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ekw_part_customer
(
    ref_client VARCHAR(16)  NOT NULL,
    created    TIMESTAMP,
    updated    TIMESTAMP,
    civility   VARCHAR(16)  NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_ekw_part_customer PRIMARY KEY (ref_client)
);
CREATE TABLE ekw_pro_customer
(
    ref_client     VARCHAR(16) NOT NULL,
    created        TIMESTAMP,
    updated        TIMESTAMP,
    siret_number   VARCHAR(16),
    raison_sociale VARCHAR(255),
    turnover       BIGINT,
    CONSTRAINT pk_ekw_pro_customer PRIMARY KEY (ref_client)
);