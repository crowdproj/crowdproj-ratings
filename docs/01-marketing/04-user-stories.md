# Пользовательские истории
В данной ситуации описываются user stories для конечных пользователей системы рейтингования (потребитель и поставщик).

## 1. Поиск предложений для задачи пользователя - потребителя с отражением рейтинга товара / услуги

**В качестве** пользователя сервиса рейтингование товара / услуги, \
**Я хочу** видеть список товаров / услуг для моей задачи с рейтингом и количеством голосов (отзывов), \
**Для того, чтобы** иметь представление об обратной связи о ранее приобретенных товарах / услугах на рынке, и выбирать наиболее подходящие предложения.

1. Сценарий: список товаров / услуг для моей потребности. \
   **Дано:** у меня есть потребность в товаре / услуге. \
   **Когда** я ввожу описание потребности, \
   **тогда** я вижу список релевантных товаров / услуг для соответствующей потребности с данными рейтинга (от 1 до 5) и количеством голосов (отзывов), \
   **и** список товаров / услуг по умолчанию отсортирован по степени рейтинга (и количеству голосов), \
   **и** длина списка позиций продуктов по умолчанию не более 10.

2. Сценарий: просмотр полного списка товаров / услуг. \
   **Дано:** я нахожусь на странице просмотра потребностей, \
   **И** вижу список из 10 предложений.
   **Когда** я нажимаю кнопку "полный список", \
   **тогда** я вижу полный список релевантных предложений для соответствующей потребности с указанием рейтинга и количества голосов.

## 2. Изучение (анализ) оценки (рейтинг) товара / услуги для пользователя - производителя продукта

**В качестве** пользователя сервиса рейтингование товара / услуги, \
**Я хочу** видеть рейтинг предлагаемого мной товара / услуги, \
**Для того, чтобы** более детально изучить обратную связь и учесть оценку при разработке товара / услуги для роста продаж.

1. Сценарий: рейтинг моего товара / услуги, количество голосов (отзывов). \
   **Дано:** у меня есть заведенный товар / услуга. \
   **Когда** я захожу на описание продукта, \
   **тогда** я вижу рейтинг и количество голосов (отзывов) релевантности потребностей клиента для соответствующего товара / услуги, \
   **и** детализация рейтинга по характеристикам товара / услуги с количеством голосов (отзывов), \
   **и** список характеристик, участвующих в рейтинге, по умолчанию отсортирован по степени убывания.