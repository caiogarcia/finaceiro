delete from movimento;
delete from conta_bancaria;
delete from banco;
delete from categoria;


insert into categoria (id_categoria, nome) values
(1, 'Moradia'),
(2, 'Saúde');

insert into banco (id_banco, nome, codigo) values
(1, 'NU Bank', '123'),
(2, 'Inter', '456');

insert into conta_bancaria (id_conta_bancaria, id_banco, agencia, conta, dac) values
(1, 1, '0001', '123456789', '5'),
(2, 2, '0001', '987654321', '7');

insert into movimento (id_movimento, id_conta_bancaria, id_categoria, is_entrada, data, valor, estabelecimento, notas) values
(1, 2, 2, false, CURDATE(), 50.57, 'Drogaria do Zé', 'Suplemento vitamínico');