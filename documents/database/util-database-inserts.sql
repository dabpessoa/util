
-- DOMÍNIOS
insert into util.dominio(id, fk_modulo, label) values (default, (select m.id from controle_acesso.modulo m where m.label = 'vaicomecar'), 'apresentacao_tipo');

-- ITENS DE DOMÍNIO
insert into util.item_dominio(id, fk_dominio, label) values (default, (select d.id from util.dominio d where d.label = 'apresentacao_tipo'), 'AT_FILME');
insert into util.item_dominio(id, fk_dominio, label) values (default, (select d.id from util.dominio d where d.label = 'apresentacao_tipo'), 'AT_SHOW');
insert into util.item_dominio(id, fk_dominio, label) values (default, (select d.id from util.dominio d where d.label = 'apresentacao_tipo'), 'AT_TEATRO');
insert into util.item_dominio(id, fk_dominio, label) values (default, (select d.id from util.dominio d where d.label = 'apresentacao_tipo'), 'AT_LUTA');
insert into util.item_dominio(id, fk_dominio, label) values (default, (select d.id from util.dominio d where d.label = 'apresentacao_tipo'), 'AT_OUTROS');