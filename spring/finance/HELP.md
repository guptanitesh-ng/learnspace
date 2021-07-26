# Getting Started

### Reference Documentation

Reference for private and public key stuff
https://www.novixys.com/blog/how-to-generate-rsa-keys-java/

CURL commands to work with this application.

curl "http://localhost:8080/clu/fin/start-session" -i -v -u user1:pass -H "Content-Type: application/json" -d "{}" -X POST
curl "http://localhost:8080/clu/fin/hello" -i -u user1:pass -v -H "X-CSRF-TOKEN: df8a2248-c799-4eb9-811f-b0180a9b9765"

curl "http://localhost:8080/clu/fin/hello" -i -v -H "X-CSRF-TOKEN: 88eca24c-e386-418b-9fee-0f5b72332c1e" -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiAiQWxleDEyMyIsDQogICJzY29wZXMiOiBbDQogICAgew0KICAgICAgImF1dGhvcml0eSI6ICJST0xFX0FETUlOIg0KICAgIH0NCiAgXSwNCiAgImlzcyI6ICJodHRwOi8vZGV2Z2xhbi5jb20iLA0KICAiaWF0IjogMTUwODYwNzMyMiwNCiAgImV4cCI6IDE1MDg2MjUzMjJ9.KCLk0RrmPp3yqOGN-k-JVHai71qHapDrapa7F-67ohjypNKFkxw0Gp4bOjhjzSQ8X4K___lchIbID0Lfi0vlzNUZ8-v3DD9Hyo0_cWVEkCNH-fnl923DK8CuESWfGl1r8ehPm1pRiUk2XprK7a5y1lnRWy_FRRLRk6pZHOcV902MfC12PHACzAGEA0AZfXWsbyUcKmiNZaVEYm0TK0OeflhOAn6xNJRgonmQD9LOLfZQJhYtofAP02daKBFdk2R6qwS9C2PLbGwLKd13J01zOht4qf0m8bHoAn1s9TbKKSoAUxDVqKmpZPltGh_KnBeCLrh4QVyQ7qtTIyrTC-pM_A" -b 'JSESSIONID=5CD20C47515B0EFB8F3D8279A88404CB'

curl "http://localhost:8080/clu/fin/check-csrf" -i -v -u user1:pass -H "Content-Type: application/json" -H "X-CSRF-TOKEN: c7347baa-87d9-421a-8e77-bc34d0195f90" -b 'JSESSIONID=41FF2195857A2C8B64EF9C0C4F61540E' -d "{\"key\":\"value\"}" -X POST

# This application demos couple of things - Usage of EhCache and Spring Security. The coverage of spring security is extensive in this application.