CREATE TABLE "brawlers" (
	"brawler_id"	INTEGER NOT NULL UNIQUE,
	"nom"	TEXT NOT NULL,
	"class_id"	INTEGER NOT NULL,
	"rarity_id"	INTEGER NOT NULL,
	PRIMARY KEY("brawler_id"),
	CONSTRAINT "clase" FOREIGN KEY("class_id") REFERENCES "classes"("class_id"),
	CONSTRAINT "rarity" FOREIGN KEY("rarity_id") REFERENCES "rarities"("rarity_id")
);

CREATE TABLE "classes" (
	"class_id"	INTEGER NOT NULL UNIQUE,
	"nom"	TEXT NOT NULL,
	PRIMARY KEY("class_id")
);

CREATE TABLE "gadgets" (
	"gadget_id"	INTEGER NOT NULL UNIQUE,
	"nom"	TEXT NOT NULL,
	"descripcio"	TEXT NOT NULL,
	"brawler_id"	INTEGER NOT NULL,
	PRIMARY KEY("gadget_id"),
	CONSTRAINT "brawler" FOREIGN KEY("brawler_id") REFERENCES "brawlers"("brawler_id")
);

CREATE TABLE "rarities" (
	"rarity_id"	INTEGER NOT NULL UNIQUE,
	"nom"	TEXT NOT NULL,
	PRIMARY KEY("rarity_id")
);

CREATE TABLE "starpowers" (
	"starpower_id"	INTEGER NOT NULL UNIQUE,
	"nom"	TEXT NOT NULL,
	"descripcio"	TEXT NOT NULL,
	"brawler_id"	INTEGER NOT NULL,
	PRIMARY KEY("starpower_id"),
	CONSTRAINT "brawler" FOREIGN KEY("brawler_id") REFERENCES "brawlers"("brawler_id")
);