-- drop schema util cascade;
create schema util;

-- DROP TABLE util.dominio;
create sequence util.dominio_id_seq;
create table util.dominio (
   id bigint not null default nextval('util.dominio_id_seq'),
   fk_modulo bigint not null,
   label character varying(60) not null,
   descricao character varying(200),
   constraint pk_dominio primary key (id),
   constraint uk_label_fk_modulo unique(label, fk_modulo)
);
alter sequence util.dominio_id_seq OWNED BY util.dominio.id;

-- drop table util.item_dominio;
create sequence util.item_dominio_id_seq;
create table util.item_dominio (
   id bigint not null default nextval('util.item_dominio_id_seq'),
   fk_dominio bigint not null,
   label character varying(120) not null,
   descricao character varying(300),
   constraint pk_item_dominio primary key (id),
   constraint uk_label_fk_dominio unique(label, fk_dominio)
);
ALTER SEQUENCE util.item_dominio_id_seq OWNED BY util.item_dominio.id;

-- drop table util.pessoa;
create sequence util.pessoa_id_seq;
create table util.pessoa (
  id bigint not null default nextval('util.pessoa_id_seq'),
  id_tipo_pessoa bigint,
  id_estado_civil bigint,
  id_pessoa_origem bigint,
  nome character varying(120) not null,
  nome_social character varying(120),
  email character varying(80),
  dt_nascimento timestamp without time zone,
  dt_cadastro timestamp without time zone,
  constraint pessoa_pk primary key (id)
);
alter sequence util.pessoa_id_seq owned by util.pessoa.id;

ALTER TABLE util.item_dominio ADD CONSTRAINT fk_item_dominio
FOREIGN KEY (fk_dominio)
REFERENCES util.dominio (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE util.dominio ADD CONSTRAINT fk_dominio_modulo
FOREIGN KEY (fk_modulo)
REFERENCES controle_acesso.modulo (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION;
NOT DEFERRABLE;

