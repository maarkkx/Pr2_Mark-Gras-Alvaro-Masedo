INSERT INTO classes (class_id, nom)
	VALUES
		(7, 'Support'),
		(3, 'Marksman'),
		(1, 'Damage Dealer'),
		(2, 'Tank'),
		(6, 'Assassin');
		
INSERT INTO rarities (rarity_id, nom)
	VALUES
		(6, 'Legendary'),
		(4, 'Epic'),
		(2, 'Rare');

INSERT INTO brawlers (brawler_id, nom, class_id, rarity_id)
	VALUES
		(16000010, 'El Primo', 2, 2),
		(16000015, 'Piper', 3, 4),
		(16000016, 'Pam', 7, 4),
		(16000005, 'Spike', 1, 6),
		(16000023, 'Leon', 6, 6);
		
INSERT INTO gadgets (gadget_id, nom, descripcio, brawler_id)
	VALUES
		(23000264, 'Suplex Supplement', 'El Primo grabs the closest enemy within his reach and flips them like a pancake over his broad shoulders.', 16000010),
		(23000268, 'Auto Aimer', 'Piper pops a defensive shot at the closest enemy, dealing x damage, while also pushing them back.', 16000015),
		(23000257, 'Pulse Modulator', 'Pam triggers her turret to emit a pulse that heals allies inside the turrets range, including herself, for x health.', 16000016),
		(23000247, 'Popping Pincushion', 'Spike shoots x waves of needles in all directions, dealing x damage per hit.', 16000005),
		(23000276, 'Clone Projector', 'Leon creates an illusion of himself to confuse his enemies.0', 16000023);
		
INSERT INTO starpowers (starpower_id, nom, descripcio, brawler_id)
	VALUES
		(23000086, 'El Fuego', 'Enemies caught in El Primos Super will burn for x damage over 4 seconds.', 16000010),
		(23000091, 'Ambush', 'Pipers attack deals +x extra damage (at max range) when shes hidden in a bush',16000015),
		(23000092, 'Mamas Hug', 'Whenever Pam hits enemy Brawlers with Scrapstorm, she heals herself and nearby friendly Brawlers for x health.', 16000016),
		(23000081, 'Fertilize', 'After using Super, Spike regenerates x health per second by staying in its area of effect.', 16000005),
		(23000119, 'Smoke Trails', 'When Leon uses his Super, he gains a x% boost to his movement speed for the duration of his invisibility.', 16000023);