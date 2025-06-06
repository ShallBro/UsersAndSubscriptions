create table if not exists public.subscriptions
(
    name    varchar(256),
    user_id integer
        constraint subscriptions_users_id_fk
            references public.users,
    id      integer generated by default as identity
        constraint subscriptions_pk
            primary key
);

INSERT INTO subscriptions (user_id, name) VALUES
((SELECT id FROM users WHERE name = 'Yorkiy'), 'VK музыка'),
((SELECT id FROM users WHERE name = 'Artem'), 'Youtube Premium'),
((SELECT id FROM users WHERE name = 'Slava'), 'Youtube Premium'),
((SELECT id FROM users WHERE name = 'German'), 'Youtube Premium'),
((SELECT id FROM users WHERE name = 'Artem'), 'Яндекс плюс'),
((SELECT id FROM users WHERE name = 'Slava'), 'Яндекс плюс'),
((SELECT id FROM users WHERE name = 'Artem'), 'Youtube Premium'),
((SELECT id FROM users WHERE name = 'German'), 'Яндекс плюс'),
((SELECT id FROM users WHERE name = 'Slava'), 'VK музыка'),
((SELECT id FROM users WHERE name = 'German'), 'Netflix');
