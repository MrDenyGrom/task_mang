# Документация API для управления задачами

## 1. Введение

Данный RESTful API предоставляет функциональность для управления задачами. Он позволяет зарегистрированным пользователям создавать, редактировать, удалять задачи, управлять их статусом и оставлять комментарии. 

## 2. Базовый URL

http://localhost:8080

## 3. Аутентификация

API использует JWT авторизацию для контроля доступа к ресурсам. После успешной авторизации на endpoint `/user/login`  вы получите JWT токен. 

**Пример:**

{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjMiLCJpYXQiOjE3MjQ1MTE5NzIsImV4cCI6MTcyNDU0Nzk3Mn0.cZ844X7knD5rNSGarT4Q77X5UzkKVRP7IVLy_bbTHIzju9KgJSsuWQSNkiPSvxJCCWhMzRGcEz1fwjsJCbqDZA"
}

## 3.1 Регистрация пользователя

**POST /user/register**

Регистрирует нового пользователя в системе.

**Тело запроса (application/json):**

```json
{
  "username": "123",
  "password": "123"
}

### Ответы:
**201 Created:** *Пользователь успешно зарегистрирован.*
**409 Conflict:** *Пользователь с таким именем уже существует.*

## 3.2 Авторизация пользователя
**POST /user/login**
Авторизует пользователя и возвращает JWT токен для доступа к защищенным endpoint'ам (всем остальным).

**Тело запроса (application/json):**

``` json
{
  "username": "123",
  "password": "123"
}

### Ответы:
**200 OK:** *Авторизация успешна.* 

Возвращается JWT токен в теле ответа:

``` json
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjMiLCJpYXQiOjE3MjQ1MTE5NzIsImV4cCI6MTcyNDU0Nzk3Mn0.cZ844X7knD5rNSGarT4Q77X5UzkKVRP7IVLy_bbTHIzju9KgJSsuWQSNkiPSvxJCCWhMzRGcEz1fwjsJCbqDZA"
}

## 4. Задачи

## 4.1 Создание задачи

**POST /tasks/create**

Создает новую задачу.

**Тело запроса (application/json):**

``` json
{
  "head": "string",
  "description": "string",
  "status": "WAITING",
  "priority": "HIGH",
  "executorUsername": "string"
}

**Возможные статусы задачи:**

*WAITING* - ожидает выполнения

*IN_PROGRESS* - в процессе выполнения

*COMPLETED* - выполнена

**Возможные приоритеты задачи:**

*HIGH* - высокий

*MEDIUM* - средний

*LOW* - низкий

### Ответы:
**200 OK:** *Задача успешно создана.* 

Возвращается объект созданной задачи:

``` json
{
  "id": 4,
  "head": "string",
  "description": "string",
  "status": "WAITING",
  "priority": "HIGH",
  "userAuthor": {
    "id": 1,
    "username": "string",
    "password": "$2a$10$162CrmXuycy6NWg5YJlhauEB/R8XCg9SY7DpazH5dzzKyyUSCDX/a"
  },
  "userExecutor": {
    "id": 1,
    "username": "string",
    "password": "$2a$10$162CrmXuycy6NWg5YJlhauEB/R8XCg9SY7DpazH5dzzKyyUSCDX/a"
  }
}

## 4.2 Редактирование задачи

**PUT /tasks/edit/{id}**

Редактирует существующую задачу.

**Параметры:**

*id* (integer): ID задачи, которую нужно отредактировать.

``` json
Тело запроса (application/json):

{
  "head": "Новый заголовок",
  "description": "Новое описание",
  "status": "IN_PROGRESS",
  "priority": "MEDIUM",
  "executorUsername": "новое_имя_пользователя_исполнителя"
}
