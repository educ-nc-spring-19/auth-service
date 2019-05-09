insert into auth_service.system_role (
       id,
			 created_date,
			 description,
			 name)
			 values
			(
			'04b5de7f-3c74-4724-a326-67d3ef6f6d5f',
			'2019-05-10 02:00:00+03',
			'This role is for lectors, mentors and backups, they are included in 1st part of mentoring engine to choose
			students and after that in 2nd part they teach them and look after their teams',
			'MENTOR'
			);

insert into auth_service.system_role (
       id,
			 created_date,
			 description,
			 name)
			 values
			(
			'1178439b-d6db-4f09-8a94-388804828a1b',
			'2019-05-10 02:00:00+03',
			'This role is for all authorised users with minimum rights',
			'USER'
			);

insert into auth_service.system_role (
       id,
			 created_date,
			 description,
			 name)
			 values
			(
			'534cf600-8b46-4bb7-88b2-c0d12a8af412',
			'2019-05-10 02:00:00+03',
			'This role is for users with maximum rights',
			'ADMIN'
			);

insert into auth_service.users (
       id,
			 created_date,
			 email_address,
			 first_name,
			 last_name,
			 login,
			 password,
			 credential,
			 active
			 )
			 values
			(
			'd9923a76-b735-4904-a1a4-61100ebdd362',
			'2019-05-08 12:32:00+03',
			'example_mail@ya.com',
			'Александр',
			'Пушкин',
			'ALPU0115',
			'123456',
			'я хз, что тут',
			false
			);

insert into auth_service.users (
       id,
			 created_date,
			 email_address,
			 first_name,
			 last_name,
			 login,
			 password,
			 credential,
			 active
			 )
			 values
			(
			'4dbb2b01-8e36-4049-8362-d79c29288a4f',
			'2019-05-08 12:32:00+03',
			'example_mail@ya.com',
			'Сергей',
			'Есенин',
			'SEES0215',
			'123456',
			'я хз, что тут',
			false
			);

insert into auth_service.users (
       id,
			 created_date,
			 email_address,
			 first_name,
			 last_name,
			 login,
			 password,
			 credential,
			 active
			 )
			 values
			(
			'480eaaf2-4083-4eab-a978-4892a950dec5',
			'2019-05-08 12:32:00+03',
			'example_mail@ya.com',
			'Михаил',
			'Лермонтов',
			'MILE0315',
			'123456',
			'я хз, что тут',
			false
			);

insert into auth_service.users (
       id,
			 created_date,
			 email_address,
			 first_name,
			 last_name,
			 login,
			 password,
			 credential,
			 active
			 )
			 values
			(
			'440bb660-8a95-4f59-9a3c-cca5e6c07692',
			'2019-05-08 12:32:00+03',
			'example_mail@ya.com',
			'Анна',
			'Ахматова',
			'ANAH0415',
			'123456',
			'я хз, что тут',
			false
			);

insert into auth_service.users (
       id,
			 created_date,
			 email_address,
			 first_name,
			 last_name,
			 login,
			 password,
			 credential,
			 active
			 )
			 values
			(
			'17327fd7-1c79-4148-9dca-8a3bfabbbab8',
			'2019-05-08 12:32:00+03',
			'example_mail@ya.com',
			'Марина',
			'Цветаева',
			'MATSV0415',
			'123456',
			'я хз, что тут',
			false
			);

insert into auth_service.users (
       id,
			 created_date,
			 email_address,
			 first_name,
			 last_name,
			 login,
			 password,
			 credential,
			 active
			 )
			 values
			(
			'904fb0c3-4b38-4ba1-b072-b95b6b24b536',
			'2019-05-08 12:32:00+03',
			'example_mail@ya.com',
			'Фёдор',
			'Тютчев',
			'FETYU0515',
			'123456',
			'я хз, что тут',
			false
			);

insert into auth_service.users (
       id,
			 created_date,
			 email_address,
			 first_name,
			 last_name,
			 login,
			 password,
			 credential,
			 active
			 )
			 values
			(
			'd18ee19e-d14b-449a-ae36-c56f5515d1db',
			'2019-05-08 12:32:00+03',
			'example_mail@ya.com',
			'Иван',
			'Бунин',
			'IVBU0516',
			'123456',
			'я хз, что тут',
			false
			);

insert into auth_service.users (
       id,
			 created_date,
			 email_address,
			 first_name,
			 last_name,
			 login,
			 password,
			 credential,
			 active
			 )
			 values
			(
			'3c08292f-20ec-4f58-ac82-a46238f27ae2',
			'2019-05-08 12:32:00+03',
			'example_mail@ya.com',
			'Валерий',
			'Брюсов',
			'VABR0116',
			'123456',
			'я хз, что тут',
			false
			);

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      'd9923a76-b735-4904-a1a4-61100ebdd362',
      '1178439b-d6db-4f09-8a94-388804828a1b'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      '4dbb2b01-8e36-4049-8362-d79c29288a4f',
      '1178439b-d6db-4f09-8a94-388804828a1b'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      '480eaaf2-4083-4eab-a978-4892a950dec5',
      '1178439b-d6db-4f09-8a94-388804828a1b'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      '440bb660-8a95-4f59-9a3c-cca5e6c07692',
      '1178439b-d6db-4f09-8a94-388804828a1b'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      '17327fd7-1c79-4148-9dca-8a3bfabbbab8',
      '1178439b-d6db-4f09-8a94-388804828a1b'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      '904fb0c3-4b38-4ba1-b072-b95b6b24b536',
      '1178439b-d6db-4f09-8a94-388804828a1b'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      'd18ee19e-d14b-449a-ae36-c56f5515d1db',
      '1178439b-d6db-4f09-8a94-388804828a1b'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      '3c08292f-20ec-4f58-ac82-a46238f27ae2',
      '1178439b-d6db-4f09-8a94-388804828a1b'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      'd9923a76-b735-4904-a1a4-61100ebdd362',
      '04b5de7f-3c74-4724-a326-67d3ef6f6d5f'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      '4dbb2b01-8e36-4049-8362-d79c29288a4f',
      '04b5de7f-3c74-4724-a326-67d3ef6f6d5f'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      '480eaaf2-4083-4eab-a978-4892a950dec5',
      '04b5de7f-3c74-4724-a326-67d3ef6f6d5f'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      '440bb660-8a95-4f59-9a3c-cca5e6c07692',
      '04b5de7f-3c74-4724-a326-67d3ef6f6d5f'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      'd9923a76-b735-4904-a1a4-61100ebdd362',
      '534cf600-8b46-4bb7-88b2-c0d12a8af412'
      );

insert into auth_service.user_role_junction (
      user_id,
      system_role_id)
      values
      (
      '4dbb2b01-8e36-4049-8362-d79c29288a4f',
      '534cf600-8b46-4bb7-88b2-c0d12a8af412'
      );
