

CREATE TABLE IF NOT EXISTS student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    created_date TIMESTAMP,
    updated_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    hours INT,
    max_number_of_students INT NOT NULL,
    created_date TIMESTAMP,
    updated_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS lecture (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    lecturer VARCHAR(255),
    field_of_study VARCHAR(255),
    course_id BIGINT,
    created_date TIMESTAMP,
    updated_date TIMESTAMP,
    CONSTRAINT fk_course_lecture FOREIGN KEY (course_id) REFERENCES course(id)
);

CREATE TABLE IF NOT EXISTS enrollment (
    student_id BIGINT,
    course_id BIGINT,
    PRIMARY KEY (student_id, course_id),
    CONSTRAINT fk_student_enrollment FOREIGN KEY (student_id) REFERENCES student(id),
    CONSTRAINT fk_course_enrollment FOREIGN KEY (course_id) REFERENCES course(id)
);

ALTER TABLE student ALTER COLUMN id RESTART WITH 1000;
ALTER TABLE course ALTER COLUMN id RESTART WITH 1000;