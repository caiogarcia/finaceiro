delete from transaction;
delete from account;
delete from bank;
delete from category;


insert into category (id_category, name) values
(1, 'Moradia'),
(2, 'Saúde');

insert into bank (id_bank, name, code) values
(1, 'NU Bank', '123'),
(2, 'Inter', '456');

insert into account (id_account, id_bank, branch, account_number, dac) values
(1, 1, '0001', '123456789', '5'),
(2, 2, '0001', '987654321', '7');

insert into transaction (id_transaction, id_account, id_category, is_income, transaction_date, amount, settlement, notes) values
(1, 2, 2, false, CURDATE(), 50.57, 'Drogaria do Zé', 'Suplemento vitamínico');