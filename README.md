# Задача «Безопасное приложение»

## Описание
ветка `security-app`

Сегодня вы попрактикуетесь в обеспечении безопасности для приложений. Вы ограничите доступ к endpoint.

1. Возьмите любое из уже реализованных приложений на `Spring Boot`, где есть контроллер и не менее одного метода-обработчика запросов на разные endpoint.

2. Добавьте в приложение зависимость на `spring-boot-starter-security`.

3. Реализуйте класс-наследник `WebSecurityConfigurerAdapter` так, чтобы:

- пользователь логинился через стандартную форму логина от Spring;
- как минимум на один из endpoint вашего приложения можно было попасть без авторизации, а на все остальные — только после авторизации.

4. Запуште изменения в репозиторий и прикрепите ссылку на него в комментарий к домашнему заданию.


# Задача «Слой DAO c JPA Repositories»

## Описание
ветка `jpa-repository`
(Изначально запустите скрипт SQL из папки resources)

Попрактикуемся в работе с JPA Repositories, переписав приложение для работы с БД [«Слой DAO c Hibernate»](../../hibernate/task1/README.md).

**Что нужно сделать**

1. Перепишите репозиторий для работы с БД на основе методов-запросов:

- чтобы у вашего репозитория были основные методы для `CRUD` операций;
- создайте метод, который будет принимать название города (`city`) и возвращать `Entity` из базы данных, которые соответствуют этому `city`;
- создайте метод, который будет принимать возраст (`age`) и возвращать `Entity` из базы данных, которые меньше переданного `age` и отсортированы по возрастанию;
- создайте метод, который будет принимать имя и фамилию (`name` и `surname`) и возвращать `Entity` из базы данных, которые соответствуют сочетанию `name` и `surname` и являются `Optional`.

2. Допишите недостающие методы контроллера в соответствии с появившимися новыми методами в репозитории.

3. Написанный код выложите в тот же репозиторий, что и для задачи [«Слой DAO c Hibernate»](../../hibernate/task1/README.md) на GitHub, только создайте под него другую ветку `jpa-repository` и прикрепите ссылку на неё в комментарий к домашнему заданию.

___

# Задача «Слой DAO c Hibernate»

## Описание

Попрактикуемся в работе с Hibernate через Spring, параллельно закрепляя уже пройденные темы. 

Вам надо написать приложение для работы с БД, используя средства Spring по конфигурации и работе с Hibernate, адаптировав таблицы из задания [«Таблица пользователей»](../../sql-basic/task/README.md).

**Что нужно сделать**

1. Создайте Spring Boot приложение с зависимостями на два стартера — `spring-boot-starter-data-jpa` и `spring-boot-starter-web`.

2. Создайте Entity, которая соответствует таблице из условий задачи [«Таблица пользователей»](../../sql-basic/task/README.md).

3. Напишите репозиторий для работы с БД. 

 - создайте класс и пометьте его аннотацией Repository, либо создайте бин репозитория в Java Config классе;
 - правильно инжектируйте EntityManager;
 - создайте метод `getPersonsByCity(String city)`, который будет принимать название города и возвращать ваше Entity из базы данных, соответствующие этому `city`. Сделать это можно, например, получив всех пользователей и отфильтровав их по городу.

4. Напишите контроллер с методом-обработчиком GET-метода запроса с маппингом на endpoint `/persons/by-city`. В query params запроса будет приходить строковый параметр `city`, который вам надо будет передавать дальше в репозиторий. То есть, ваш метод должен уметь обрабатывать запрос вида `localhost:8080/persons/by-city?city=Moscow`.
Контроллер должен будет возвращать всех людей, которых он получит от репозитория.

5. Написанные код выложите в отдельный репозиторий на GitHub и прикрепите ссылку на него в комментарий к домашнему заданию.