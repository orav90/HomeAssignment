INSERT INTO student (id, first_name, last_name, created_date, updated_date) VALUES (1, 'John', 'Doe', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO student (id, first_name, last_name, created_date, updated_date) VALUES (2, 'Donald', 'Duck', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO student (id, first_name, last_name, created_date, updated_date) VALUES (3, 'Homer', 'Simpson', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO student (id, first_name, last_name, created_date, updated_date) VALUES (4, 'Rick', 'Sanchez', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO student (id, first_name, last_name, created_date, updated_date) VALUES (5, 'Patrick', 'Star', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO course (id, description, hours, max_number_of_students, created_date, updated_date) VALUES (1, 'Math', 120, 30, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO course (id, description, hours, max_number_of_students, created_date, updated_date) VALUES (2, 'English', 100, 25, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO course (id, description, hours, max_number_of_students, created_date, updated_date) VALUES (3, 'Hebrew', 110, 20, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO course (id, description, hours, max_number_of_students, created_date, updated_date) VALUES (4, 'Biology', 90, 30, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO course (id, description, hours, max_number_of_students, created_date, updated_date) VALUES (5, 'Computer Science', 130, 35, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO lecture (id, lecturer, field_of_study, course_id, created_date, updated_date) VALUES (1, 'Bill Gates', 'Computer Science', 5, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO lecture (id, lecturer, field_of_study, course_id, created_date, updated_date) VALUES (2, 'Mark Zuckerberg', 'Hebrew', 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO lecture (id, lecturer, field_of_study, course_id, created_date, updated_date) VALUES (3, 'Elon Musk', 'Math', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO lecture (id, lecturer, field_of_study, course_id, created_date, updated_date) VALUES (4, 'Donald Trump', 'Biology', 4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO lecture (id, lecturer, field_of_study, course_id, created_date, updated_date) VALUES (5, 'Kamala Harris', 'Math', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO enrollment (student_id, course_id) VALUES (1, 1);
INSERT INTO enrollment (student_id, course_id) VALUES (1, 2);
INSERT INTO enrollment (student_id, course_id) VALUES (2, 3);
INSERT INTO enrollment (student_id, course_id) VALUES (3, 4);
INSERT INTO enrollment (student_id, course_id) VALUES (4, 5);
INSERT INTO enrollment (student_id, course_id) VALUES (5, 1);
INSERT INTO enrollment (student_id, course_id) VALUES (5, 2);
