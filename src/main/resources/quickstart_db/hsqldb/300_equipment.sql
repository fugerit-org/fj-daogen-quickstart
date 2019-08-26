CREATE TABLE daogen_quickstart.equipment (
	id BIGINT NOT NULL,
	id_owner BIGINT,
	id_creator BIGINT,
	creation_date TIMESTAMP NOT NULL,
	update_date TIMESTAMP NOT NULL,
	description VARCHAR(1024) NOT NULL,
	state BIGINT NOT NULL
);

ALTER TABLE daogen_quickstart.equipment ADD CONSTRAINT equipment_pk PRIMARY KEY ( id );
ALTER TABLE daogen_quickstart.equipment ADD CONSTRAINT equipment_fk1 FOREIGN KEY ( id_owner ) REFERENCES person ( id );
ALTER TABLE daogen_quickstart.equipment ADD CONSTRAINT equipment_fk2 FOREIGN KEY ( id_creator ) REFERENCES person ( id );

COMMENT ON TABLE daogen_quickstart.equipment IS 'equipments meta informations';
COMMENT ON COLUMN daogen_quickstart.equipment.id_owner IS 'Reference to owner';
COMMENT ON COLUMN daogen_quickstart.equipment.id_creator IS 'Reference to creator';
COMMENT ON COLUMN daogen_quickstart.equipment.creation_date IS 'equipment creation time';
COMMENT ON COLUMN daogen_quickstart.equipment.update_date IS 'equipment update time';
COMMENT ON COLUMN daogen_quickstart.equipment.description IS 'equipments description';
COMMENT ON COLUMN daogen_quickstart.equipment.state IS 'equipment state';

INSERT INTO daogen_quickstart.equipment VALUES ( 20, 1, 3, '2019-03-01', '2019-03-02', 'First Silmaril', 1 );
INSERT INTO daogen_quickstart.equipment VALUES ( 21, 2, 3, '2019-03-01', '2019-03-02', 'First Silmaril', 1 );
INSERT INTO daogen_quickstart.equipment VALUES ( 22, 3, 3, '2019-03-01', '2019-03-02', 'First Silmaril', 1 );

