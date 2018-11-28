USE Medical_institute;

INSERT INTO case_status(name, description)
VALUES('OPENED', 'Case is opened');

INSERT INTO case_status(name, description)
VALUES('CLOSED', 'Case is closed');

INSERT INTO case_status(name, description)
VALUES('CANCELLED', 'Case is cancelled');

INSERT INTO case_status(name, description)
VALUES('COMPLETED', 'Case is completed');

INSERT INTO procedure_status(name, description)
VALUES('NEW', 'New procedure created');

INSERT INTO procedure_status(name, description)
VALUES('DONE', 'Procedure has done');

INSERT INTO procedure_status(name, description)
VALUES('NOT_DONE', 'Procedure has not done');