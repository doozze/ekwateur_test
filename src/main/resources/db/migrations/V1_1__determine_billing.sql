INSERT INTO ekw_billing (energy, customer_type, price, pro_range)
VALUES ('ELECTRICITY', 'PARTICULAR', 0.121, NULL),
       ('GAS', 'PARTICULAR', 0.115, NULL),
       ('ELECTRICITY', 'PRO', 0.118, 'LESS_THAN_ONE'),
       ('GAS', 'PRO', 0.113, 'LESS_THAN_ONE'),
       ('ELECTRICITY', 'PRO', 0.114, 'MORE_THAN_ONE'),
       ('GAS', 'PRO', 0.111, 'MORE_THAN_ONE')
;