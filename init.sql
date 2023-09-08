CREATE SCHEMA IF NOT EXISTS seq_database;

CREATE TABLE seq_database.generated_sequence
(
    gen_sequence_id SERIAL PRIMARY KEY,
    sequence        TEXT,
    properties      TEXT[]
);

CREATE TABLE seq_database.prep_sequence
(
    id       SERIAL PRIMARY KEY,
    header   TEXT,
    sequence TEXT
);

INSERT INTO seq_database.generated_sequence (sequence, properties)
VALUES ('seq1', ARRAY ['property1', 'property2', 'property3']),
       ('seq2', ARRAY ['property1', 'property4']),
       ('seq3', ARRAY ['property5', 'property6']);

INSERT INTO seq_database.prep_sequence (header, sequence)
VALUES ('header1', 'sequence1'),
       ('header2', 'sequence2'),
       ('header3', 'sequence3');