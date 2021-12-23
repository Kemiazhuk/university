
INSERT INTO STUDENT VALUES ('72d9ba18-bda3-40dd-aaa8-2a20bcc4db8f', 'Student1', 'Student1', 'st1@stundent.com');
INSERT INTO STUDENT VALUES ('6dca6db3-0a93-4227-aae8-1825448d2583', 'Student2', 'Student2', 'st2@stundent.com');
INSERT INTO STUDENT VALUES ('3216f689-8973-4063-9077-b4a5f65d15f4', 'Student3', 'Student3', 'st3@stundent.com');
INSERT INTO STUDENT VALUES ('6c17edcc-1e4a-4f9e-b0a0-a2cde1a33530', 'Student4', 'Student4', 'st4@stundent.com');
INSERT INTO STUDENT VALUES ('77c8bbc5-d766-4207-9426-a475dcb6eef0', 'Student5', 'Student5', 'st5@stundent.com');

INSERT INTO TEACHER VALUES ('ad9a2900-1591-4ced-a912-241328ed0eb3', 'teach1', 'teach1', 'teach1@teacher.com');
INSERT INTO TEACHER VALUES ('2688c91a-ef02-40ae-b5ad-e1e2b80c2b6d', 'teach2', 'teach2', 'teach2@teacher.com');
INSERT INTO TEACHER VALUES ('724e7b7d-9b3d-4f73-ac2e-ac383c1e78b6', 'teach3', 'teach3', 'teach3@teacher.com');
INSERT INTO TEACHER VALUES ('816345a0-411b-43bc-94ab-47f18e50aab1', 'teach4', 'teach4', 'teach4@teacher.com');
INSERT INTO TEACHER VALUES ('432127ed-b416-4ec9-a25c-bc1af0cddf9c', 'teach5', 'teach5', 'teach5@teacher.com');

INSERT INTO ACCOUNT VALUES ('38b8370e-925c-49af-a0e6-378287315126','user1St', '$2a$10$AZvx8J3fMme/6q8lHQKGxucuVhQH2og6rQazh/9piakpdC4mpiLAq','72d9ba18-bda3-40dd-aaa8-2a20bcc4db8f',null, 'STUDENT');
INSERT INTO ACCOUNT VALUES ('0fe2a20e-17d7-4802-9d66-2730de849eaf','user2St', '$2a$10$AZvx8J3fMme/6q8lHQKGxucuVhQH2og6rQazh/9piakpdC4mpiLAq','6dca6db3-0a93-4227-aae8-1825448d2583',null, 'STUDENT');
INSERT INTO ACCOUNT VALUES ('f1f24ba5-aaf9-4287-98c2-d5dd59b227d1','user3St', '$2a$10$AZvx8J3fMme/6q8lHQKGxucuVhQH2og6rQazh/9piakpdC4mpiLAq','3216f689-8973-4063-9077-b4a5f65d15f4',null, 'STUDENT');
INSERT INTO ACCOUNT VALUES ('30e7831c-67e9-4027-a59a-85551a21ccc7','user4St', '$2a$10$AZvx8J3fMme/6q8lHQKGxucuVhQH2og6rQazh/9piakpdC4mpiLAq','6c17edcc-1e4a-4f9e-b0a0-a2cde1a33530',null, 'STUDENT');
INSERT INTO ACCOUNT VALUES ('c8ae1b4c-70ed-4ae3-aecb-345f145f4d19','user5St', '$2a$10$AZvx8J3fMme/6q8lHQKGxucuVhQH2og6rQazh/9piakpdC4mpiLAq','77c8bbc5-d766-4207-9426-a475dcb6eef0',null, 'STUDENT');
INSERT INTO ACCOUNT VALUES ('202412da-475e-416f-a30d-f679acf564f7','user6T', '$2a$10$2FVv0txoaAuTMPv.iKC/eOI/qdwNdNG5cPVj9eY0nUG.3iDuUsne.',null,'ad9a2900-1591-4ced-a912-241328ed0eb3', 'TEACHER');
INSERT INTO ACCOUNT VALUES ('fa2751d1-507d-46fe-a7ca-d849d381ba1c','user7T', '$2a$10$2FVv0txoaAuTMPv.iKC/eOI/qdwNdNG5cPVj9eY0nUG.3iDuUsne.',null,'2688c91a-ef02-40ae-b5ad-e1e2b80c2b6d', 'TEACHER');
INSERT INTO ACCOUNT VALUES ('861b5b5a-bb92-4863-81f1-e82dd6ee4bce','user8T', '$2a$10$2FVv0txoaAuTMPv.iKC/eOI/qdwNdNG5cPVj9eY0nUG.3iDuUsne.',null,'724e7b7d-9b3d-4f73-ac2e-ac383c1e78b6', 'TEACHER');
INSERT INTO ACCOUNT VALUES ('a0f46d7a-b3ce-4810-9580-f4aca42d2e1c','user9T', '$2a$10$2FVv0txoaAuTMPv.iKC/eOI/qdwNdNG5cPVj9eY0nUG.3iDuUsne.',null,'816345a0-411b-43bc-94ab-47f18e50aab1', 'TEACHER');
INSERT INTO ACCOUNT VALUES ('61c32d3e-5bd1-4fe1-8d38-be7b1a5b029c','user10T', '$2a$10$2FVv0txoaAuTMPv.iKC/eOI/qdwNdNG5cPVj9eY0nUG.3iDuUsne.',null,'432127ed-b416-4ec9-a25c-bc1af0cddf9c', 'TEACHER');

INSERT INTO COURSE VALUES ('71730519-e0c0-428b-84ec-151f86ca7d08','Mathematics','2020-10-10', '2020-10-20', 'ad9a2900-1591-4ced-a912-241328ed0eb3');
INSERT INTO COURSE VALUES ('4571a8c9-633c-4455-8b6f-911c018431af','Physics','2020-09-10', '2020-09-15', 'ad9a2900-1591-4ced-a912-241328ed0eb3');
INSERT INTO COURSE VALUES ('13ffc0e1-cc45-451b-95ef-11cebf7b84aa','Biology','2020-08-10', '2020-08-19', '2688c91a-ef02-40ae-b5ad-e1e2b80c2b6d');
INSERT INTO COURSE VALUES ('1117af50-7cdf-4b6c-94bb-da6404cb5c1f','Chemistry','2020-07-10', '2020-07-18', '2688c91a-ef02-40ae-b5ad-e1e2b80c2b6d');
INSERT INTO COURSE VALUES ('2a472748-4b06-420e-afd0-04f72d2ce61e','History','2020-10-10', '2020-11-01', '724e7b7d-9b3d-4f73-ac2e-ac383c1e78b6');
INSERT INTO COURSE VALUES ('f3bad603-bab6-446c-87ad-1e3565253565','Music','2020-01-10', '2020-12-23', '816345a0-411b-43bc-94ab-47f18e50aab1');
INSERT INTO COURSE VALUES ('5ac7ad43-3a52-42ee-9d5d-8a91a7823dd3','Art','2020-12-01', '2020-12-05', '432127ed-b416-4ec9-a25c-bc1af0cddf9c');

INSERT INTO STUDENT_COURSE VALUES ('cbc81107-0e11-476e-b929-0631455740ed','72d9ba18-bda3-40dd-aaa8-2a20bcc4db8f','71730519-e0c0-428b-84ec-151f86ca7d08',4,'good');
INSERT INTO STUDENT_COURSE VALUES ('1a1acb91-bb91-4b5a-ae6e-80916cfda2f4','72d9ba18-bda3-40dd-aaa8-2a20bcc4db8f','4571a8c9-633c-4455-8b6f-911c018431af',3,'bad');
INSERT INTO STUDENT_COURSE VALUES ('9b047ac9-5291-446b-887c-5bf4fe884337','6dca6db3-0a93-4227-aae8-1825448d2583','13ffc0e1-cc45-451b-95ef-11cebf7b84aa',4,'good');
INSERT INTO STUDENT_COURSE VALUES ('593c0fe1-d312-410d-a465-b098acdd3444','6dca6db3-0a93-4227-aae8-1825448d2583','1117af50-7cdf-4b6c-94bb-da6404cb5c1f',4,'good');
INSERT INTO STUDENT_COURSE VALUES ('1e345127-f570-420d-827d-98140710be73','3216f689-8973-4063-9077-b4a5f65d15f4','2a472748-4b06-420e-afd0-04f72d2ce61e',5,'great');
INSERT INTO STUDENT_COURSE VALUES ('77f153ea-a604-4c8c-8e5d-fc257838f35d','6c17edcc-1e4a-4f9e-b0a0-a2cde1a33530','f3bad603-bab6-446c-87ad-1e3565253565',4,'good');
INSERT INTO STUDENT_COURSE VALUES ('fbb64d63-03a0-44fa-99a1-a99e0cb018ae','6c17edcc-1e4a-4f9e-b0a0-a2cde1a33530','5ac7ad43-3a52-42ee-9d5d-8a91a7823dd3',4,'good');
INSERT INTO STUDENT_COURSE VALUES ('bdd140b1-c3b7-4b2f-90a8-fafd4f1e83d9','77c8bbc5-d766-4207-9426-a475dcb6eef0','71730519-e0c0-428b-84ec-151f86ca7d08',4,'good');
INSERT INTO STUDENT_COURSE VALUES ('6c8f4e0b-5d27-4dee-bb75-9dc9374efea3','77c8bbc5-d766-4207-9426-a475dcb6eef0','4571a8c9-633c-4455-8b6f-911c018431af',4,'good');
INSERT INTO STUDENT_COURSE VALUES ('b724288e-1dd6-4448-91f1-8f798e1d428b','77c8bbc5-d766-4207-9426-a475dcb6eef0','13ffc0e1-cc45-451b-95ef-11cebf7b84aa',4,'good');
INSERT INTO STUDENT_COURSE VALUES ('a38d477e-b8ef-45ac-b57f-b329bc44853c','77c8bbc5-d766-4207-9426-a475dcb6eef0','1117af50-7cdf-4b6c-94bb-da6404cb5c1f',4,'good');
INSERT INTO STUDENT_COURSE VALUES ('2ad8506e-de2d-4205-9891-87ef7544fe4d','77c8bbc5-d766-4207-9426-a475dcb6eef0','2a472748-4b06-420e-afd0-04f72d2ce61e',4,'good');



