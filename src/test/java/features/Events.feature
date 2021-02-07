
#@withdrawal
Feature: Events

  Scenario: Просмотр предстоящих мероприятий
Given main page open
  When User navigates to the "Events" tab
  And User clicks on "Upcoming events" button
    Then Event dates are greater than or equal to the current date
  Then Number of cards is equal to the counter on the "Upcoming Events" button

Scenario: Просмотр карточек мероприятий
Given main page open
When User navigates to the "Events" tab
And User clicks on "Upcoming events" button
  Then Event dates are greater than or equal to the current date
Then The card contains information about the event
  | online                    |1|
  | language                  |2|
  | evnt-event-name           |3|
  | date                      |4|
  | evnt-people-cell speakers |5|
#Важно проверить порядок отображаемых блоков с информацией в карточке мероприятия

Scenario: Валидация дат предстоящих мероприятий
Given main page open
When User navigates to the "Events" tab
  And User clicks on "Upcoming events" button
  Then Event dates are greater than or equal to the current date
#Then Dates are within the current week
  #В блоке This week даты проведения мероприятий больше или равны текущей дате и находятся в пределах текущей недели.

Scenario: Просмотр прошедших мероприятий в Канаде
Given main page open
When User navigates to the "Events" tab
And User clicks on "Past Events" button
  Then The user clicks on "Location" in the filter box and selects "Canada" in the dropdown
  Then Event dates are less than or equal to the current date
Then Number of cards is equal to the counter on the "Past Events" button

Scenario: Просмотр предстоящих мероприятий
Given main page open
When User navigates to the "Events" tab
And User clicks on "Upcoming Events" button
  And User clicks on 1 card
  Then Goes to a page with detailed information about the event
Then Page displays blocks with
| sign up button |
| date and time  |
| event program  |
