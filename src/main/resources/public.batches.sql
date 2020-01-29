-- DROP TABLE Public.batches;
CREATE TABLE public.batches (
	batch_number int4 NOT NULL,
	batch_location varchar(255) NULL,
	CONSTRAINT batches_pkey PRIMARY KEY (batch_number)
);


insert into public.batches(batch_number, batch_location) values (1, 5);
insert into public.batches(batch_number, batch_location) values (2, 7);
insert into public.batches(batch_number, batch_location) values (3, 9);
insert into public.batches(batch_number, batch_location) values (4, 4);
insert into public.batches(batch_number, batch_location) values (5, 10);
insert into public.batches(batch_number, batch_location) values (6, 3);
insert into public.batches(batch_number, batch_location) values (7, 5);
insert into public.batches(batch_number, batch_location) values (8, 4);
insert into public.batches(batch_number, batch_location) values (9, 9);
insert into public.batches(batch_number, batch_location) values (10, 7);
insert into public.batches(batch_number, batch_location) values (11, 6);
insert into public.batches(batch_number, batch_location) values (12, 3);
insert into public.batches(batch_number, batch_location) values (13, 6);
insert into public.batches(batch_number, batch_location) values (14, 4);
insert into public.batches(batch_number, batch_location) values (15, 3);
insert into public.batches(batch_number, batch_location) values (16, 7);
insert into public.batches(batch_number, batch_location) values (17, 10);
insert into public.batches(batch_number, batch_location) values (18, 7);
insert into public.batches(batch_number, batch_location) values (19, 1);
insert into public.batches(batch_number, batch_location) values (20, 1);
