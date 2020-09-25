/*

 INSERT INTO public.USR (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ACTIVATED) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', true);
 INSERT INTO public.USR (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ACTIVATED) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', true);
 INSERT INTO public.USR (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ACTIVATED) VALUES (3, 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', false);

 INSERT INTO public.AUTHORITY (NAME) VALUES ('ROLE_USER');
 INSERT INTO public.AUTHORITY (NAME) VALUES ('ROLE_ADMIN');

 INSERT INTO public.USR_AUTHORITY (USR_ID, AUTHORITY_NAME) VALUES (1, 'ROLE_USER');
 INSERT INTO public.USR_AUTHORITY (USR_ID, AUTHORITY_NAME) VALUES (1, 'ROLE_ADMIN');
 INSERT INTO public.USR_AUTHORITY (USR_ID, AUTHORITY_NAME) VALUES (2, 'ROLE_USER');
 INSERT INTO public.USR_AUTHORITY (USR_ID, AUTHORITY_NAME) VALUES (3, 'ROLE_USER');

DELETE FROM public.USR_authority
WHERE usr_id = ;

DELETE FROM public.USR
WHERE id = ;
*/