# Shcedule API

| 기능       | HTTP Method |       URL       | Path Variable | request                                                                                                                                                | response                                                                                                                                                         |             상태              |
|----------|:-----------:|:---------------:|:-------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------|:---------------------------:|
| 추가       |    POST     |   /shcedules    |               | {<br> "user_id" : "아이디",<br> "user_pw": "비밀번호",<br> "name" : "이름",<br> "todo" : "할 일",<br> "created_date" : 2025-03-24,<br> "updated_date" :NULL<br> } | {<br> "id" : 1,<br>"todo" : "할 일",<br> "created_date" : 2025-03-24<br>} <br>| 성공:OK<br>실패:Bad_request<br> |
| 월 별 조회   |     GET     |   /shcedules    |               | {<br>"month" : 3<br> {<br>                                                                                                                             | [<br>&nbsp;&nbsp;{<br>&nbsp;&nbsp;"id" : 1,<br>&nbsp;&nbsp;"todo" : "할 일",<br>&nbsp;&nbsp;"created_date" : 2025-03-24<br>&nbsp;&nbsp;}<br>&nbsp;]<br>}<br> | 성공:OK<br>실패:Bad_request<br> |
| 작성자 글 조회 |     GET     |   /shcedules    |               | {<br>"name" : "name"<br>}                                                                                                                              |{<br>"id" : 1,<br>"todo" : "할 일"<br>,<br>"created_date" : 2025-03-24<br>}| 성공:OK<br>실패:NOT_request<br> |
| 작성자 기간별 조회 |     GET     |   /shcedules    |               | {<br>start_date : 2025-03-01,<br>end_data : 2025-03-31<br>}                                                                                            |{<br>"id" : 1,"todo" : "할 일"<br>,"created_date" : 2025-03-24<br>}| 성공:OK<br>실패:NOT_request<br> |
| 일정 내용 수정 |    PATCH    |   /shcedules/{id}    |   id (Long)  | {<br>"name" : "이름",<br>"todo" : "할 일"<br>}                                                                                                             |{<br>"id" : 1,<br>"todo" : "할 일"<br>}| 성공:OK<br>실패:NOT_request<br> |
| 일정 수정    |    PATCH    |   /shcedules/{id}    |   id (Long)   | {<br>"name" : "이름",<br>"todo" : "할 일",<br>"created_date" : 2025-03-24,<br>"updated_date" :2025-03-25<br>}                                                  |{ <br>"id" : 1,<br>"todo" : "할 일",<br>"created_date" : 2025-03-24,<br>"updated_date": 2025-03-25<br>}| 성공:OK<br>실패:NOT_request<br> |
| 단 건 삭제 |    DELETE   | /shcedules/{id} |   id (Long)   |                                                                                                                                                        |{<br>"id" : 1,<br>"mes" : 삭제되었습니다.<br>}| 성공:OK<br>실패:NOT_request<br> |

# Shcedule DB

| 칼럼           | 명칭     | 입력 Type   | Null 유무  |
|--------------|--------|-----------|----------|
| USER_ID      | 작성자 ID | VARCHAR    | NOT NULL |
| USER_PW      | 작성자 PW | VARCHAR    | NOT NULL |
| NAME         | 작성자 이름 | VARCHAR    | NOT NULL |
| ID           | 글 ID   | BIGINT    | NOT NULL |
| TODO         | 내용     | VARCHAR   | NULL     |
| CREATED_DATE | 작성일    | TIMESTEMP | NOT NULL |
| UPDATED_DATE | 수정일    | TIMESTEMP | NULL     |

