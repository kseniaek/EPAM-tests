
#@withdrawal
Feature: Events
@test
  Scenario: Просмотр предстоящих мероприятий
Given main page open
  When User navigates to the "events" tab
  And User clicks on "Upcoming Events" button
  Then Page displays cards
  | upcoming events |
  Then Number of cards is equal to the counter on the "Upcoming Events" button

Scenario: Просмотр карточек мероприятий
Given main page open
When User navigates to the "events" tab
And User clicks on "Upcoming Events" button
Then Page displays cards
| upcoming events |
Then The card contains information about the event
  | venue                   |1|
  | language                |2|
  | event title             |3|
  | date of the event       |4|
  | registration information|5|
  | list of speakers        |6|
#Важно проверить порядок отображаемых блоков с информацией в карточке мероприятия

Scenario: Валидация дат предстоящих мероприятий
Given main page open
When User navigates to the "events" tab
And User clicks on "Upcoming Events" button
Then Page displays cards
| upcoming events |
Then In the "This week" block the dates of events are greater than or equal to the current date
Then Dates are within the current week
  #В блоке This week даты проведения мероприятий больше или равны текущей дате и находятся в пределах текущей недели.

Scenario: Просмотр прошедших мероприятий в Канаде
Given main page open
When User navigates to the "events" tab
And User clicks on "Past Events" button
  Then The user clicks on "Location" in the filter box and selects "Canada" in the dropdown
Then Page displays cards
| past events |
Then Number of cards is equal to the counter on the "Past Events" button

Scenario: Просмотр предстоящих мероприятий
Given main page open
When User navigates to the "events" tab
And User clicks on "Upcoming Events" button
  And User clicks on "any" card
  Then Goes to a page with detailed information about the event
Then Page displays blocks with
| sign up button |
| date and time  |
| event program  |
