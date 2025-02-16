CREATE TYPE situacao_usuario AS ENUM ('ATIVO', 'INATIVO');
CREATE TYPE situacao_filial AS ENUM ('ATIVO', 'INATIVO');
CREATE TYPE situacao_cliente AS ENUM ('ATIVO', 'INATIVO');

CREATE TABLE fil_filial
(
    id       UUID PRIMARY KEY,
    nome     VARCHAR(100) UNIQUE NOT NULL,
    cidade   VARCHAR(100)        NOT NULL,
    estado   VARCHAR(100)        NOT NULL,
    pais     VARCHAR(100)        NOT NULL,
    situacao situacao_filial     NOT NULL DEFAULT 'INATIVO'
);

CREATE TABLE usu_usuario
(
    id        UUID PRIMARY KEY,
    email     VARCHAR(100) UNIQUE NOT NULL,
    senha     VARCHAR(100)        NOT NULL,
    nome      VARCHAR(100)        NOT NULL,
    telefone  VARCHAR(11)         NOT NULL,
    situacao  situacao_usuario    NOT NULL DEFAULT 'ATIVO',
    id_filial UUID                NOT NULL,
    CONSTRAINT fk_usuario_filial FOREIGN KEY (id_filial) REFERENCES fil_filial (id)
);

CREATE TABLE cli_cliente
(
    id                              UUID PRIMARY KEY,
    nome                            VARCHAR(100),
    data_cadastro                   TIMESTAMP        NOT NULL,
    data_aniversario                TIMESTAMP        NOT NULL,
    situacao                        situacao_cliente NOT NULL DEFAULT 'ATIVO',
    id_usuario_responsavel_cadastro UUID             NOT NULL,
    CONSTRAINT fk_cliente_usuario_cadastro FOREIGN KEY (id_usuario_responsavel_cadastro) REFERENCES usu_usuario (id)
);

CREATE TABLE atd_atendimento
(
    id              UUID PRIMARY KEY,
    dia_atendimento TIMESTAMP NOT NULL,
    id_usuario      UUID      NOT NULL,
    id_cliente      UUID      NOT NULL,
    CONSTRAINT fk_usuario_atendimento FOREIGN KEY (id_usuario) REFERENCES usu_usuario (id),
    CONSTRAINT fk_cliente_atendimento FOREIGN KEY (id_cliente) REFERENCES cli_cliente (id)
)
