insert into batches (batch_number, batch_location, b_address, b_city, b_state, b_zip) values 
(1, 'Morgantown', '650 Price Street', 'Morgantown', 'WV', '25605'),
(2, 'Virginia', '11730 Plaza America Drive', 'Reston', 'VA', '20190'),
(3, 'Tampa', '4202 E Fowler Ave', 'Tampa', 'FL', '33620'), 
(4, 'New York City', '65 Kissena Blvd', 'Flushing', 'NY', '11367'), 
(5, 'Dallas', '701 S Nedderman Dr', 'Arlington', 'TX', '76019');

insert into admins values
(1, 'admin1');

insert into users (user_id, email, first_name, h_address, h_city, h_state, h_zip, is_accepting_rides, is_active, is_driver, last_name, phone_number, user_name, w_address, w_city, w_state, w_zip, batch_number, car_id) values 
(1, 'gpichmann0@artisteer.com', 'Grady', '418 Wilson Ave', 'Morgantown', 'WV', '26501', false, false, false, 'Pichmann', '212-374-3466', 'gpichmann0', '650 Price Street', 'Morgantown', 'WV', '25605', 1, null),
(2, 'smigheli1@indiatimes.com', 'Salvidor', '418 Wilson Ave', 'Morgantown', 'WV', '26501', true, true, true, 'Migheli', '614-513-2776', 'smigheli1', '650 Price Street', 'Morgantown', 'WV', '25605', 1, null),
(3, 'fbraunroth2@ebay.co.uk', 'Fabien', '35 VanGilder Ave', 'Morgantown', 'WV', '26505', true, true, true, 'Braunroth', '402-694-8099', 'fbraunroth2', '650 Price Street', 'Morgantown', 'WV', '25605', 1, null),
(4, 'aocullen3@google.com.au', 'Aldon', '108 Wedgewood Dr', 'Morgantown', 'WV', '26505', true, false, false, 'O''Cullen', '607-732-5313', 'aocullen3', '650 Price Street', 'Morgantown', 'WV', '25605', 1, null),
(5, 'hgledhill4@hatena.ne.jp', 'Hilda', '496 High St', 'Morgantown', 'WV', '26505', true, true, true, 'Gledhill', '239-528-0279', 'hgledhill4', '650 Price Street', 'Morgantown', 'WV', '25605', 1, null),
(6, 'sdehoogh5@cnn.com', 'Simonne', '2162 Astoria Cir', 'Herndon', 'VA', '20170', false, false, true, 'De Hoogh', '206-506-8925', 'sdehoogh5', '11730 Plaza America Drive', 'Reston', 'VA', '20190', 2, null),
(7, 'dosullivan6@loc.gov', 'Darren', '2153 Astoria Cir', 'Herndon', 'VA', '20170', true, true, true, 'O Sullivan', '614-197-3998', 'dosullivan6', '11730 Plaza America Drive', 'Reston', 'VA', '20190', 2, null),
(8, 'ddorro7@issuu.com', 'Donnell', '12032 Waterside View Dr', 'Reston', 'VA', '20194', false, true, false, 'Dorro', '559-476-1222', 'ddorro7', '11730 Plaza America Drive', 'Reston', 'VA', '20190', 2, null),
(9, 'bmacvean8@shop-pro.jp', 'Brynne', '1897 Oracle Way', 'Reston', 'VA', '20190', true, false, false, 'MacVean', '734-143-5188', 'bmacvean8', '11730 Plaza America Drive', 'Reston', 'VA', '20190', 2, null),
(10, 'tcurd9@illinois.edu', 'Tobe', '8500 Tyspring St', 'Vienna', 'VA', '22182', true, true, true, 'Curd', '646-919-8954', 'tcurd9', '11730 Plaza America Drive', 'Reston', 'VA', '20190', 2, null),
(11, 'medmundsa@tiny.cc', 'Marilyn', '8060 Crianza Pl', 'Vienna', 'VA', '22182', true, true, true, 'Edmunds', '213-600-8430', 'medmundsa', '11730 Plaza America Drive', 'Reston', 'VA', '20190', 2, null),
(12, 'wmatissoffb@facebook.com', 'Wynne', '12065 Greywing Square', 'Reston', 'VA', '20191', false, false, true, 'Matissoff', '405-888-7795', 'wmatissoffb', '11730 Plaza America Drive', 'Reston', 'VA', '20190', 2, null),
(13, 'jlawfulc@simplemachines.org', 'Jozef', '5902 Memorial Hwy', 'Tampa', 'FL', '33615', false, true, true, 'Lawful', '509-805-2290', 'jlawfulc', '4202 E Fowler Ave', 'Tampa', 'FL', '33620', 3, null),
(14, 'flancashired@slideshare.net', 'Faythe', '16616 Palm Royal Dr', 'Tampa', 'FL', '33647', true, true, true, 'Lancashire', '216-591-6593', 'flancashired', '4202 E Fowler Ave', 'Tampa', 'FL', '33620', 3, null),
(15, 'llynnitte@creativecommons.org', 'Lorita', '800 Harbour Post Dr', 'Tampa', 'FL', '33602', true, false, true, 'Lynnitt', '704-705-3599', 'llynnitte', '4202 E Fowler Ave', 'Tampa', 'FL', '33620', 3, null),
(16, 'modooghainef@reference.com', 'Marcellina', '1911 Brandon Crossing Cir', 'Brandon', 'FL', '33511', true, true, false, 'O''Dooghaine', '208-387-2634', 'modooghainef', '4202 E Fowler Ave', 'Tampa', 'FL', '33620', 3, null),
(17, 'jsellwoodg@wisc.edu', 'Jaine', '626 Flatbush Ave', 'Brooklyn', 'NY', '11225', false, true, false, 'Sellwood', '302-836-7801', 'jsellwoodg', '65 Kissena Blvd', 'Flushing', 'NY', '11367', 4, null),
(18, 'wviani@homestead.com', 'Wain', '301 Sullivan Pl', 'Brooklyn', 'NY', '11225', false, false, true, 'Vian', '704-338-2790', 'wviani', '65 Kissena Blvd', 'Flushing', 'NY', '11367', 4, null),
(19, 'gtootellj@latimes.com', 'Geneva', '1601 W Arbrook Blvd', 'Arlington', 'TX', '76015', false, false, false, 'Tootell', '714-167-0152', 'gtootellj', '701 S Nedderman Dr', 'Arlington', 'TX', '76019', 5, null),
(20, 'cgeertzk@senate.gov', 'Cissy', '1802 Wimbledon Oaks Ln', 'Arlington', 'TX', '76017', false, false, true, 'Geertz', '281-310-3238', 'cgeertzk', '701 S Nedderman Dr', 'Arlington', 'TX', '76019', 5, null),
(21, 'lozintsevl@freewebs.com', 'Lynn', '4912 Paces Trail', 'Arlington', 'TX', '76017', true, true, true, 'Ozintsev', '704-108-6483', 'lozintsevl', '701 S Nedderman Dr', 'Arlington', 'TX', '76019', 5, null);

insert into cars values 
(1, 'Teal', 'Ford', 'Thunderbird', 3, 1972, 1),
(2, 'Orange', 'Lexus', 'IS', 1, 2012, 2),
(3, 'Puce', 'Saab', '9-3', 2, 2000, 3),
(4, 'Fuscia', 'Isuzu', 'Rodeo', 3, 2003, 4),
(5, 'Violet', 'GMC', 'Sierra 2500', 2, 2007, 5),
(6, 'Orange', 'Hyundai', 'Santa Fe', 1, 2003, 6),
(7, 'Yellow', 'Chrysler', 'Fifth Ave', 5, 1992, 7),
(8, 'Maroon', 'Honda', 'Ridgeline', 5, 2010, 8),
(9, 'Teal', 'Ford', 'Aerostar', 3, 1990, 9),
(10, 'Pink', 'Mercedes-Benz', '300CE', 2, 1993, 10),
(11, 'Crimson', 'MINI', 'Cooper Countryman', 2, 2011, 11),
(12, 'Khaki', 'Dodge', 'Viper', 4, 1994, 12),
(13, 'Pink', 'Pontiac', 'Bonneville', 2, 1987, 13),
(14, 'Khaki', 'Buick', 'Electra', 4, 1985, 14),
(15, 'Puce', 'Lamborghini', 'Countach', 5, 1990, 15),
(16, 'Indigo', 'Ford', 'Taurus', 1, 2012, 16),
(17, 'Indigo', 'Volkswagen', 'Golf III', 1, 1994, 17),
(18, 'Goldenrod', 'Lotus', 'Esprit', 1, 2002, 18),
(19, 'Red', 'Land Rover', 'Range Rover', 1, 1989, 19),
(20, 'Pink', 'Mercedes-Benz', 'M-Class', 5, 2000, 20),
(21, 'Red', 'Honda', 'Civic', 4, 2017, 21);

set foreign_key_checks=0;
update users set car_id =
(case when user_id = 1 then 1
	when user_id = 2 then 2
	when user_id = 3 then 3
	when user_id = 4 then 4
	when user_id = 5 then 5
	when user_id = 6 then 6
	when user_id = 7 then 7
	when user_id = 8 then 8
	when user_id = 9 then 9
	when user_id = 10 then 10
	when user_id = 11 then 11
	when user_id = 12 then 12
	when user_id = 13 then 13
	when user_id = 14 then 14
	when user_id = 15 then 15
	when user_id = 16 then 16
	when user_id = 17 then 17
	when user_id = 18 then 18
	when user_id = 19 then 19
	when user_id = 20 then 20
	when user_id = 21 then 21
end);
set foreign_key_checks=1;