create table if not exists public.users
(
    name varchar(256),
    id   integer generated by default as identity
        constraint users_pk
            primary key
);

INSERT INTO users (name) VALUES
('Yorkiy'),('Artem'),('Slava'),('German');
